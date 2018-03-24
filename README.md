# Producer consumer

This project generates two task producers and four task consumers. They work in infinite threads and they run in random periods of time (producer between 1 to 5 seconds, consumer 1 to 15 seconds). Producer generates tasks as long as queue is not full while consumer consumes them. When queue is full, then producer waits until it is half empty (size / 2 - 1 for odd capacity). Task consists of math expression generator and math expression evaluator, which writes result to console. Queue capacity can be configured or default setting is used.

## Getting Started


### Installing

Install [Maven](https://maven.apache.org/) first.


## Running & Tests

### Running

Project is a Maven project. It can be built with following command:

```
mvn clean package
```

Producer consumer can be run in console from root folder with following command :

```
java -jar target/producerconsumer-0.0.1-SNAPSHOT "queue capacity"
```

where "queue capacity" is optional and configures queue size. It must be a positive integer.

### Tests

Tests can be run with following command:

```
mvn test
```

## Validation

MathExpressionGenerator validates if there is no division by zero. Queue capacity parameter is not validated, application assumes that positive integer is provided.

## Algorithms

### Queue

Queue is implemented as modification of ArrayBlockingQueue. It signals producer threads when it is half empty, the rest of behavior is similar to ArrayBlockingQueue implementation.

### Math expression evaluator

Randomly generated math expressions are evaluated with Spring Expression Language (SpEL).


## Used libraries

* Spring Expression Language (SpEL)
* JUnit