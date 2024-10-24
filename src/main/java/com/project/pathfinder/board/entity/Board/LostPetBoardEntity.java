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
@Table(name = "lost_pet_board")
public class LostPetBoardEntity {

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
    @Column(columnDefinition = "MEDIUMBLOB") // MEDIUMBLOB으로 지정
    private byte[] boardImage;

    @CreationTimestamp
    private LocalDateTime createDate;

    @NonNull
    private String classifiName;

    private String petName;

    @NonNull
    private String findArea;

    @NonNull
    private LocalDate lostDate;

    @NonNull
    private String findPlace;

    private String petType;
    private String petColor;

    private String petChar;
    private String reporterPhone;
    private String etc;

    private String lostPlace_adress1;
    private String lostPlace_adress2;
    private String lostPlace_adress3;
    private String lostPlace_adress4;
    private String lostPlace_adress5;
}
