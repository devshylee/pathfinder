//package com.project.pathfinder.board.service.Message;
//
//import com.project.pathfinder.board.entity.Message.MessageEntity;
//import com.project.pathfinder.board.repository.Message.MessageRepository;
//import com.project.pathfinder.member.entity.MemberEntity;
//import com.project.pathfinder.member.repository.MemberRepository;
//
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class MessageService {
//
//    private final MessageRepository messageRepository;
//    private final MemberRepository memberRepository;
//
//    public MessageService(MessageRepository messageRepository, MemberRepository memberRepository) {
//        this.messageRepository = messageRepository;
//        this.memberRepository = memberRepository;
//    }
//
//    public void sendMessage(String senderNickName, String receiverNickName, String content) {
//        MemberEntity sender = memberRepository.findByMemberNickName(senderNickName)
//                .orElseThrow(() -> new IllegalArgumentException("발신자를 찾을 수 없습니다."));
//        MemberEntity receiver = memberRepository.findByMemberNickName(receiverNickName)
//                .orElseThrow(() -> new IllegalArgumentException("수신자를 찾을 수 없습니다."));
//
//        MessageEntity message = new MessageEntity();
//        message.setSender(sender);
//        message.setReceiver(receiver);
//        message.setContent(content);
//
//        messageRepository.save(message);
//    }
//
//    public List<MessageEntity> getReceivedMessages(String receiverNickName) {
//        MemberEntity receiver = memberRepository.findByMemberNickName(receiverNickName)
//                .orElseThrow(() -> new IllegalArgumentException("수신자를 찾을 수 없습니다."));
//
//        return messageRepository.findByReceiver(receiver);
//    }
//
//    public List<MessageEntity> getSentMessages(String senderNickName) {
//        MemberEntity sender = memberRepository.findByMemberNickName(senderNickName)
//                .orElseThrow(() -> new IllegalArgumentException("발신자를 찾을 수 없습니다."));
//
//        return messageRepository.findBySender(sender);
//    }
//
//}
