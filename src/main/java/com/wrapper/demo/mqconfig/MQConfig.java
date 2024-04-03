package com.wrapper.demo.mqconfig;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {
	
	public static final String QUEUE="test_message";
	public static final String EXCHANGE="messageExchange";
	public static final String ROUTINGKEY="message_routing_key";
	
	
	@Bean
	public Queue queue()
	{
		return new Queue(QUEUE);
	}
	
	@Bean
	public TopicExchange exchange()
	{
		return new TopicExchange(EXCHANGE);
	}
	
	@Bean
	public Binding binding(Queue queue,TopicExchange exchange)
	{
		return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY);
	}
	
	@Bean
	 public MessageConverter messageConverter() {
        return  new Jackson2JsonMessageConverter();
    }
	
	 @Bean
	 public AmqpTemplate template(ConnectionFactory connectionFactory) {
	        RabbitTemplate template = new RabbitTemplate(connectionFactory);
	        template.setMessageConverter(messageConverter());
	        return  template;
	 }

}
