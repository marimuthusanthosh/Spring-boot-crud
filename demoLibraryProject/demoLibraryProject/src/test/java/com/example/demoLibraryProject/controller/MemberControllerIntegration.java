package com.example.demoLibraryProject.controller;

import com.example.demoLibraryProject.model.Member;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MemberControllerIntegration {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    private static Long createdMemberId;

    public MemberControllerIntegration() {
    }

    @Test
    @Order(1)
    void testCreateMember() throws Exception {
        Member member = new Member();
        member.setName("John Doe");
        member.setPhone("1234567890");
        member.setRegisteredDate(LocalDate.now());
        this.mockMvc.perform(MockMvcRequestBuilders.post("/members", new Object[0]).contentType(MediaType.APPLICATION_JSON).content(this.objectMapper.writeValueAsString(member))).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    @Order(2)
    void testGetMemberById() throws Exception {
        Long existingmemberId = 3L;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/members/{id}", new Object[]{existingmemberId})).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Order(3)
    void testUpdateMember() throws Exception {
        Member updated = new Member();
        updated.setName("John Updated");
        updated.setPhone("0987654321");
        updated.setRegisteredDate(LocalDate.now());
        Long updatedmemberId = 15L;
        this.mockMvc.perform(MockMvcRequestBuilders.put("/members/{id}", new Object[]{updatedmemberId}).contentType(MediaType.APPLICATION_JSON).content(this.objectMapper.writeValueAsString(updated))).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Order(4)
    void testDeleteMember() throws Exception {
        Long deletememberId = 9L;
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/members/{id}", new Object[]{deletememberId})).andExpect((result) -> {
            int status = result.getResponse().getStatus();
            Assertions.assertTrue(status == 204 || status == 404, "Expected 204 No Content or 404 Not Found but got: " + status);
        });
    }

    @Test
    @Order(5)
    void testGetMemberNotFound() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/members/{id}", new Object[]{999999L})).andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @Order(6)
    void testGetAllMembers() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/members", new Object[0])).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.jsonPath("$", new Object[0]).isArray());
    }
}
