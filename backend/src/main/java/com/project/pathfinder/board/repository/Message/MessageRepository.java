//package com.project.pathfinder.board.repository.Message;
//
//import com.project.pathfinder.board.entity.Message.MessageEntity;
//import com.project.pathfinder.member.entity.MemberEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
//    List<MessageEntity> findByReceiverAndIsReadFalse(MemberEntity receiver); // 읽지 않은 메시지
//    List<MessageEntity> findBySender(MemberEntity sender); // 보낸 메시지
//    List<MessageEntity> findByReceiver(MemberEntity receiver); // 받은 메시지
//}
//
