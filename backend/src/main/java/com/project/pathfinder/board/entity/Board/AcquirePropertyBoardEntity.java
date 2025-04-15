package com.project.pathfinder.board.entity.Board;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("ACQUIRE_PROPERTY")
@NoArgsConstructor
public class AcquirePropertyBoardEntity extends BoardEntity {

}
