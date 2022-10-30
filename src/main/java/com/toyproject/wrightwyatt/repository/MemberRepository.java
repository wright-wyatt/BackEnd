package com.toyproject.wrightwyatt.repository;

import java.util.List;
import java.util.Optional;

import com.toyproject.wrightwyatt.domain.Member;

public interface MemberRepository {
    /* 회원가입 */
    Member save(Member member);

    /* ID찾기 */
    Optional<Member> findById(String id);

    /* 모든 회원 리스트 출력 */
    List<Member> findAll();
}
