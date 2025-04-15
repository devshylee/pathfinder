package com.project.pathfinder.board.dto;


import com.project.pathfinder.board.entity.Board.BoardEntity;
import com.project.pathfinder.board.entity.Comment.CommentEntity;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CommentResponseDto {

    private Long boardId;
    private String boardTitle;
    private String boardContent;
    private String boardType;
    private List<CommentDto> comments;

    public CommentResponseDto(BoardEntity board, List<CommentEntity> comments) {
        this.boardId = board.getId();
        this.boardTitle = board.getBoardTitle();
        this.boardContent = board.getBoardContent();
        this.boardType = board.getClass().getSimpleName();
        this.comments = comments.stream()
                .map(CommentDto::new)
                .collect(Collectors.toList());
    }

    @Getter
    public static class CommentDto {
        private Long id;
        private String content;
        private String memberNickName;
        private String createdAt;

        public CommentDto(CommentEntity comment) {
            this.id = comment.getId();
            this.content = comment.getContent();
            this.memberNickName = comment.getMember().getMemberNickName();
            this.createdAt = comment.getCreatedAt().toString();
        }
    }
}

