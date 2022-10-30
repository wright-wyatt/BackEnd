package com.toyproject.wrightwyatt.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.toyproject.wrightwyatt.domain.Member;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<String, Member> store = new HashMap<>();
    private long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(String.valueOf(member.getId()));
        store.put(member.getId(), member);

        member.setPassword(String.valueOf(member.getPassword()));
        store.put(member.getPassword(), member);

        return member;
    }

    @Override
    public Optional<Member> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}