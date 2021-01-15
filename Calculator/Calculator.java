package Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String process = in.nextLine();
		System.out.println(exec(process));

	}

	public static double exec(String exp) {
		int leftIndex = exp.lastIndexOf('(');

		if (leftIndex == -1) {
			return calc(exp);
		} else {
			int rightIndex = exp.substring(leftIndex).indexOf(')') + leftIndex;

			double res = calc(exp.substring(leftIndex + 1, rightIndex));

			exp = exp.substring(0, leftIndex) + res + exp.substring(rightIndex + 1);

			return exec(exp);
		}

	}

	public static double calc(String exp) {
		List<Double> numbers = sliptNumbers(exp);
		List<Character> ops = sliptOps(exp);
		for (int i = 0; i < ops.size(); i++) {
			char op = ops.get(i);

			if (op == '*' || op == '/') {
				ops.remove(i);

				double d1 = numbers.remove(i);
				double d2 = numbers.remove(i);

				d1 = op == '*' ? d1 * d2 : d1 / d2;

				numbers.add(i, d1);
				i--;
			}

		}

		while (!ops.isEmpty()) {
			char op = ops.remove(0);
			double d1 = numbers.remove(0);
			double d2 = numbers.remove(0);

			d1 = op == '+' ? d1 + d2 : d1 - d2;

			numbers.add(0, d1);
		}

		return numbers.get(0);
	}

	private static List<Character> sliptOps(String exp) {
		List<Character> ops = new ArrayList<Character>();
		String formaterExp = formaterExp(exp);

		StringTokenizer st = new StringTokenizer(formaterExp, "@0123456789.");
		while (st.hasMoreTokens()) {
			String opStr = st.nextElement() + "";
			ops.add(opStr.charAt(0));
		}
		return ops;
	}

	private static List<Double> sliptNumbers(String exp) {
		List<Double> numbers = new ArrayList<Double>();
		String formaterExp = formaterExp(exp);

		StringTokenizer st = new StringTokenizer(formaterExp, "+-*/");
		while (st.hasMoreTokens()) {
			String numStr = st.nextElement() + "";
			if (numStr.charAt(0) == '@') {
				numStr = "-" + numStr.substring(1);
			}

			numbers.add(Double.parseDouble(numStr));
		}
		return numbers;
	}

	private static String formaterExp(String exp) {
		int index = 0;
		while (index < exp.length()) {
			char c = exp.charAt(index);
			if (c == '-') {
				if (index == 0) {
					exp = "@" + exp.substring(1);
				} else {
					if (exp.charAt(index - 1) == '*' || exp.charAt(index - 1) == '/') {
						exp = exp.substring(0, index) + "@" + exp.substring(index + 1);
					}
				}
			}

			index++;
		}
		return exp;
	}

}