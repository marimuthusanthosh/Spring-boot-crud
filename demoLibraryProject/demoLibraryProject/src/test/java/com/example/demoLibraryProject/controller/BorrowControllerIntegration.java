package com.example.demoLibraryProject.controller;

import com.example.demoLibraryProject.model.Borrow;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
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
public class BorrowControllerIntegration {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    private static final Long EXISTING_MEMBER_ID = 2L;
    private static final Long EXISTING_BOOK_ID = 1L;
    private static Long createdBorrowId;

    public BorrowControllerIntegration() {
    }

    @Test
    @Order(1)
    void testCreateBorrow() throws Exception {
        Borrow borrow = new Borrow();
        borrow.setMemberId(EXISTING_MEMBER_ID);
        borrow.setBookId(EXISTING_BOOK_ID);
        borrow.setBorrowedDate(LocalDate.now());
        borrow.setDueDate(LocalDate.now().plusWeeks(2L));
        this.mockMvc.perform(MockMvcRequestBuilders.post("/borrows/add", new Object[0]).contentType(MediaType.APPLICATION_JSON).content(this.objectMapper.writeValueAsString(borrow))).andExpect(MockMvcResultMatchers.status().isOk()).andDo((result) -> {
        });
    }

    @Test
    @Order(2)
    void testGetAllBorrows() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/borrows", new Object[0])).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.jsonPath("$", new Object[0]).isArray());
    }

    @Test
    @Order(3)
    void testGetBorrowById_NotFound() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/borrows/{id}", new Object[]{999999L})).andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    @Order(4)
    void testReturnBook() throws Exception {
        if (createdBorrowId != null) {
            this.mockMvc.perform(MockMvcRequestBuilders.put("/borrows/{id}/return", new Object[]{createdBorrowId})).andExpect(MockMvcResultMatchers.status().isOk());
        }

    }
}
