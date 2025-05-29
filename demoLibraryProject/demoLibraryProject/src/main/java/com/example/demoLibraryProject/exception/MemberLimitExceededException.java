package com.example.demoLibraryProject.exception;

public class MemberLimitExceededException extends RuntimeException {
    public MemberLimitExceededException(Long memberId) {
        super("Member with ID " + memberId + " has exceeded the borrowing limit.");
    }
}
