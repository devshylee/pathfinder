package com.project.pathfinder.board.entity.Board;

import com.project.pathfinder.member.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "wanted_board")
public class WantedBoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "memberNickName", referencedColumnName = "memberNickName", nullable = false)
    private MemberEntity member;

    @NonNull
    private String boardTitle;
    private String boardContent;

    @Lob
    private String boardImage;

    @CreationTimestamp
    private LocalDateTime createDate;

    @NonNull
    private String classifiName;

    @NonNull
    private String lostArea;

    @NonNull
    private String lostPlace;

    @NonNull
    private String lostPlace_classifi;

    @NonNull
    private String request_cost;

    private LocalDate lostDate;

    @NonNull
    private String lostPropertyName;

    private String propertyColor;
    private String propertyChar;
    private String reporterPhone;
    private String etc;
}
