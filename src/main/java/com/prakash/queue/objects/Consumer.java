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
        this.topics.add(topic);
    }

    // Returns the list of Topics this Consumer is subscribed to
    public List<Topic> getSubscribedTopics() {
        return this.topics;  // might want to return an unmodifiable copy IRL
    }

}
