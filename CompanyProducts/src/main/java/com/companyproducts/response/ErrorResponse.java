package com.companyproducts.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponse {

    private LocalDateTime dateTime;

    private String message;

    private  String description;
}
