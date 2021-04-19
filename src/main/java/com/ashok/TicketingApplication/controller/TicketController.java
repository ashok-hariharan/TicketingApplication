package com.ashok.TicketingApplication.controller;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.TicketingApplication.exception.ResourceNotFoundException;
import com.ashok.TicketingApplication.model.Ticket;
import com.ashok.TicketingApplication.repository.TicketingRepository;
import com.ashok.TicketingApplication.service.EmailService;

@RestController
@RequestMapping("/api/v1/")
public class TicketController {
	
	@Autowired
	private TicketingRepository ticketingRepository;
	
	@GetMapping("/tickets")
	public List<Ticket> getAllTickets(){
		return ticketingRepository.findAll();
		}
	
    @GetMapping("/tickets/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable(value = "id") int ticketId)
        throws ResourceNotFoundException {
        Ticket ticket = ticketingRepository.findById(ticketId)
          .orElseThrow(() -> new ResourceNotFoundException("Ticket not found for this id :: " + ticketId));
        return ResponseEntity.ok().body(ticket);
    }
	
	@PutMapping("/tickets/{id}")
	public ResponseEntity<Ticket> updateEmployee(@PathVariable(value="id") int ticketId,
			@Valid @RequestBody Ticket ticketDetails) throws ResourceNotFoundException {
        Ticket ticket = ticketingRepository.findById(ticketId)
        .orElseThrow(() -> new ResourceNotFoundException("Ticket not found for this id :: " + ticketId));
        
        ticket.setId(ticketDetails.getId());
        ticket.setAssigneduser(ticketDetails.getAssigneduser());
        ticket.setComments(ticketDetails.getComments());
        ticket.setCreatedBy(ticketDetails.getCreatedBy());
        ticket.setCustomerid(ticketDetails.getCustomerid());
        ticket.setDescription(ticketDetails.getDescription());
        ticket.setPriority(ticketDetails.getPriority());
        ticket.setStatus(ticketDetails.getStatus());
        ticket.settitle(ticketDetails.gettitle());
        ticket.setType(ticketDetails.getType());
        if(ticketDetails.getComments()!=null)
        {
        	try {
				EmailService.sendEmail(ticketDetails);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        final Ticket updatedTicket = ticketingRepository.save(ticket);
        return ResponseEntity.ok(updatedTicket);
    }	
	
	
    @PostMapping("/tickets")
    public Ticket createTicket(@Valid @RequestBody Ticket ticket) {
        return ticketingRepository.save(ticket);
    }
    

    @DeleteMapping("/tickets/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") int ticketId)
         throws ResourceNotFoundException {
        Ticket ticket = ticketingRepository.findById(ticketId)
       .orElseThrow(() -> new ResourceNotFoundException("Ticket not found for this id :: " + ticketId));

        ticketingRepository.delete(ticket);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

			
			

}
