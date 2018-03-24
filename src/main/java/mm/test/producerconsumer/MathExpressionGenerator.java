package mm.test.producerconsumer;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class MathExpressionGenerator {

	private static final char[] operators = new char[] { '+', '-', '*', '/' };

	private static final int maxNoOfOperators = 5;

	private static final int maxNoOfDigits = 4;

	public String generate() {
		StringBuilder expression = new StringBuilder();
		int noOfOperators = ThreadLocalRandom.current().nextInt(1, maxNoOfOperators);
		IntStream.range(0, noOfOperators).mapToObj(i -> {
			int operatorIndex = ThreadLocalRandom.current().nextInt(0, operators.length - 1);

			return operators[operatorIndex];
		}).forEach(operator -> {
			expression.append(generateNumber(operator));
			expression.append(" ");
			expression.append(operator);
			expression.append(" ");
		});

		char lastOperator = expression.charAt(expression.length() - 2);
		expression.append(generateNumber(lastOperator));

		return expression.toString();
	}

	private int generateNumber(char operator) {
		int number = generateNumber();

		if (operator == '/' && number == 0) {
			return ThreadLocalRandom.current().nextInt(1, 9);
		}

		return number;
	}

	private int generateNumber() {
		StringBuilder number = new StringBuilder();
		int noOfDigits = ThreadLocalRandom.current().nextInt(1, maxNoOfDigits);
		IntStream.range(0, noOfDigits).map(i -> ThreadLocalRandom.current().nextInt(0, 9))
				.forEach(digit -> number.append(digit));

		return Integer.valueOf(number.toString());
	}

}