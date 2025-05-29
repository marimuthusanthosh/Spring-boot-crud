package com.example.demoLibraryProject.controller;

import com.example.demoLibraryProject.DemoLibraryProjectApplication;
import com.example.demoLibraryProject.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = DemoLibraryProjectApplication.class)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookControllerIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private static Long createdBookId;

    @Test
    @Order(1)
    void createBook_success() throws Exception {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book.setIsbn("1234667890");
        book.setPublishedDate(LocalDate.of(2023, 1, 1));
        book.setAvailableCopies(5);

        String bookJson = objectMapper.writeValueAsString(book);

        String response = mockMvc.perform(MockMvcRequestBuilders.post("/books/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson))
                .andExpect(status().is2xxSuccessful()).toString();
    }



    @Test
    @Order(3)
    void updateBook_success() throws Exception {
        Book updatedBook = new Book();
        updatedBook.setTitle("Updated Book");
        updatedBook.setAuthor("Updated Author");
        updatedBook.setIsbn("0987654321");
        updatedBook.setPublishedDate(LocalDate.of(2024, 1, 1));
        updatedBook.setAvailableCopies(10);

        String bookJson = objectMapper.writeValueAsString(updatedBook);
           Long uid=6L;
        mockMvc.perform(MockMvcRequestBuilders.put("/books/" + uid)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @Order(4)
    void deleteBook_success_or_notFound() throws Exception {
        Long bookIdToDelete = 5L;

        mockMvc.perform(MockMvcRequestBuilders.delete("/books/{id}", bookIdToDelete))
                .andExpect(result -> {
                    int status = result.getResponse().getStatus();
                    Assertions.assertTrue(
                            status == 204 || status == 404|| status==200,
                            "Expected HTTP status 204 (No Content) or 404 (Not Found), but got: " + status
                    );
                });
    }


    @Test
    @Order(5)
    void getBookById_notFound() throws Exception {
        Long eid=1L;
        mockMvc.perform(MockMvcRequestBuilders.get("/books/" + eid))
                .andExpect(status().isOk());
    }
    @Test
    @Order(6)
    void getAllBooks_success() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/books"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }
    @Test
    @Order(7)
    void testSearchBooks() throws Exception {
        String searchKeyword = "code"; // adjust based on actual data in DB

        mockMvc.perform(MockMvcRequestBuilders.get("/books/search")
                        .param("q", searchKeyword)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }


}
