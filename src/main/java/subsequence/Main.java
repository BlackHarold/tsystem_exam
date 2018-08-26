package subsequence;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	Subsequence s = new Subsequence();
	boolean b = s.find(Arrays.asList("A", "B", "M", "C", "D"),
		Arrays.asList("BD", "A", "ABC", "B", "M", "D", "M", "C", "DC", "D"));
	System.out.println(b); // Result: true
    }

}
