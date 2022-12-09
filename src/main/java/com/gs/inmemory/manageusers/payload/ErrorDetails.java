package com.gs.inmemory.manageusers.payload;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDetails {
    
    private Date timestamp;
    private String message;
    private String details;
}
