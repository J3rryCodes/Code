/* (C)2023 */
package com.example.demo.service.impl;

import com.example.demo.data.UserContact;
import com.example.demo.dto.UserContactRequest;
import com.example.demo.repository.UserContactRepository;
import com.example.demo.service.UserContactService;
import java.util.List;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserContactServiceImpl implements UserContactService {

    @Autowired private UserContactRepository userContactRepository;

    @Autowired ModelMapper modelMapper;

    @Override
    public boolean addUserContactDetails(UserContactRequest userContactRequest) {
        UserContact userContact = modelMapper.map(userContactRequest, UserContact.class);
        userContactRepository.save(userContact);
        return true;
    }

    @Override
    public List<UserContact> getAllUserDetails() {
        return userContactRepository.findAll();
    }

    @Override
    public boolean deleteUserDetailsById(UUID id) {
        if (userContactRepository.findById(id).isPresent()) {
            userContactRepository.deleteById(id);
            return true;
        } else return false;
    }
}
