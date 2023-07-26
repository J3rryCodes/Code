/* (C)2023 */
package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.data.UserContact;
import com.example.demo.dto.UserContactRequest;
import com.example.demo.service.UserContactService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class UserContactControllerTest {

    @Autowired private MockMvc mockMvc;
    @MockBean private UserContactService userContactService;

    @Test
    public void testGetAllUserContact_expect_statusCode_OK() throws Exception {
        List<UserContact> userContactList = new ArrayList<>();
        Mockito.when(userContactService.getAllUserDetails()).thenReturn(userContactList);
        this.mockMvc.perform(get("/api/userContact/")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testAddUserContactDetails_giveValidUserContactRequest_expect_statusCode_OK()
            throws Exception {
        UserContactRequest userContactRequest =
                new UserContactRequest("jerin", "address", "1212121212", "asdasd@qsad.com");
        Mockito.when(userContactService.addUserContactDetails(userContactRequest)).thenReturn(true);
        this.mockMvc
                .perform(
                        post("/api/userContact/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(asJsonString(userContactRequest)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testAddUserContactDetails_giveNameAsNullInUserContactRequest_expect_statusCode_400()
            throws Exception {
        UserContactRequest userContactRequest =
                new UserContactRequest(null, "address", "1212121212", "asdasd@qsad.com");
        Mockito.when(userContactService.addUserContactDetails(userContactRequest)).thenReturn(true);
        this.mockMvc
                .perform(
                        post("/api/userContact/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(asJsonString(userContactRequest)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void
            testAddUserContactDetails_giveNameAsEmptyInUserContactRequest_expect_statusCode_400()
                    throws Exception {
        UserContactRequest userContactRequest =
                new UserContactRequest("", "address", "1212121212", "asdasd@qsad.com");
        Mockito.when(userContactService.addUserContactDetails(userContactRequest)).thenReturn(true);
        this.mockMvc
                .perform(
                        post("/api/userContact/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(asJsonString(userContactRequest)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void
            testAddUserContactDetails_giveInvalidEmailInUserContactRequest_expect_statusCode_400()
                    throws Exception {
        UserContactRequest userContactRequest =
                new UserContactRequest("asas", "address", "1212121212", "asdasd");
        Mockito.when(userContactService.addUserContactDetails(userContactRequest)).thenReturn(true);
        this.mockMvc
                .perform(
                        post("/api/userContact/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(asJsonString(userContactRequest)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void
            testAddUserContactDetails_givePhoneNumberAsNullInUserContactRequest_expect_statusCode_400()
                    throws Exception {
        UserContactRequest userContactRequest =
                new UserContactRequest("asas", "address", null, "asdasd");
        Mockito.when(userContactService.addUserContactDetails(userContactRequest)).thenReturn(true);
        this.mockMvc
                .perform(
                        post("/api/userContact/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(asJsonString(userContactRequest)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void
            testAddUserContactDetails_givePhoneNumberAsEmptyInUserContactRequest_expect_statusCode_400()
                    throws Exception {
        UserContactRequest userContactRequest =
                new UserContactRequest("asas", "address", "", "asdasd");
        Mockito.when(userContactService.addUserContactDetails(userContactRequest)).thenReturn(true);
        this.mockMvc
                .perform(
                        post("/api/userContact/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(asJsonString(userContactRequest)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testDeleteUserContactById_giveValidUUID_expect_statusCode_200() throws Exception {
        UserContactRequest userContactRequest =
                new UserContactRequest("jerin", "address", "1212121212", "asdasd@qsad.com");
        Mockito.when(userContactService.deleteUserDetailsById(Mockito.any())).thenReturn(true);
        this.mockMvc
                .perform(delete("/api/userContact/c6034bcf-d989-4704-8ec8-e638122dd236"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
