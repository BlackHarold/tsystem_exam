package pyramide;

import java.util.List;

public class PyramidBuilder {

    public int[][] buildPyramide(List<Integer> inputNumbers) {

	List<Integer> list = inputNumbers;

	int size = list.size();

	// height & width of Pyramid
	int h = 0, w = 0;

	for (int i = 0; i < list.size(); i++) {
	    if (list.get(i) != null) {
		size -= i;

		if (size > 0) {
		    h++;
		}
	    } else {
		throw new CannotBuildPyramidException();
	    }
	}

	int count1 = 0;
	int count2 = 0;

	w = h * 2 - 1;

	int[][] pyramid = new int[h][w];

	for (int i = 0; i < h; i++) {
	    int k = h - i - 1;
	    count1++;
	    int over = 0;
	    while (k <= w && over < count2) {

		for (int j = 0; j < count2; j++) {

		    if (list.size() > count1 && k < w) {
			pyramid[i][k] = list.get(count1);
			count1++;
			over++;
			k += 2;
		    } else {
			pyramid[i][w - 1] = list.get(count1);
		    }
		}
	    }

	}
	return pyramid;
    }
}
