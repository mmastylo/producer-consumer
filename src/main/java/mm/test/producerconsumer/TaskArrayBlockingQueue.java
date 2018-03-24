package mm.test.producerconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TaskArrayBlockingQueue {

	private final Task[] items;

	private final ReentrantLock lock;

	private int count;

	private int putIndex;

	private int takeIndex;

	private final Condition notEmpty;

	private final Condition halfFull;

	public TaskArrayBlockingQueue(int capacity) {
		this.items = new Task[capacity];
		this.lock = new ReentrantLock();
		this.notEmpty = lock.newCondition();
		this.halfFull = lock.newCondition();
	}

	public void put(Task task) throws InterruptedException {
		final ReentrantLock lock = this.lock;
		lock.lockInterruptibly();

		try {
			while (count == items.length) {
				halfFull.await();
			}

			enqueue(task);
		} finally {
			lock.unlock();
		}
	}

	private void enqueue(Task task) {
		final Task[] items = this.items;
		items[putIndex] = task;

		if (++putIndex == items.length) {
			putIndex = 0;
		}

		count++;
		notEmpty.signal();
	}

	public Task take() throws InterruptedException {
		final ReentrantLock lock = this.lock;
		lock.lockInterruptibly();

		try {
			while (count == 0) {
				notEmpty.await();
			}

			return dequeue();
		} finally {
			lock.unlock();
		}
	}

	private Task dequeue() {
		final Task[] items = this.items;
		Task task = items[takeIndex];
		items[takeIndex] = null;

		if (++takeIndex == items.length) {
			takeIndex = 0;
		}

		count--;
		int modulo = items.length % 2;

		if (count == (items.length - modulo) / 2) {
			halfFull.signal();
		}

		return task;
	}

}