/* (C)2023 */
package com.example.demo.controller;

import com.example.demo.data.UserContact;
import com.example.demo.dto.UserContactRequest;
import com.example.demo.service.UserContactService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/userContact/")
public class UserContactController {

    @Autowired private UserContactService userContactService;

    @PostMapping
    public ResponseEntity addUserContactDetails(
            @RequestBody @Validated UserContactRequest userContactRequest) {
        try {
            userContactService.addUserContactDetails(userContactRequest);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserContact>> getAllUserContact() {
        return new ResponseEntity<List<UserContact>>(
                userContactService.getAllUserDetails(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserContactById(@PathVariable("id") UUID id) {
        try {
            if (userContactService.deleteUserDetailsById(id))
                return new ResponseEntity(HttpStatus.OK);
            else return new ResponseEntity(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
