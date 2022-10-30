package com.toyproject.wrightwyatt.service;

import com.toyproject.wrightwyatt.domain.Member;
import com.toyproject.wrightwyatt.repository.MemberRepository;
import com.toyproject.wrightwyatt.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원가입
     * @param member
     * @return
     */
    public String join(Member member) {
        // 중복 회원 검증
        validatieDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }
    private void validatieDuplicateMember(Member member) {
        memberRepository.findById(member.getId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     * @return
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 개별 회원 조회
     * @param memberId
     * @return
     */
    public Optional<Member> findOne(String memberId) {
        return memberRepository.findById(memberId);
    }
}