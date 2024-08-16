package com.study.spring_study.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.study.spring_study.domain.Member;

public class MemoryMemberRepository implements MemberRepository {

    
    private static Map<Long, Member> store = new HashMap<>(); //회원정보 객체 (HashMap은 Map의 자식 클래스)
    private static long sequence = 0L; // key 값 생성변수

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
            return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
        }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
        }


}
