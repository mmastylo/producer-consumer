package mm.test.producerconsumer;

import static org.junit.Assert.*;

import org.junit.Test;


public class MathExpressionExecutorTest {

	@Test
	public void shouldCalculateMathExpression() {
		// given
		MathExpressionExecutor mathExpressionExecutor = new MathExpressionExecutor();
		String expression = "5 + 14 * 2 - 12 / 3";
		double expectedResult = 29d;

		// when
		double result = mathExpressionExecutor.execute(expression);

		// then
		assertEquals(expectedResult, result, 0);
	}
	
}