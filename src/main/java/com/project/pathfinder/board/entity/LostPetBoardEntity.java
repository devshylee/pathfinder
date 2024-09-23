package com.project.pathfinder.board.entity;

import com.project.pathfinder.member.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "lost_pet_board")
public class LostPetBoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "memberNickName", referencedColumnName = "memberNickName", nullable = false)
    private MemberEntity member;

    private String boardTitle;
    private String boardContent;

    @Lob
    private String boardImage;

    private Timestamp createDate;
    private String classifiName;
    private String petName;
    private String findArea;
    private String findPlace;
}
