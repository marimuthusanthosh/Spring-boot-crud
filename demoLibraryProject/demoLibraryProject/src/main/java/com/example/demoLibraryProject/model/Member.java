package com.example.demoLibraryProject.model;

import java.time.LocalDate;
import java.util.Objects;

public class Member {
    private Long id;
    private String name;
    private String phone;
    private LocalDate registeredDate;

    public Member() {
    }

    public Member(Long id, String name, String phone, LocalDate registeredDate) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.registeredDate = registeredDate;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getRegisteredDate() {
        return this.registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String toString() {
        Long var10000 = this.id;
        return "Member{id=" + var10000 + ", name='" + this.name + "', phone='" + this.phone + "', registeredDate=" + String.valueOf(this.registeredDate) + "}";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Member)) {
            return false;
        } else {
            Member member = (Member)o;
            return Objects.equals(this.id, member.id) && Objects.equals(this.name, member.name) && Objects.equals(this.phone, member.phone) && Objects.equals(this.registeredDate, member.registeredDate);
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.name, this.phone, this.registeredDate});
    }
}
