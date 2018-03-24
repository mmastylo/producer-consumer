package mm.test.producerconsumer;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class MathExpressionExecutor {

	public double execute(String expr) {
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression(expr.toString());

		return expression.getValue(Double.class);
	}

}