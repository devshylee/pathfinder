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
@Table(name = "acquire_property_board")
public class AcquirePropertyBoardEntity {

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
    private String acquirePropertyName;

    @NonNull
    private String acquireArea;

    @NonNull
    private String acquirePlace;

    @NonNull
    private String acquirePlace_classifi;

    @NonNull
    private LocalDate acquireDate;



    private String propertyColor;
    private String propertyType;

    private String reporterPhone;
    private String etc;

    private String acquirePlace_adress1;
    private String acquirePlace_adress2;
    private String acquirePlace_adress3;
    private String acquirePlace_adress4;
    private String acquirePlace_adress5;


}
