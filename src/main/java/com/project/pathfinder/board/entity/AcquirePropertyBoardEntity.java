package com.project.pathfinder.board.entity;

import com.project.pathfinder.member.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "acquire_property_board")
public class AcquirePropertyBoardEntity {

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
    private String acquirePropertyName;
    private String acquireArea;
    private String acquirePlace;
}
