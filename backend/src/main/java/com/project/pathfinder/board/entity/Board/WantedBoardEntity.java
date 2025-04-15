package com.project.pathfinder.board.entity.Board;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("WANTED")
@NoArgsConstructor
public class WantedBoardEntity extends BoardEntity {

    @NonNull
    private String requestCost; // 답례금

    @JsonCreator
    public WantedBoardEntity(
            @JsonProperty("requestCost") String requestCost

    ) {
        this.requestCost = requestCost;
    }
}
