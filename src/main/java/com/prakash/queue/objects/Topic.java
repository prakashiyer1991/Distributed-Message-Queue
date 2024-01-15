package com.prakash.queue.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic {

    String name;
    Queue<Message> messages = new PriorityQueue<>();
    List<Consumer> consumers;

    public Topic(String topicName){
        this.name = topicName;
        this.messages = new PriorityQueue<>();
    }

    public void addMessage(Message message){
        messages.add(message);
    }

    private void addSubscriber(Consumer consumer){
        consumers.add(consumer);
    }

    public Message getMessageFor(String consumerId) {
        for (Message message : messages) {
            if (!message.isDispatchedTo(consumerId)) {
                message.markAsDispatchedTo(consumerId);
                return message;
            }
        }
        return null;
    }


}
