package com.Samarth.entities;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.Samarth.contracts.Senderable;

@Primary
@Component
public class TcpSender implements Senderable{
	@Override
	public void send(double value) {
		System.out.println("TCP Sender  ::"+value);
	}

}
