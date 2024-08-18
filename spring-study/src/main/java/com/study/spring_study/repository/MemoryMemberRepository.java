package com.study.spring_study.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.study.spring_study.domain.Member;

public class MemoryMemberRepository implements MemberRepository {

    
    private static Map<Long, Member> store = new HashMap<>(); //회원정보 객체 (HashMap은 Map의 자식 클래스)
    private static long sequence = 0L; // 리포지토리 key 변수 (DB Table의 PK 역할)

    // 1. 회원 생성
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    // 2. 회원 Id로 조회
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    // 3. 회원 이름으로 조회
    @Override
    public Optional<Member> findByName(String name) {
            return store.values().stream()  // .stream() : Map의 내부반복 메서드
                .filter(member -> member.getName().equals(name))
                .findAny();
        }
        
    // 4. 모든 회원조회
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    // 5. 모든 회원삭제
    public void clearStore() {
        store.clear();
        }
        
}
