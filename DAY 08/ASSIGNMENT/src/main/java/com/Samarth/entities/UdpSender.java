package com.Samarth.entities;

import org.springframework.stereotype.Component;

import com.Samarth.contracts.Senderable;

@Component
public class UdpSender implements Senderable {

	@Override
	public void send(double value) {
		System.out.println("UDP Sender  ::" + value);

	}

}
