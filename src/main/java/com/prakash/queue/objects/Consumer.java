package com.prakash.queue.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consumer {
    String id;
    List<Topic> topics = new ArrayList<>();

    public void subscribe(Topic topic) {
        synchronized (topic) {
            String message = topic.removeMessage();
            if (message != null) {
                System.out.println(id + " received " + message);
            }
        }
    }
}
