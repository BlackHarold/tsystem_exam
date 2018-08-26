package pyramide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	int[] numbers = { 2, 4, 3, 5, 6, 1 };
	Arrays.sort(numbers);

	List<Integer> list = new ArrayList<Integer>();
	for (int i : numbers) {
	    list.add(i);
	}

	PyramidBuilder pb = new PyramidBuilder();
	pb.buildPyramide(list);
    }

}
