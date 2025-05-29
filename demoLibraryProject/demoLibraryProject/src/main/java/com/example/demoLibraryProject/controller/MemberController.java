package com.example.demoLibraryProject.controller;

import com.example.demoLibraryProject.model.Member;
import com.example.demoLibraryProject.service.MemberService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/members"})
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = this.memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
        Member member = this.memberService.getMemberById(id);
        return ResponseEntity.ok(member);
    }

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        Member created = this.memberService.createMember(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member member) {
        Member updated = this.memberService.updateMember(id, member);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<String> deleteMember(@PathVariable Long id) {
        boolean deleted = this.memberService.deleteMember(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.ok("Member deleted Successfully");
    }
}
