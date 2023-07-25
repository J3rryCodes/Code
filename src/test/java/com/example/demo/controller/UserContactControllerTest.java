package com.example.demo.controller;

import com.example.demo.data.UserContact;
import com.example.demo.dto.UserContactRequest;
import com.example.demo.service.UserContactService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserContactControllerTest {


    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserContactService userContactService;

    @Test
    public void testGetAllUserContact_expect_statusCode_OK() throws Exception {
        List<UserContact> userContactList = new ArrayList<>();
        Mockito.when(userContactService.getAllUserDetails()).thenReturn(userContactList);
        this.mockMvc.perform(get("/api/userContact/")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testAddUserContactDetails_giveValidUserContactRequest_expect_statusCode_OK() throws Exception {
        UserContactRequest userContactRequest = new UserContactRequest("jerin","address","1212121212","asdasd@qsad.com");
        Mockito.when(userContactService.addUserContactDetails(userContactRequest)).thenReturn(true);
        this.mockMvc.perform(post("/api/userContact/").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userContactRequest)
                )).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void test_name()throws Exception {
        UserContactRequest userContactRequest = new UserContactRequest("jerin","address","1212121212","asdasd@qsad.com");
        Mockito.when(userContactService.deleteUserDetailsById(Mockito.any())).thenReturn(true);
        this.mockMvc.perform(delete("/api/userContact/c6034bcf-d989-4704-8ec8-e638122dd236")
                ).andDo(print()).andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
