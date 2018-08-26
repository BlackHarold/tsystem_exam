package calculator;

import java.util.LinkedList;

//this example shows us Reverse Polish notation (RPN) by Yan Lucasevich
public class Calculator {

    static boolean sInterval(char c) {
	return c == ' ';
    }

    static boolean isOperator(char c) {
	return c == '+' || c == '-' || c == '*' || c == '/';
    }

    static int opPriority(char op) {
	switch (op) {
	case '+':
	case '-':
	    return 1;
	case '*':
	case '/':
	    return 2;
	default:
	    return -1;
	}
    }

    static void processOperator(LinkedList<Integer> st, char op) {
	int r = st.removeLast();
	int l = st.removeLast();
	switch (op) {
	case '+':
	    st.add(l + r);
	    break;
	case '-':
	    st.add(l - r);
	    break;
	case '*':
	    st.add(l * r);
	    break;
	case '/':
	    st.add(l / r);
	    break;
	}
    }

    public String evaluate(String string) {

	LinkedList<Integer> st = new LinkedList<>();
	LinkedList<Character> op = new LinkedList<>();

	try {

	    for (int i = 0; i < string.length(); i++) {
		char c = string.charAt(i);
		if (sInterval(c))
		    continue;

		if (c == '(') {
		    op.add('(');
		} else if (c == ')') {
		    while (op.getLast() != '(')
			processOperator(st, op.removeLast());
		    op.removeLast();
		} else if (isOperator(c)) {
		    while (!op.isEmpty() && opPriority(op.getLast()) >= opPriority(c))
			processOperator(st, op.removeLast());
		    op.add(c);
		} else {
		    String operand = "";
		    while (i < string.length() && Character.isDigit(string.charAt(i))) {
			operand += string.charAt(i++);
		    }
		    --i;
		    st.add(Integer.parseInt(operand));

		}
	    }
	    while (!op.isEmpty()) {
		processOperator(st, op.removeLast());
	    }
	    return st.get(0).toString();
	} catch (Exception e) {
	    return null;
	}
    }
}
