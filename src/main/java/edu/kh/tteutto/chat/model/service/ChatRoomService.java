package edu.kh.tteutto.chat.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import edu.kh.tteutto.chat.model.vo.ChatMessage;
import edu.kh.tteutto.chat.model.vo.ChatRoom;

public interface ChatRoomService {

	/** 채팅방 목록 조회
	 * @param map 
	 * @return chatRoomList
	 */
	List<ChatRoom> chatRoomList(Map<String, Integer> map);

	/** 채팅방 열기
	 * @param room
	 * @return chatRoom
	 */
	Map<String, Object> openChatRoom(ChatRoom room);


	/** 채팅 내용 삽입
	 * @param cm
	 * @return result
	 */
	int insertMessage(ChatMessage cm);

	
	/** 채팅 내역(메세지) 조회
	 * @param chatRoom
	 * @return list
	 */
	List<ChatMessage> selectChatMessage(int chatRoomNo);



}
