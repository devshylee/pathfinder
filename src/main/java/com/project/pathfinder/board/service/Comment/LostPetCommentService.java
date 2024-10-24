package com.project.pathfinder.board.service.Comment;

import com.project.pathfinder.board.entity.Board.AcquirePropertyBoardEntity;
import com.project.pathfinder.board.entity.Board.LostPetBoardEntity;
import com.project.pathfinder.board.entity.Comment.AcquirePropertyCommentEntity;
import com.project.pathfinder.board.entity.Comment.LostPetCommentEntity;
import com.project.pathfinder.board.entity.Comment.LostPropertyCommentEntity;
import com.project.pathfinder.board.repository.Board.AcquirePropertyBoardRepository;
import com.project.pathfinder.board.repository.Board.LostPetBoardRepository;
import com.project.pathfinder.board.repository.Comment.AcquirePropertyCommentRepository;
import com.project.pathfinder.board.repository.Comment.LostPetCommentRepository;
import com.project.pathfinder.board.repository.Comment.LostPropertyCommentRepository;
import com.project.pathfinder.member.entity.MemberEntity;
import com.project.pathfinder.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LostPetCommentService {

    @Autowired
    private LostPetCommentRepository commentRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private LostPetBoardRepository boardRepository;

    public List<LostPetCommentEntity> getAllComments() {
        return commentRepository.findAll(); // 모든 댓글 조회
    }

    public LostPetCommentEntity createComment(LostPetCommentEntity comment) {
        // memberNickName으로 작성자 조회
        Optional<MemberEntity> member = memberRepository.findByMemberNickName(comment.getMember().getMemberNickName());

        if (member.isEmpty()) {
            throw new RuntimeException("작성자가 존재하지 않습니다."); // 혹은 적절한 예외 처리
        }

        comment.setMember(member.get()); // DB에 존재하는 작성자 객체로 설정

        // 게시글 ID로 게시글 조회
        Optional<LostPetBoardEntity> board = boardRepository.findById(comment.getBoard().getId());

        if (board.isEmpty()) {
            throw new RuntimeException("게시글이 존재하지 않습니다."); // 혹은 적절한 예외 처리
        }

        comment.setBoard(board.get()); // DB에 존재하는 게시글 객체로 설정
        return commentRepository.save(comment);
    }

    public List<LostPetCommentEntity> getCommentsByBoardId(Long boardId) {
        return commentRepository.findByBoard_Id(boardId);
    }

    public LostPetCommentEntity updateComment(Long commentId, LostPetCommentEntity updatedComment) {
        updatedComment.setId(commentId);
        return commentRepository.save(updatedComment);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
