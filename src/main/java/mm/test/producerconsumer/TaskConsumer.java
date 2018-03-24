package mm.test.producerconsumer;

import java.util.function.Consumer;

public class TaskConsumer {

	private TaskArrayBlockingQueue queue;

	public TaskConsumer(TaskArrayBlockingQueue queue) {
		this.queue = queue;
	}

	public void consume(Consumer<Task> consumer) throws InterruptedException {
		consumer.accept(queue.take());
	}

}