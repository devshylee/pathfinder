package com.project.pathfinder.member.service;

import com.project.pathfinder.member.dto.MemberDTO;
import com.project.pathfinder.member.entity.MemberEntity;
import com.project.pathfinder.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<MemberEntity> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<MemberEntity> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public Optional<MemberEntity> getMemberByMemberId(String memberId) {
        return memberRepository.findByMemberId(memberId);
    }

    public void saveMember(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
