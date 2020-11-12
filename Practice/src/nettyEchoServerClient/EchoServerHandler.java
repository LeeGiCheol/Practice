package nettyEchoServerClient;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/*
	Channel? Server - Client간의 통신수단이다.
	특징 
	1. 채널은 비동기적으로 읽고 쓸 수 있다.
	2. 채널은 항상 버퍼에서부터 읽거나 버퍼로 쓴다.
	3. 읽고 쓰기를 동시에 할 수 있다.
	@Sharable Annotation은 여러 채널에서 Handler를 공유 할 수 있음을 나타낸다
*/
@Sharable	
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

	
	// 메세지가 들어올때마다 호출되는 메서드
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf in = (ByteBuf) msg;
		System.out.println("Server received : " + in.toString(CharsetUtil.UTF_8));
	}

	
	// channelRead 메서드가 처리완료 되었다는 것을 핸들러에게 통보하는 메서드
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
			.addListener(ChannelFutureListener.CLOSE);
	}

	
	// 읽기 작업 중 오류가 발생했을 겨우 호출 되는 메서드
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
	
}
