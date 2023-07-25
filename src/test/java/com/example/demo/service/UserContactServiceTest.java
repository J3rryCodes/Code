package com.example.demo.service;


import com.example.demo.data.UserContact;
import com.example.demo.dto.UserContactRequest;
import com.example.demo.repository.UserContactRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
public class UserContactServiceTest {

    @Autowired
    private UserContactService userContactService;

    @MockBean
    private UserContactRepository userContactRepository;

    @Test
    public void testAddUserContactDetails_giveUserContactRequest_shouldReturn_true(){
        UserContactRequest userContactRequest = new UserContactRequest("as","asa","asas","asas@asd.com");
        Mockito.when(userContactRepository.save(Mockito.any())).thenReturn(null);
        Assertions.assertThat(userContactService.addUserContactDetails(userContactRequest)).isEqualTo(true);
    }

    @Test
    public void testGetAllUserDetails_giveUserContactRequest_shouldReturn_true(){
        UserContactRequest userContactRequest = new UserContactRequest("as","asa","asas","asas@asd.com");
        List<UserContact> userContactList = new ArrayList<>();
        Mockito.when(userContactRepository.findAll()).thenReturn(userContactList);
        Assertions.assertThat(userContactService.getAllUserDetails()).isEqualTo(userContactList);
    }

    @Test
    public void testDeleteUserDetailsById_giveUserContactRequest_shouldReturn_true(){
        List<UserContact> userContactList = new ArrayList<>();
        Assertions.assertThat(userContactService.deleteUserDetailsById(UUID.randomUUID())).isEqualTo(true);
    }
}
