package mm.test.producerconsumer;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class TaskProducerStarter {

	public void start(TaskArrayBlockingQueue queue) {
		final TaskProducer taskProducer = new TaskProducer(queue);
		final Supplier<Task> supplier = () -> new TaskImpl();

		for (int i = 0; i < 2; i++) {
			new Thread(() -> {
				while (true) {
					try {
						int randomNum = ThreadLocalRandom.current().nextInt(1000, 5000);
						Thread.sleep(randomNum);

						taskProducer.produce(supplier);
					} catch (Exception exception) {
						exception.printStackTrace();
					}
				}
			}).start();
		}
	}

}