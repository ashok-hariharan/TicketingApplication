package com.ashok.TicketingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ashok.TicketingApplication.model.Ticket;

@Repository
public interface TicketingRepository extends JpaRepository<Ticket, Integer>{

}