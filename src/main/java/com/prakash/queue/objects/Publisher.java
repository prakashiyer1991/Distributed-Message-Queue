package com.prakash.queue.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Publisher {

    String id;

    List<Topic> topics;

    public void publish(Topic topic,Message message){
        synchronized (topic) {
            topic.addMessage(message);
        }
    }


}
