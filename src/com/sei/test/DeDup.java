package com.sei.test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class DeDup {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		// TODO Auto-generated method stub

		final int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19,
				1, 18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16,
				3, 6, 19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

		final DeDup deDup = new DeDup();
		deDup.findUniqueArray(randomIntegers);
		deDup.findSortedUniqueArray(randomIntegers);
		deDup.findUnSortedUniqueArray(randomIntegers);

	}

	// First solution : finding duplicates using brute force method
	/*
	 * Since we are comparing every element to every other element, this
	 * solution has quadratic time complexity i.e. O(n^2). This solution has the
	 * worst complexity in all three solutions.
	 */
	public Integer[] findUniqueArray(final int randomIntegers[]) {

		System.out.println("Finding Unique elements in array using brute force method");
		final ArrayList<Integer> uniArray = new ArrayList<Integer>();

		for (int i = 0; i < randomIntegers.length; i++) {
			boolean isDistinct = false;
			for (int j = 0; j < i; j++) {
				if (randomIntegers[i] == randomIntegers[j]) {
					isDistinct = true;
					break;
				}
			}
			if (!isDistinct) {
				uniArray.add(randomIntegers[i]);

			}

		}

		System.out.println("First solution  ::" + uniArray.toString());
		return uniArray.toArray(new Integer[uniArray.size()]);

	}

	// Second solution : use LinkedHashSet data structure to find duplicates
	/*
	 * Complexity of this solution is O(n) because you are only going through
	 * array one time, but it also has space complexity of O(n) because of
	 * LinkedHashSet data structure, which contains your unique elements. So if
	 * an array contains 1 million elements, in worst case you would need an
	 * LinkedHashSet to store those 1 million elements
	 */
	public Integer[] findSortedUniqueArray(final int randomIntegers[]) {

		final Set<Integer> setUniqueNumbers = new LinkedHashSet<Integer>();
		for (final int randomInteger : randomIntegers) {
			setUniqueNumbers.add(randomInteger);
		}

		System.out.println("Second solution :: " + setUniqueNumbers.toString());
		return setUniqueNumbers.toArray(new Integer[setUniqueNumbers.size()]);
	}

	/*
	 * Third solution : Use ArrayList to get same order to find unique array
	 * elements.
	 */
	/*
	 * Complexity of this solution is O(n) because you are only going through
	 * array one time,because of ArrayList data structure, it will follow the
	 * sequence we can get the same inserted order.
	 */
	public Integer[] findUnSortedUniqueArray(final int randomIntegers[]) {

		final ArrayList<Integer> uniqueArrayList = new ArrayList<Integer>();

		for (int i = 0; i < randomIntegers.length; i++) {
			if (!uniqueArrayList.contains(randomIntegers[i])) {
				uniqueArrayList.add(randomIntegers[i]);
			}
		}
		System.out.println("Third solution :: " + uniqueArrayList.toString());

		return uniqueArrayList.toArray(new Integer[uniqueArrayList.size()]);

	}

}
