package com.toyproject.wrightwyatt.service;

import com.toyproject.wrightwyatt.domain.Member;
import com.toyproject.wrightwyatt.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     * @param member
     * @return
     */
    public Member join(Member member) {
        // 중복 회원 검증
        validatieDuplicateMember(member);

        memberRepository.save(member);
        return member;
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