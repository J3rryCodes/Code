package com.example.demo.controller;

import com.example.demo.data.UserContact;
import com.example.demo.dto.UserContactRequest;
import com.example.demo.service.UserContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/userContact/")
public class UserContactController {

    @Autowired
    private UserContactService userContactService;

    @PostMapping
    public ResponseEntity addUserContactDetails(@RequestBody UserContactRequest userContactRequest){
        try{
            userContactService.addUserContactDetails(userContactRequest);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserContact>> getAllUserContact(){
       return new ResponseEntity<List<UserContact>>(userContactService.getAllUserDetails(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserContactById(@PathVariable("id") UUID id){
        try{
            userContactService.deleteUserDetailsById(id);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
