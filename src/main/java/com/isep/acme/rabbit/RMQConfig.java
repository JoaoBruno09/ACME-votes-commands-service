package com.isep.acme.rabbit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.isep.acme.constants.Constants;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RMQConfig {

	@Bean
	public Queue queue() {return new AnonymousQueue();}

	@Bean
	public FanoutExchange fanout() {
		return new FanoutExchange(Constants.EXCHANGE);
	}

	@Bean
	public Binding binding(FanoutExchange fanout, Queue queue) {
		return BindingBuilder.bind(queue).to(fanout);
	}

	@Bean
	public Jackson2JsonMessageConverter messageConverter(){
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.registerModule(new Hibernate5Module());
		objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		return new Jackson2JsonMessageConverter(objectMapper);
	}

	@Bean
	public AmqpTemplate template(ConnectionFactory connectionFactory){
		RabbitTemplate template = new RabbitTemplate( connectionFactory);
		template.setMessageConverter(messageConverter());
		return template;
	}
}
