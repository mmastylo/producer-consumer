package mm.test.producerconsumer;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public class TaskConsumerStarter {

	public void start(TaskArrayBlockingQueue queue) {
		final TaskConsumer taskConsumer = new TaskConsumer(queue);
		final Consumer<Task> consumer = (task) -> task.run();

		for (int i = 0; i < 4; i++) {
			new Thread(() -> {
				while (true) {
					try {
						int randomNum = ThreadLocalRandom.current().nextInt(1000, 15000);
						Thread.sleep(randomNum);

						taskConsumer.consume(consumer);
					} catch (Exception exception) {
						exception.printStackTrace();
					}
				}
			}).start();
		}
	}

}