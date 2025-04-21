package com.ecommerce.service.admin;

import com.ecommerce.dto.TicketDto;

import java.util.List;
import java.util.Optional;

public interface AdminTicketService {
    List<TicketDto> getAllTickets();
    Optional<TicketDto> getTicketById(Long id);
    TicketDto saveTicket(TicketDto ticketDto);
    TicketDto updateTicket(Long id, TicketDto updatedTicketDto);
    void deleteTicket(Long id);
}
