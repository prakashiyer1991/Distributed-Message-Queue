package com.prakash.queue.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Comparable<Message>{
    private String content;
    private Set<String> consumersReceived;

    // Initialize your message with content and the set of consumers
    public Message(String content) {
        this.content = content;
        this.consumersReceived = new HashSet<>();
    }

    public boolean isDispatchedTo(String consumerId) {
        return consumersReceived.contains(consumerId);
    }

    public void markAsDispatchedTo(String consumerId) {
        consumersReceived.add(consumerId);
    }

    @Override
    public int compareTo(Message o) {
        return this.content.compareTo(o.content);
    }
}