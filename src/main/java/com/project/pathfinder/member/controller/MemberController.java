package com.project.pathfinder.member.controller;

import com.project.pathfinder.member.HttpResponse.DefaultRes;
import com.project.pathfinder.member.HttpResponse.ResponseMessage;
import com.project.pathfinder.member.HttpResponse.StatusCode;
import com.project.pathfinder.member.dto.MemberDTO;
import com.project.pathfinder.member.entity.MemberEntity;
import com.project.pathfinder.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/members")
public class MemberController {

    @Autowired
    MemberService memberService;

    // 회원정보 전체 리스트 출력
    @GetMapping
    public List<MemberEntity> getAllMembers() {
        return memberService.getAllMembers();
    }

    // ID에 해당하는 회원정보 출력
    @GetMapping("/{id}")
    public ResponseEntity getMemberById(@PathVariable Long id) {
        if(!memberService.getMemberById(id).isPresent()) {
            return new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, ResponseMessage.MEMBER_READ_FAIL, null), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.MEMBER_READ_SUCCESS, memberService.getMemberById(id)), HttpStatus.OK);
    }

    // ID에 해당하는 회원정보 수정
    @PutMapping("/{id}")
    public ResponseEntity updateMember(@PathVariable Long id, @RequestBody MemberDTO memberDTO) {
        if (!memberService.getMemberById(id).isPresent()) {
            return new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, ResponseMessage.MEMBER_UPDATE_FAIL, null), HttpStatus.BAD_REQUEST);
        }
        memberDTO.setId(id);
        memberService.saveMember(memberDTO);
        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.MEMBER_UPDATE_SUCCESS, memberDTO), HttpStatus.OK);
    }

    // 회원가입
    @PostMapping
    public ResponseEntity<?> register(@RequestBody MemberDTO memberDTO) {
        try {
            // 1. 중복 아이디 체크
            if (memberService.getMemberByMemberId(memberDTO.getMemberId()).isPresent()) {
                return new ResponseEntity<>(
                        DefaultRes.res(StatusCode.BAD_REQUEST, ResponseMessage.MEMBER_POST_DUPLICATE, null),
                        HttpStatus.BAD_REQUEST
                );
            }

            // 2. 필수 정보가 null인지 체크
            if (memberDTO.getMemberId() == null || memberDTO.getMemberPw() == null || memberDTO.getMemberNickName() == null) {
                return new ResponseEntity(
                        DefaultRes.res(StatusCode.BAD_REQUEST, ResponseMessage.MEMBER_POST_MISSING_INFO, null),
                        HttpStatus.BAD_REQUEST
                );
            }

            // 3. 회원가입 로직 실행
            memberService.saveMember(memberDTO);
            return new ResponseEntity<>(
                    DefaultRes.res(StatusCode.OK, ResponseMessage.MEMBER_POST_SUCCESS, memberDTO),
                    HttpStatus.OK
            );
        }catch (Exception e) {
            System.out.println("ERROR!!! : " + e.getStackTrace()[0]);
            return new ResponseEntity<>(
                    DefaultRes.res(StatusCode.BAD_REQUEST, ResponseMessage.MEMBER_POST_FAIL, memberDTO),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    // ID에 해당하는 회원 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id, MemberDTO memberDTO) {
        if (!memberService.getMemberById(id).isPresent()) {
            return new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, ResponseMessage.MEMBER_DELETE_FAIL, null), HttpStatus.BAD_REQUEST);
        }
        memberService.deleteMember(id);
        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.MEMBER_DELETE_SUCCESS, memberDTO), HttpStatus.OK);
    }

}
