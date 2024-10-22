package com.project.pathfinder.board.entity.Board;

import com.project.pathfinder.board.entity.Comment.LostPropertyCommentEntity;
import com.project.pathfinder.member.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "lost_property_board")
public class LostPropertyBoardEntity {

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
    private String lostPropertyName;

    @NonNull
    private String lostArea;

    @NonNull
    private String lostPlace;

    @NonNull
    private String lostPlace_classifi;

    @NonNull
    private LocalDate lostDate;


    private String propertyColor;
    private String propertyType;

    private String reporterPhone;
    private String etc;

    private String lostPlace_adress1;
    private String lostPlace_adress2;
    private String lostPlace_adress3;
    private String lostPlace_adress4;
    private String lostPlace_adress5;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LostPropertyCommentEntity> comments = new ArrayList<>();
}

