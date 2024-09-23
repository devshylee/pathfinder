package com.project.pathfinder.board.entity;

import com.project.pathfinder.member.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "wanted_board")
public class WantedBoardEntity {

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
    private String lostPropertyName;
    private String lostArea;
    private String lostPlace;
}
