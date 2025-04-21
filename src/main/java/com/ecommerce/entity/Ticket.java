package com.ecommerce.entity;

import com.ecommerce.dto.TicketDto;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String mobile;
    private String reason;
    private String discription;
    private String status;

    private LocalDateTime createdate;
    private LocalDateTime lastupdate;
    private String resolution;

    // Getters and Setters (omitted for brevity)

    // Method to convert entity to DTO
    public TicketDto toDto() {
        TicketDto dto = new TicketDto();
        dto.setId(id);
        dto.setEmail(email);
        dto.setMobile(mobile);
        dto.setReason(reason);
        dto.setDiscription(discription);
        dto.setStatus(status);
        dto.setCreatedate(createdate);
        dto.setLastupdate(lastupdate);
        dto.setResolution(resolution);
        return dto;
    }
}
