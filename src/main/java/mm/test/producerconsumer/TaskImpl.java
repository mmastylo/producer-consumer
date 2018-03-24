package mm.test.producerconsumer;

public class TaskImpl implements Task {

	@Override
	public void run() {
		MathExpressionGenerator mathExpressionGenerator = new MathExpressionGenerator();
		String expression = mathExpressionGenerator.generate();

		MathExpressionExecutor mathExpressionExecutor = new MathExpressionExecutor();
		double result = mathExpressionExecutor.execute(expression);

		System.out.println(expression + " = " + result);
	}

}