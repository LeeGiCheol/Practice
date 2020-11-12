// 예제 출처 - https://parkhyeokjin.github.io/netty/2019/12/22/netty-chap1.html
// 감사합니다.

package nettyEchoServerClient;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

@Sharable
public class EchoClientHandler extends ChannelInboundHandlerAdapter {

	
	// 서버로 연결이 만들어지면 channelActie 메서드가 호출된다.
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!", CharsetUtil.UTF_8));
	}

	
	// 서버에서 메세지를 수신하면 channelRead 메서드가 호출된다.
	public void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
		System.out.println("client received : " + msg.toString(CharsetUtil.UTF_8));
	}

	
	// 예외 발생 시 exceptionCaught 메서드가 호출된다.
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
	
	

}
