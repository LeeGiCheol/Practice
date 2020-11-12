package nettyEchoServerClient;

import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EchoServer {
	private final int port;
	
	public static void main(String[] args) throws InterruptedException {
		int port = 8090;
		new EchoServer(port).start();
	}
	
	public EchoServer(int port) {
		this.port = port;
	}
	
	private void start() throws InterruptedException {
		final EchoServerHandler serverHandler = new EchoServerHandler();

		// NIO 처리를 다루는 이벤트 루프 인스턴스 생성
		EventLoopGroup group = new NioEventLoopGroup();
		
		try {
			// ServerBootstrap 인스턴스 생성
			// 서버 Channel을 셋팅할 수 있는 클래스
			ServerBootstrap b = new ServerBootstrap();
		
			b.group(group)
				// Nio 전송 채널을 사용 하도록 셋팅
				.channel(NioServerSocketChannel.class)
				// 서버 포트 주소 설정
				.localAddress(new InetSocketAddress(port))
				// child 이벤트 핸들러를 설정
				.childHandler(new ChannelInitializer<SocketChannel>() {

					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						// serverHandler를 pipeline으로 설정한다.
						// pipeline은 Channel에서 발생한 이벤트가 이동하는 통로이다.
						// Channel에 드나드는 inbound / outbound 이벤트 처리 
						ch.pipeline().addLast(serverHandler);
					}
				});
			
			// 서버를 비동기식으로 binding한다. sync()는 binding이 완료되기를 대기한다.
			ChannelFuture f = b.bind().sync();
			
			// 채널의 closeFuture를 얻고 완료될때까지 현재 스레드를 블로킹한다.
			/* 블로킹이란? 어떤 시스템 콜을 호출했을때 네트워크 시스템 동작이 완료할때까지 그 시스템 콜에서 프로세스가 멈추는 것. 
			   I/O시 처리될 때까지 기다려야하기 때문에 비동기적인 작업 수행 불가능하다.
			 */
			f.channel().closeFuture().sync();
		}finally {
			
			// EventLoopGroup를 종료하고 모든 리소스를 해제한다.
			group.shutdownGracefully().sync();
		}
	}
}