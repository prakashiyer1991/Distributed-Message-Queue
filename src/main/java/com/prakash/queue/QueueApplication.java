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


		//create consumers
		Consumer consumer1 = new Consumer();
		consumer1.setId(UUID.randomUUID().toString());
		Consumer consumer2 = new Consumer();
		consumer2.setId(UUID.randomUUID().toString());
		Consumer consumer3 = new Consumer();
		consumer3.setId(UUID.randomUUID().toString());
		Consumer consumer4 = new Consumer();
		consumer4.setId(UUID.randomUUID().toString());
		Consumer consumer5 = new Consumer();
		consumer5.setId(UUID.randomUUID().toString());


		//add consumers to the queue
		queue.addConsumer(consumer1);
		queue.addConsumer(consumer2);
		queue.addConsumer(consumer3);
		queue.addConsumer(consumer4);
		queue.addConsumer(consumer5);


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

		consumer1.subscribe(topic);
		consumer2.subscribe(topic);
		consumer3.subscribe(topic);
		consumer4.subscribe(topic);
		consumer5.subscribe(topic);

		// make 3 consumer from topic 2
		consumer1.subscribe(topic1);
		consumer3.subscribe(topic1);
		consumer4.subscribe(topic1);

		SpringApplication.run(QueueApplication.class, args);

	}

}
