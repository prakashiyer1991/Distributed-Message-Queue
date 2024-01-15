package com.prakash.queue;

import ch.qos.logback.core.testUtil.RandomUtil;
import com.prakash.queue.objects.Consumer;
import com.prakash.queue.objects.Publisher;
import com.prakash.queue.objects.Queue;
import com.prakash.queue.objects.Topic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class QueueApplication {

	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.setTopics(new ArrayList<>());
		queue.setConsumers(new ArrayList<>());
		queue.setPublishers(new ArrayList<>());

		//create Topics
		Topic topic = new Topic();
		topic.setName("Topic A");

		Topic topic1 = new Topic();
		topic1.setName("Topic B");

		//add topics to queue
		queue.addTopic(topic);
		queue.addTopic(topic1);

		//create producers
		Publisher publisher = new Publisher();
		publisher.setId(UUID.randomUUID().toString());

		Publisher publisher1 = new Publisher();
		publisher1.setId(UUID.randomUUID().toString());

		//add producers to the queue
		queue.addPublisher(publisher);
		queue.addPublisher(publisher1);

		// Make producer1 publish message "Message 1" to topic1
		publisher.publish(topic, "Message 1");

		// Make producer1 publish message "Message 2" to topic1
		publisher.publish(topic, "Message 2");

		// Make producer2 publish message "Message 3" to topic1
		publisher1.publish(topic, "Message 3");

		// Make producer1 publish message "Message 4" to topic2
		publisher1.publish(topic1, "Message 4");

		// Make producer2 publish message "Message 5" to topic2
		publisher1.publish(topic1, "Message 5");

		// Create executor service with a fixed thread pool
		ExecutorService executor = Executors.newFixedThreadPool(5);

		// Create Consumers with a new runnable task to read topics they are subscribed to
		for (int i = 1; i <= 5; i++) {
			final Consumer consumer = new Consumer();
			consumer.setId("consumer" + i);
			queue.addConsumer(consumer);

			// Consumers subscribe to topics
			consumer.subscribe(topic);
			if (i == 1 || i == 3 || i == 4) {
				consumer.subscribe(topic1);
			}

			// Each consumer is assigned a Runnable task to consistently look for published messages in subscribed topics
			executor.submit(() -> {
				while (true) {
					for (Topic element : consumer.getTopics()) {
						synchronized (element) {
							String message = element.removeMessage();
							if (message != null) {
								System.out.println(consumer.getId() + " received " + message);
							}
						}
					}
				}
			});
		}

		//SpringApplication.run(QueueApplication.class, args);
	}
}
