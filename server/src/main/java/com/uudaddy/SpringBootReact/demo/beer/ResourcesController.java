package com.uudaddy.SpringBootReact.demo.beer;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
 *  Implement an API for a distributed Pub Sub.

Resources
Consumers
Subscribe and receive Events from some set of Channels
Channels
Deliver Events to a set of subscribed Consumers
Requirements
Create/Delete Consumers and Channels
Subscribe Consumers to Channels
Any user of this API can Emit events over Channels which are forwarded to all subscribed Consumers

 */

@RestController
public class ResourcesController {

	
	HashMap<Long, Consumer> consumers = new HashMap<Long, Consumer>();
	HashMap<Long, Channel> channels = new HashMap<Long,Channel>();

	// http status code
	// 
	
	@PostMapping("/create")
    ResponseEntity<Consumer> createConsumers(@Valid @RequestBody Consumer consumer
            ) 
    {
		// validate input
		// already exist
		
	    consumers.put(consumer.consumerid, consumer);	
		return null;
    }
	
	@DeleteMapping("/delete/{cosumerid}")
    ResponseEntity<?> deleteConsumers(@PathVariable Long cosumerid
            ) 
    {
		// find the consumer, assuming consumer id is index + 1 
		// not found, 404
		
		consumers.remove(cosumerid -1);
		return null;
    }
	
	@PostMapping("/createChannels")
    ResponseEntity<Channel> createChannels(@Valid @RequestBody Channel channel
            ) 
    {
		// validate input
		channels.put(channel.channelid, channel);	
		return null;
    }
	
	@DeleteMapping("/delete/{channelid}")
    ResponseEntity<?> deleteChannels(@PathVariable Long channelid
            ) 
    {
		// see if we can delete consumers associted with the channel
		channels.remove(channelid-1);
		return null;
    }
	
	@PostMapping("/subscribe/{customerid}/{channelid}")
    ResponseEntity<Consumer> subsribeConsumerToChannel(@PathVariable long customerid,
    		@PathVariable long channelid
    		) 
    {
		// here I want to use web-hook for subscription
		// URL accepts posts, http client execute 
		Channel channel = channels.get(channelid);
		channel.addConsumer(customerid);
		
		return null;
    }
	
	@PostMapping("/sendMessages")
    void sendMessages()
    {
		// loop through channel
		for (Map.Entry<Long, Channel> entry : channels.entrySet()) {
		    // System.out.println(entry.getKey() + " = " + entry.getValue());
			// loop through the consumers subscribed to the channel
			for(Map.Entry<Long, Consumer> entry2 : consumers.entrySet()) {
				// send message
				System.out.println("Sending message from channel..." + entry.getKey() + 
						" and consumer: " + entry2.getKey());
			}
		}
    }
	
	
	public void sendEmail()
	{
		System.out.println("Sending email...");
		
		System.out.println("email sent");
	}
	
}
