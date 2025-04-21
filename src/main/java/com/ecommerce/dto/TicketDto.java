package com.ecommerce.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TicketDto {

    private Long id;
    private String email;
    private String mobile;
    private String reason;
    private String discription;
    private String status;
    private LocalDateTime createdate;
    private LocalDateTime lastupdate;
    private String resolution;
}
