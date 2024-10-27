package com.Samarth.contracts;

public interface Loggerable {
	void print(String msg);

	default void log(String message) {}
}
