package com.andrewpqc.readinglist.controller;

import com.andrewpqc.readinglist.domain.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookControllerTests {
    private MockMvc mvc;

    @Autowired
    private BookRepository bookRepository;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new BookController(bookRepository)).build();
    }

    @Test
    public void testCreateBook() throws Exception {
        mvc.perform(get("/api/v1.0/book/andrew/andrewBook1/").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Ok"))
                .andDo(MockMvcResultHandlers.print()).andReturn();

        mvc.perform(get("/api/v1.0/book/andrew/andrewBook2/").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Ok"))
                .andDo(MockMvcResultHandlers.print()).andReturn();

        mvc.perform(get("/api/v1.0/book/bob/bobBook1/").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Ok"))
                .andDo(MockMvcResultHandlers.print()).andReturn();
    }


    @Test
    public void testGetBooks() throws Exception {
        mvc.perform(get("/api/v1.0/book/").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();
    }

    @Test
    public void testGetBooksByAuthor() throws Exception {
        mvc.perform(get("/api/v1.0/book/andrew/").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();
    }


}