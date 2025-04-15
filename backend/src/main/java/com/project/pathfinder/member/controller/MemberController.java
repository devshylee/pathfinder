package com.project.pathfinder.member.controller;

import com.project.pathfinder.member.dto.LoginRequest;
import com.project.pathfinder.member.dto.MemberDTO;
import com.project.pathfinder.member.entity.MemberEntity;
import com.project.pathfinder.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("members")
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 에러 응답을 생성하는 메서드
    private Map<String, String> createErrorResponse(String message) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", message);
        return errorResponse;
    }

    // 회원정보 전체 리스트 출력
    @GetMapping
    public List<MemberEntity> getAllMembers() {
        return memberService.getAllMembers();
    }

    // ID에 해당하는 회원정보 출력
    @GetMapping("/{id}")
    public ResponseEntity getMemberById(@PathVariable Long id) {
        if(!memberService.getMemberById(id).isPresent()) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
        return ResponseEntity.ok(id);
    }

    // ID에 해당하는 회원정보 수정
    @PutMapping("/{id}")
    public ResponseEntity updateMember(@PathVariable Long id, @RequestBody MemberDTO memberDTO) {
        if (!memberService.getMemberById(id).isPresent()) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
        memberDTO.setId(id);
        memberService.saveMember(memberDTO);
        return ResponseEntity.ok(memberDTO);
    }

    // 회원가입
    @PostMapping
    public ResponseEntity<?> register(@RequestBody MemberDTO memberDTO) {
        try {
            System.out.println("회원가입 컨트롤러 실행됨");
            // 1. 중복 아이디 체크
            if (memberService.getMemberByMemberId(memberDTO.getMemberId()).isPresent()) {
                return (ResponseEntity<?>) ResponseEntity.badRequest();
            }

            // 2. 필수 정보가 null인지 체크
            if (memberDTO.getMemberId() == null || memberDTO.getMemberPw() == null || memberDTO.getMemberNickName() == null) {
                return (ResponseEntity<?>) ResponseEntity.badRequest();
            }

            // 3. 회원가입 로직 실행
            memberService.saveMember(memberDTO);
            return ResponseEntity.ok(memberDTO);
        }catch (Exception e) {
            System.out.println("ERROR!@#!@#!@#!@#!@#!@#@!@#@#!@#!@#!@#!@#!@#!@#!@#!@#!@#@!#!@#!@#@!#@!# : " + e.getMessage() );
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }

    // ID에 해당하는 회원 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id, MemberDTO memberDTO) {
        if (!memberService.getMemberById(id).isPresent()) {
            return (ResponseEntity<Void>) ResponseEntity.badRequest();
        }
        memberService.deleteMember(id);
        return (ResponseEntity<Void>) ResponseEntity.ok();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        try {
            // 사용자 ID로 회원 정보 조회
            Optional<MemberEntity> member = memberService.getMemberByMemberId(loginRequest.getMemberId());

            if (!member.isPresent()) {
                return ResponseEntity.badRequest().body(createErrorResponse("이메일 혹은 비밀번호가 틀렸습니다.")); // 실패 응답
            }

            // 비밀번호 비교
            MemberEntity memberEntity = member.get();
            if (passwordEncoder.matches(loginRequest.getMemberPw(), memberEntity.getMemberPw())) {
                session.setAttribute("memberId", memberEntity.getMemberId());
                session.setAttribute("memberPw", memberEntity.getMemberPw());
                return ResponseEntity.ok(memberEntity); // 로그인 성공 응답
            } else {
                return ResponseEntity.badRequest().body(createErrorResponse("이메일 혹은 비밀번호가 틀렸습니다.")); // 실패 응답
            }
        } catch (Exception e) {
            // 예외 발생 시 JSON 형식의 에러 메시지 반환
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(createErrorResponse("서버 오류가 발생했습니다. 오류 메시지: " + e.getMessage()));
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        // 세션에 로그인 정보가 있는지 확인
        if (session.getAttribute("memberId") != null) {
            session.invalidate();  // 세션 무효화
            return (ResponseEntity<?>) ResponseEntity.ok();
        } else {
            // 세션에 로그인 정보가 없을 경우
            return (ResponseEntity<?>) ResponseEntity.badRequest();

        }
    }

}
