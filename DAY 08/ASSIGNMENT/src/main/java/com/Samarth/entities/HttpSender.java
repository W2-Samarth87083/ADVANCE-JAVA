package com.Samarth.entities;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.Samarth.contracts.Senderable;


@Component
public class HttpSender implements Senderable{
	@Override
	public void send(double value) {
		System.out.println("HTTP Sender ::"+value);	
	}

}
