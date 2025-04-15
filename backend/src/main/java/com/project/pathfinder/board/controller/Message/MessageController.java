//package com.project.pathfinder.board.controller.Message;
//
//import com.project.pathfinder.board.entity.Message.MessageEntity;
//import com.project.pathfinder.board.service.Message.MessageService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/messages")
//public class MessageController {
//
//    private final MessageService messageService;
//
//    public MessageController(MessageService messageService) {
//        this.messageService = messageService;
//    }
//
//    @PostMapping("/send")
//    public ResponseEntity<?> sendMessage(
//            @RequestParam String senderNickName,
//            @RequestParam String receiverNickName,
//            @RequestParam String content) {
//        try {
//            messageService.sendMessage(senderNickName, receiverNickName, content);
//            return ResponseEntity.ok("메시지 전송 성공");
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//
//
//    @GetMapping("/received")
//    public ResponseEntity<List<MessageEntity>> getReceivedMessages(@RequestParam String receiverNickName) {
//        List<MessageEntity> messages = messageService.getReceivedMessages(receiverNickName);
//        return ResponseEntity.ok(messages);
//    }
//
//
//    @GetMapping("/sent")
//    public ResponseEntity<List<MessageEntity>> getSentMessages(@RequestParam String senderNickName) {
//        List<MessageEntity> messages = messageService.getSentMessages(senderNickName);
//        return ResponseEntity.ok(messages);
//    }
//
//}
