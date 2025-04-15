package com.project.pathfinder.board.entity.Board;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("LOST_PROPERTY")
@NoArgsConstructor
public class LostPropertyBoardEntity extends BoardEntity {

}
