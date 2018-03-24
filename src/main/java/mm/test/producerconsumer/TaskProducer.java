package mm.test.producerconsumer;

import java.util.function.Supplier;

public class TaskProducer {

	private TaskArrayBlockingQueue queue;

	public TaskProducer(TaskArrayBlockingQueue queue) {
		this.queue = queue;
	}

	public void produce(Supplier<Task> supplier) throws InterruptedException {
		final Task task = supplier.get();

		queue.put(task);
	}

}