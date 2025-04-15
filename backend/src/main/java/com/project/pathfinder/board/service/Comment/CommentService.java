package com.project.pathfinder.board.service.Comment;

import com.project.pathfinder.board.entity.Board.BoardEntity;
import com.project.pathfinder.board.entity.Comment.CommentEntity;
import com.project.pathfinder.board.repository.Board.AcquirePropertyBoardRepository;
import com.project.pathfinder.board.repository.Board.LostPetBoardRepository;
import com.project.pathfinder.board.repository.Board.LostPropertyBoardRepository;
import com.project.pathfinder.board.repository.Board.WantedBoardRepository;

import com.project.pathfinder.board.repository.Comment.CommentRepository;
import com.project.pathfinder.member.entity.MemberEntity;
import com.project.pathfinder.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final MemberService memberService;
    private final List<? extends JpaRepository<? extends BoardEntity, Long>> boardRepositories;

    // 댓글 작성
    public CommentEntity createComment(String boardType, Long boardId, String memberNickName, String content) {
        // 게시글 조회
        BoardEntity board = findBoardByIdAndType(boardType, boardId);
        if (board == null) {
            throw new IllegalArgumentException("유효하지 않은 게시글입니다.");
        }

        // 사용자 조회
        Optional<MemberEntity> member = memberService.getMemberByMemberNickName(memberNickName);
        if (member.isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 사용자입니다.");
        }

        // 댓글 저장
        CommentEntity comment = new CommentEntity();
        comment.setBoard(board);
        comment.setMember(member.get());
        comment.setContent(content);
        return commentRepository.save(comment);
    }

    // 댓글 조회
    public List<CommentEntity> getCommentsByBoard(Long boardId) {
        return commentRepository.findByBoardId(boardId);
    }

    // 특정 게시판에서 게시글 ID로 조회
    public BoardEntity findBoardByIdAndType(String boardType, Long boardId) {
        switch (boardType) {
            case "AcquireProperty":
                return ((AcquirePropertyBoardRepository) boardRepositories.get(0)).findById(boardId).orElse(null);
            case "LostProperty":
                return ((LostPropertyBoardRepository) boardRepositories.get(1)).findById(boardId).orElse(null);
            case "LostPet":
                return ((LostPetBoardRepository) boardRepositories.get(2)).findById(boardId).orElse(null);
            case "Wanted":
                return ((WantedBoardRepository) boardRepositories.get(3)).findById(boardId).orElse(null);
            default:
                throw new IllegalArgumentException("유효하지 않은 게시판 유형입니다.");
        }
    }

}
