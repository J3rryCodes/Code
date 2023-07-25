package com.example.demo.uitls;

import com.example.demo.data.UserContact;
import com.example.demo.dto.UserContactRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

public class UserContactUtils {

    public static Function<UserContactRequest, UserContact> CONVERT_USER_CONTACT_REQUEST_TO_ENTITY = userContactRequest -> {
        UserContact userContact = new UserContact();
        userContact.setId(UUID.randomUUID());
        userContact.setName(userContactRequest.name());
        userContact.setAddress(userContactRequest.address());
        userContact.setEmail(userContactRequest.email());
        userContact.setPhoneNumber(userContactRequest.phoneNumber());
        return userContact;
    };
}
