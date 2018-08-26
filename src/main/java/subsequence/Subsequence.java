package subsequence;

import java.util.List;

public class Subsequence {

    @SuppressWarnings("rawtypes")
    public boolean find(List x, List y) {
	if (x != null && y != null)
	    for (int i = 0; i < (x.size() < y.size() ? y.size() : x.size()); i++) {
		if (i < x.size() && x.get(i) == null)
		    throw new IllegalArgumentException();
		if (i < y.size() && y.get(i) == null)
		    throw new IllegalArgumentException();
	    }
	else if (x == null || y == null)
	    throw new IllegalArgumentException();

	for (int i = 0; i < x.size(); i++)
	    if (!y.contains(x.get(i)))
		return false;

	int[] workArray = new int[x.size()];
	for (int i = 0; i < x.size(); i++)
	    for (int j = 0; j < y.size(); j++)
		if (y.get(j).equals(x.get(i)))
		    workArray[i] = j;

	for (int i = 1; i < x.size(); i++)
	    if (workArray[i - 1] > workArray[i])
		return false;

	return true;
    }

}