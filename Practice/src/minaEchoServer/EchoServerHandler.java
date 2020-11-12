package minaEchoServer;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class EchoServerHandler extends IoHandlerAdapter {

	// 오류가 있을 경우
	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		cause.printStackTrace();
	}

	// 메시지를 받았을 경우
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		// 메시지로 받은 데이터를 String형으로 변경하여 세션으로 전송한다.
		session.write(message.toString());
	}

	// 세션이 생겼을 경우 = 클라이언트와 연결되었을 경우
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		System.out.println("[Client] Connect " + session.getRemoteAddress());
	}

	// 세션이 닫혔을 경우 = 클라이언트와 연결이 끊겼을 경우
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("[Client] Disconnect " + session.getRemoteAddress());
	}

	// 세션이 유휴 상태에 있을 경우 (유휴 = 컴퓨터 처리 장치에서 유휴 또는 아이들(idle)은 어떠한 프로그램에 의해서도 사용되지 않는 상태를 말한다.)
	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		System.out.println("IDLE " + session.getIdleCount(status));
	}
	
}
