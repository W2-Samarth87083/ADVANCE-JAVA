package com.Samarth.entities;

import org.springframework.stereotype.Component;

import com.Samarth.contracts.Loggerable;

@Component
public class ConsoleLogger implements Loggerable {

	@Override
	public void print(String msg) {
		System.out.println("Console Logger ::"+msg);
	}

}
