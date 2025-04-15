package com.project.pathfinder.board.entity.Board;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("LOST_PET")
@NoArgsConstructor
public class LostPetBoardEntity extends BoardEntity {

    private String petName; // 반려동물 이름
    private String petType; // 반려동물 타입 ex) 개, 고양이 등
    private String petChar; // 반려동물 특징

    @JsonCreator
    public LostPetBoardEntity(
            @JsonProperty("petName") String petName,
            @JsonProperty("petType") String petType,
            @JsonProperty("petChar") String petChar
    ) {
        this.petName = petName;
        this.petType = petType;
        this.petChar = petChar;
    }
}
