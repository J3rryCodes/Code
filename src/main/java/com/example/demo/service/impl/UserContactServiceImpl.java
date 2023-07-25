package com.example.demo.service.impl;

import com.example.demo.data.UserContact;
import com.example.demo.dto.UserContactRequest;
import com.example.demo.dto.UserContactResponse;
import com.example.demo.repository.UserContactRepository;
import com.example.demo.service.UserContactService;
import com.example.demo.uitls.UserContactUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserContactServiceImpl implements UserContactService {

    @Autowired
    private UserContactRepository userContactRepository;

    @Override
    public boolean addUserContactDetails(UserContactRequest userContactRequest) {
        userContactRepository.save(UserContactUtils.CONVERT_USER_CONTACT_REQUEST_TO_ENTITY.apply(userContactRequest));
        return true;
    }

    @Override
    public List<UserContact> getAllUserDetails() {
        return userContactRepository.findAll();
    }

    @Override
    public boolean deleteUserDetailsById(UUID id) {
        userContactRepository.deleteById(id);
        return true;
    }
}
