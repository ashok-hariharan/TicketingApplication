
package com.ashok.TicketingApplication.service;

import javax.validation.Valid;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.*;
import java.io.IOException;
import com.ashok.TicketingApplication.model.Ticket;

public class EmailService {
	public static void sendEmail(@Valid Ticket ticketDetails) throws IOException {
	    Email from = new Email("yogesh@sinecycle.com");
	    String subject = "Change in "+ticketDetails.getId();
	    Email to = new Email("hariharan_ashok@yahoo");
	    Content content = new Content("text/plain", "Change in command : "+ticketDetails.getComments());
	    Mail mail = new Mail(from, subject, to, content);

	    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
	    Request request = new Request();
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
	      System.out.println("Status : "+response.getStatusCode());
	      System.out.println(response.getBody());
	      System.out.println(response.getHeaders());
	    } catch (IOException ex) {
	      throw ex;
	    }
		
	}

}
