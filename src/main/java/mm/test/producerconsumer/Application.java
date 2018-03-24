package mm.test.producerconsumer;

public class Application {

	private static final int defaultQueueSize = 10;

	public static void main(String[] args) {
		int queueSize = args.length != 0 ? Integer.valueOf(args[0]) : defaultQueueSize;

		new Application().start(queueSize);
	}

	public void start(int queueSize) {
		TaskArrayBlockingQueue queue = new TaskArrayBlockingQueue(queueSize);

		TaskProducerStarter taskProducerStarter = new TaskProducerStarter();
		taskProducerStarter.start(queue);

		TaskConsumerStarter taskConsumerStarter = new TaskConsumerStarter();
		taskConsumerStarter.start(queue);
	}

}