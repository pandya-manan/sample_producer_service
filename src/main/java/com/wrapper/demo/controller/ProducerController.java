package com.wrapper.demo.controller;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wrapper.demo.entity.CustomMessage;
import com.wrapper.demo.mqconfig.MQConfig;

@RestController
public class ProducerController {
	
	@Autowired
	private RabbitTemplate template;
	
	private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);
	
	@PostMapping("/publish/message")
	public String publishMessageToQueue(CustomMessage message)
	{
		try
		{
			message.setMessageDate(new Date().toString());
			message.setMessageId(UUID.randomUUID().toString());
			System.out.println(message.toString());
			logger.info("Before sending the messsage to rabbitmq");
			template.convertAndSend(MQConfig.EXCHANGE,MQConfig.ROUTINGKEY,message);
			logger.info("After sending the message to rabbitmq");
			return "Message Published Successfully!";
		}
		catch (Exception e)
		{
			String errorMessage=e.getMessage();
			logger.error("The error is caught as: "+e.getMessage());
			return errorMessage;
		}
		

	}

}
