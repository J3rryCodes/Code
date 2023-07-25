package com.example.demo.dto;

import java.util.UUID;

public record UserContactResponse(UUID id, String Name , String address, String phoneNumber, String email) {
}
