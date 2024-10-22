package com.project.pathfinder.board.entity.Comment;

import com.project.pathfinder.board.entity.Board.AcquirePropertyBoardEntity;
import com.project.pathfinder.member.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "acquire_property_comments")
public class AcquirePropertyCommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "memberNickName", referencedColumnName = "memberNickName", nullable = false)
    private MemberEntity member;  // 댓글 작성자

    @ManyToOne
    @JoinColumn(name = "id", nullable = false, insertable = false, updatable = false)
    private AcquirePropertyBoardEntity board;  // 댓글이 달린 게시글

    @NonNull
    private String content;  // 댓글 내용

    @CreationTimestamp
    private LocalDateTime createDate;  // 댓글 작성 시간
}
