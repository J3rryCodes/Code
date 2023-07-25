package com.example.demo.service;

import com.example.demo.data.UserContact;
import com.example.demo.dto.UserContactRequest;
import com.example.demo.dto.UserContactResponse;

import java.util.List;
import java.util.UUID;

public interface UserContactService {
    boolean addUserContactDetails(UserContactRequest userContactRequest);
    List<UserContact> getAllUserDetails();
    boolean deleteUserDetailsById(UUID id);
}
