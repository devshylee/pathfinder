//package com.project.pathfinder.board.entity.Message;
//
//import com.project.pathfinder.member.entity.MemberEntity;
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.hibernate.annotations.CreationTimestamp;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@Table(name = "messages")
//public class MessageEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "sender_id", nullable = false)
//    private MemberEntity sender;
//
//    @ManyToOne
//    @JoinColumn(name = "receiver_id", nullable = false)
//    private MemberEntity receiver;
//
//    @Column(nullable = false)
//    private String content;
//
//    @CreationTimestamp
//    private LocalDateTime sentAt;
//}
