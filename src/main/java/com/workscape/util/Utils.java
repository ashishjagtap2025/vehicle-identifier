package com.workscape.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Utils {

	public static final <T extends Comparable<T>> boolean equalLists(List<T> one, List<T> two) {
		if (one == null && two == null) {
			return true;
		}
		if ((one == null && two != null) || one != null && two == null || one.size() != two.size()) {
			return false;
		}
		// to avoid messing the order of the lists we will use a copy
		// as noted in comments by A. R. S.
		one = new ArrayList<T>(one);
		two = new ArrayList<T>(two);
		Collections.sort(one);
		Collections.sort(two);
		return one.equals(two);
	}
}