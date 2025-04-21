package com.ecommerce.service.user.impl;

import com.ecommerce.dto.TicketDto;
import com.ecommerce.entity.Ticket;
import com.ecommerce.repo.TicketRepository;
import com.ecommerce.service.user.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<TicketDto> getAllTickets() {
        return ticketRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TicketDto> getTicketById(Long id) {
        return ticketRepository.findById(id).map(this::convertToDto);
    }

    @Override
    public TicketDto saveTicket(TicketDto ticketDto) {
        Ticket ticket = convertToEntity(ticketDto);
        Ticket savedTicket = ticketRepository.save(ticket);
        return convertToDto(savedTicket);
    }

    @Override
    public TicketDto updateTicket(Long id, TicketDto updatedTicketDto) {
        return ticketRepository.findById(id).map(existingTicket -> {
            existingTicket.setEmail(updatedTicketDto.getEmail());
            existingTicket.setMobile(updatedTicketDto.getMobile());
            existingTicket.setReason(updatedTicketDto.getReason());
            existingTicket.setDiscription(updatedTicketDto.getDiscription());
            existingTicket.setStatus(updatedTicketDto.getStatus());
            existingTicket.setCreatedate(updatedTicketDto.getCreatedate());
            existingTicket.setLastupdate(updatedTicketDto.getLastupdate());
            existingTicket.setResolution(updatedTicketDto.getResolution());
            Ticket updatedTicket = ticketRepository.save(existingTicket);
            return convertToDto(updatedTicket);
        }).orElseThrow(() -> new RuntimeException("Ticket not found with id " + id));
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    private TicketDto convertToDto(Ticket ticket) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setId(ticket.getId());
        ticketDto.setEmail(ticket.getEmail());
        ticketDto.setMobile(ticket.getMobile());
        ticketDto.setReason(ticket.getReason());
        ticketDto.setDiscription(ticket.getDiscription());
        ticketDto.setStatus(ticket.getStatus());
        ticketDto.setCreatedate(ticket.getCreatedate());
        ticketDto.setLastupdate(ticket.getLastupdate());
        ticketDto.setResolution(ticket.getResolution());
        return ticketDto;
    }

    private Ticket convertToEntity(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        ticket.setId(ticketDto.getId());
        ticket.setEmail(ticketDto.getEmail());
        ticket.setMobile(ticketDto.getMobile());
        ticket.setReason(ticketDto.getReason());
        ticket.setDiscription(ticketDto.getDiscription());
        ticket.setStatus(ticketDto.getStatus());
        ticket.setCreatedate(ticketDto.getCreatedate());
        ticket.setLastupdate(ticketDto.getLastupdate());
        ticket.setResolution(ticketDto.getResolution());
        return ticket;
    }
}
