package com.google.sps.data;

/** An item on a todo list. */
public final class Message {

  private final long id;
  private final String messageText;
  private final long timestamp;

  public Task(long id, String messageText, long timestamp) {
    this.id = id;
    this.messageText = messageText;
    this.timestamp = timestamp;
  }
}