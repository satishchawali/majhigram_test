package com.ecommerce.service.user;

import com.ecommerce.dto.TicketDto;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    List<TicketDto> getAllTickets();
    Optional<TicketDto> getTicketById(Long id);
    TicketDto saveTicket(TicketDto ticketDto);
    TicketDto updateTicket(Long id, TicketDto updatedTicketDto);
    void deleteTicket(Long id);
}
