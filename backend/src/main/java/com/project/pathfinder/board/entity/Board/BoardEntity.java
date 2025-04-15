package com.project.pathfinder.board.entity.Board;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.project.pathfinder.member.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME, // JSON 데이터에 클래스 타입 정보를 추가
        include = JsonTypeInfo.As.PROPERTY, // JSON 속성으로 클래스 타입을 명시
        property = "board_type" // 타입 정보를 나타낼 JSON 속성 이름
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AcquirePropertyBoardEntity.class, name = "AcquireProperty"),
        @JsonSubTypes.Type(value = LostPropertyBoardEntity.class, name = "LostProperty"),
        @JsonSubTypes.Type(value = LostPetBoardEntity.class, name = "LostPet"),
        @JsonSubTypes.Type(value = WantedBoardEntity.class, name = "Wanted")
})
@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "board_type")
@NoArgsConstructor
@Table(name = "board")
public abstract class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "memberNickName", referencedColumnName = "memberNickName", nullable = false)
    private MemberEntity member; // 멤버닉네임

    @NonNull
    private String boardTitle; // 게시글 제목

    private String boardContent; // 게시글 내용

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] boardImage; // 이미지 BLOB

    @CreationTimestamp
    private LocalDateTime createDate; // 게시글 생성날짜

    @NonNull
    private String classifiName; // 분류이름 ex) 가방, 지갑, 전자기기 등등

    private String propertyName; // 물건이름
    private String propertyColor; // 물건색깔
    private String phone; // 습득,분실자 전화번호

    private String area; // 습득,분실 지역
    private String place; // 습득,분실 장소

    private String placeClassfi; // 장소구분 ex) ?
    private LocalDate date; // 습득,분실 날짜

    // 공통 주소 필드
    private String address; // 카카오지도에 표현할 주소 좌표

}
