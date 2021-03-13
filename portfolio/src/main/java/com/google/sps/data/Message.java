package com.google.sps.data;

/** A message to send. */
public final class Message {
	private final long id;
	private final String messageText;
	private final long timestamp;

	public Message(long id, String messageText, long timestamp) {
		this.id = id;
		this.messageText = messageText;
		this.timestamp = timestamp;
	}
}