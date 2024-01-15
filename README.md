markdown
# In-Memory Distributed Queue Design

## Problem Statement

The objective is to design an In-Memory Distributed Queue modeled after systems such as Kafka.

## Key Requirements

1. **In-Memory Queue**: The queue should be exclusively in-memory, eliminating the need for access to the file system.
2. **Multiple Topics**: The queue should support multiple topics.
3. **Publish-Subscribe Model**: Messages (strings) can be published on a topic by a producer. In turn, consumers can subscribe to the topic to receive these messages.
4. **Multiple Producers and Consumers**: The system should support multiple producers and consumers. A producer can publish to multiple topics and a consumer can listen to multiple topics.
5. **Consumer Message Reception**: On receiving a message, the consumer should display the following: `<consumer_id> received <message>`.
6. **Multi-threading**: The queue system should support multi-threading, allowing messages to be produced or consumed in parallel.

## Flow of Operation (Input/Output)

The operation of the system should be as follows:

- **Topics**: Initiate with 2 topics, namely `topic1` and `topic2`.
- **Producers**: Create 2 producers, `producer1` and `producer2`.
- **Consumers**: Create 5 consumers, labelled `consumer1` to `consumer5`.
- **Subscriptions**: Make all consumers subscribe to `topic1`, and `consumer1`, `consumer3` and `consumer4` subscribe to `topic2`.
- **Message Production**: Dispatch the following messages:
  - `producer1` publishes "Message 1" & "Message 2" to `topic1`.
  - `producer2` publishes "Message 3" to `topic1`.
  - `producer1` publishes "Message 4" to `topic2`.
  - `producer2` publishes "Message 5" to `topic2`.

## Expectations

- The code should function correctly and be capable of demonstration.
- The codebase should be modular and readable.
- Concerns should be separated appropriately, avoiding monolithic file designs (unless coding in C/C++).
- The code should easily accommodate new features and changes.
- The code should be testable from a main method.
- Optionally, unit tests can be written if possible.
- A graphical user interface is not required for this project.
