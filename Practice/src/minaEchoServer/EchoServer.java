/*

	1. I/O Service 생성
	
	2. Filter Chain 생성
	
	3. I/O Handler 생성 및 비지니스 로직 구현

	// 코드 출처 https://theeye.pe.kr/archives/710
	// 감사합니다. 
	
	telnet을 통해 접속을 해봤다. (brew로 설치)
		-> telnet > open
			(to) 127.0.0.1 8090
			
	명령어를 입력하니 접속이 되었고, echoServer가 정상적으로 작동했다.
	IDLE도 정상 작동했다.

 */

package minaEchoServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class EchoServer {
	
	private static final int PORT = 8090;
	
	public static void main(String[] args) throws IOException {
		// Non-Blocking IO를 생성
		IoAcceptor acceptor = new NioSocketAcceptor();
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		
		// 인코딩 필터 등록
		acceptor.getFilterChain()
			.addLast("codec", 
					new ProtocolCodecFilter(
							new TextLineCodecFactory(Charset.forName("UTF-8"))));
		
		// 핸들러 추가, 버퍼와(2048) 유휴시간 정의(10초), 포트 설정
		acceptor.setHandler(new EchoServerHandler());
		acceptor.getSessionConfig().setReadBufferSize(2048);
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
		acceptor.bind(new InetSocketAddress(PORT));
	}
}
