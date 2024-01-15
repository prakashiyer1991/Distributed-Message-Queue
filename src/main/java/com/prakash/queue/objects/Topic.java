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
    Queue<String> messages = new PriorityQueue<>();
    List<Consumer> consumers;

    public Topic(String topicName){
        this.name = topicName;
        this.messages = new PriorityQueue<>();
    }

    public void addMessage(String message){
        messages.add(message);
    }

    private void addSubscriber(Consumer consumer){
        consumers.add(consumer);
    }

    public String removeMessage() {
        return messages.poll();
    }


}
