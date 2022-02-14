package edu.kh.tteutto.chat.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import edu.kh.tteutto.chat.model.dao.ChatRoomDAO;
import edu.kh.tteutto.chat.model.vo.ChatMessage;
import edu.kh.tteutto.chat.model.vo.ChatRoom;
import edu.kh.tteutto.chatNote.model.vo.ChatNote;
import edu.kh.tteutto.common.Util;

@Service
public class ChatRoomServiceImpl implements ChatRoomService{
   
   @Autowired
   private ChatRoomDAO dao;

   // 채팅방 목록조회
   @Override
   public List<ChatRoom> chatRoomList(Map<String, Integer> map) {
      return dao.chatRoomList(map);
   }

   // 강사번호, 강사명, 이전 채팅 기록이 있으면 채팅방 번호 조회
   @Override
   public Map<String, Object>  openChatRoom(ChatRoom room) {
      return dao.selectChatRoomNo(room);
   }

   // 채팅 내역(메세지) 조회
   @Override
   public List<ChatMessage> selectChatMessage(int chatRoomNo) {
      // 1. 파라미터로 전달받은 방번호와 일치하는 방이 DB에 있는지 검사
            int result = dao.existsChatRoom(chatRoomNo);
            
            // 2-1. 방이 있는 경우 
            if( result > 0) {
               
//               // 2-1-1. CHAT_ROOM_JOIN 테이블에 삽입 DAO 호출
//               try {
//                  
//                  dao.joinChatRoom(chatRoom); //재입장 시 유니크 제약조건 위배 예외 발생
//               }catch(Exception e) {} //->아무것도 적지않고 처리
//               
               
               // 2-1-2. 해당 방번호와 일치하는 모든 메세지를 CHAT_MESSAGE 테이블에서 조회
               return dao.selectChatMessage(chatRoomNo);
               
            }else { // 2-2. 방이 없는 경우
               return null;
            }
   
   }

   
   //채팅 내용 삽입
   @Override
   public int insertMessage(ChatMessage cm) {
      
      cm.setMsgContent( Util.XSS(cm.getMsgContent()) );
      cm.setMsgContent( Util.changeNewLine(cm.getMsgContent()) );
      
      return dao.insertMessage(cm);
   }

   // 채팅방 정보 조회
   @Override
   public ChatRoom selectChatRoom(int chatRoomNo) {
      return dao.selectChatRoom(chatRoomNo);
   }

   // 채팅방 생성
   @Override
   public int insertChatRoom(ChatMessage cm) {
      return dao.insertChatRoom(cm);
   }

   
   // 쪽지 조회
   @Override
   public List<ChatNote> selectMessageList(int memberNo) {
      return dao.selectMessageList(memberNo);
   }

   // 채팅 알림 
   @Override
   public int sendAlarm(ChatMessage cm) {
      return dao.sendAlarm(cm);
   }
   
   @Override
   public Map<String, Object> openChatRoom2(Map map1) {
      System.out.println("map: " + dao.openChatRoom2(map1));
      return dao.openChatRoom2(map1);
   }

   
   // 채팅 알림2
   @Override
   public int sendAlarm2(ChatMessage cm) {
      return dao.sendAlarm2(cm);
   }
   
   // 채팅 방 번호 조회
   @Override
   public int selectChatRoomNo(Map<String, Object> map) {
      return dao.selectChatRoomNo3(map);
   }
   
   // 채팅 방 카운트
   @Override
   public int countChatRoomNo(Map<String, Object> map) {
      return dao.countChatRoomNo(map);
   }

   // 채팅 상대방 조회
   @Override
   public int selectOtherMember(ChatMessage cm) {
      return dao.selectOtherMember(cm);
   }
   
   // 채팅 방 카운트
   @Override
   public int countChatRoomNo2(ChatMessage cm) {
      return dao.countChatRoomNo2(cm);
   }
   
   // 채팅 방 번호 조회
   @Override
   public int selectChatRoomNo2(ChatMessage cm) {
      return dao.selectChatRoomNo2(cm);
   }
   
   
   
}