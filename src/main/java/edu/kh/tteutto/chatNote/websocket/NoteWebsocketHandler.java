package edu.kh.tteutto.chatNote.websocket;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import edu.kh.tteutto.chatNote.model.service.ChatNoteService;
import edu.kh.tteutto.chatNote.model.vo.ChatNote;
import edu.kh.tteutto.member.model.vo.Member;

public class NoteWebsocketHandler extends TextWebSocketHandler {
	
	@Autowired
	private ChatNoteService service;
	
	private Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<WebSocketSession>());
	
	// synchronizedSet : 동기화된 Set (HashSet은 비동기)
		// 왜? 멀티 쓰레드 환경에서 하나의 컬렉션 요소에 여러 쓰레드가 접근하면 
		// 충돌 문제가 발생 할 수 있으므로, 동기화 시켜 줄을 세움
		
		
		// 클라이언트와 연결이 완료되고, 통신할 준비가 되면 실행
		@Override
		public void afterConnectionEstablished(WebSocketSession session) throws Exception {
			// Established : 확립 된
			
			// WebSockSession : 서버간 전이둥 통신 담당 객체
			// -> 웹소켓 요청을 보낸 클라이언트와 통신할 수 있는 객체
			sessions.add(session);
			// 웹소켓 서버와 통신하는 클라이언트의 정보를 한곳에 모아둠
			// (웹소켓 통신을 요청한 클라이언트들의 만남의 광장)
			
		}
		
		
		// 클라이언트로 부터 웹소켓 통신으로 텍스트 메세지를 전달 받은 경우 실행
		@Override
		protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
			
			ObjectMapper objectMapper = new ObjectMapper();
			ChatNote cm = objectMapper.readValue(message.getPayload(), ChatNote.class);
			
			int result = 0;
			
			if(cm.getFlag() == 0) {
				// 쪽지 보내기
				result = service.sendNote(cm);
				
			}
			
			if(result > 0) {
				for(WebSocketSession wss : sessions) {
					
					int loginMemberNo = ((Member)wss.getAttributes().get("loginMember")).getMemberNo();
					
					if(loginMemberNo == cm.getMemberNo()) {
						
						int count = service.selectNoteAlarm(cm);
						int count2 = service. selectChatAlarm(cm);
						int sum = count + count2;
						
						wss.sendMessage(new TextMessage(new Gson().toJson(sum)));
					}
				}
			}
			
			
			
			
		}
		
		
		// 클라이언트와 연결이 종료되면 실행
		@Override
		public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
			
			// sessions에서 웹소켓 연결을 종료한 클라이언트 세션을 삭제
			sessions.remove(session);

		}

}
