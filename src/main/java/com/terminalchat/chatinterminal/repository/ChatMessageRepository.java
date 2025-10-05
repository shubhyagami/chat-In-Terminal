package com.terminalchat.chatinterminal.repository;

import com.terminalchat.chatinterminal.entity.ChatMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessageEntity, Long> {
    List<ChatMessageEntity> findTop200ByRoomOrderByCreatedAtAsc(String room);

    @Query("select distinct c.room from ChatMessageEntity c order by c.room asc")
    List<String> findDistinctRooms();
}
