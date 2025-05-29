
package com.example.demoLibraryProject.service;

import com.example.demoLibraryProject.exception.MemberNotFoundException;
import com.example.demoLibraryProject.model.Member;
import com.example.demoLibraryProject.repository.MemberRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers() {
        return this.memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        return (Member)this.memberRepository.findById(id).orElseThrow(() -> {
            return new MemberNotFoundException(id);
        });
    }

    public Member createMember(Member member) {
        Long id = this.memberRepository.save(member);
        member.setId(id);
        return member;
    }

    public Member updateMember(Long id, Member member) {
        int updatedRows = this.memberRepository.update(id, member);
        if (updatedRows == 0) {
            throw new MemberNotFoundException(id);
        } else {
            member.setId(id);
            return member;
        }
    }

    public boolean deleteMember(Long id) {
        return this.memberRepository.deleteById(id) > 0;
    }
}
