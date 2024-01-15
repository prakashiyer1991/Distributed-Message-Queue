package com.prakash.queue.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Queue {

    List<Topic> topics;
    List<Consumer> consumers;
    List<Publisher> publishers;


    public void addTopic(Topic topic) {
        synchronized(topics) {
            topics.add(topic);
        }
    }

    public void removeTopic(Topic topic) {
        synchronized(topics) {
            topics.remove(topic);
        }
    }

    public void addPublisher(Publisher publisher) {
        synchronized(publishers) {
            publishers.add(publisher);
        }
    }

    public void removePublisher(Publisher publisher) {
        synchronized(publishers) {
            publishers.remove(publisher);
        }
    }

    public void addConsumer(Consumer consumer) {
        synchronized(consumers) {
            consumers.add(consumer);
        }
    }

    public void removeConsumer(Consumer consumer) {
        synchronized(consumers) {
            consumers.remove(consumer);
        }
    }

}
