package com.service;

/**
 * @author AnubhavChaturvedi
 * @category AlgorithmsLabSolution
 * @date 2021-09-19
 */

public class MergeSort {

	private int[] array;

	public int[] getSortedArray(int[] array) {
		this.array = array;
		int[] temp = new int[array.length];
		// Recursively Perform Merge Sort
		mergeSort(this.array, temp, 0, this.array.length - 1);
		return this.array;
	}

	// Merge Sort Recursion
	private void mergeSort(int[] array, int[] temp, int myLeft, int myRight) {

		if (myLeft < myRight) {
			int center = (myLeft + myRight) / 2;
			mergeSort(array, temp, myLeft, center);
			mergeSort(array, temp, center + 1, myRight);
			merge(array, temp, myLeft, center + 1, myRight);
		}
	}

	// Merge Sort Algorithm
	private void merge(int[] array, int[] temp, int left, int myRight, int rightMost) {
		int leftEnd = myRight - 1;
		int k = left;
		int num = rightMost - left + 1;

		while (left <= leftEnd && myRight <= rightMost) {
			if (array[left] > array[myRight])
				temp[k++] = array[left++];
			else
				temp[k++] = array[myRight++];
		}

		while (left <= leftEnd)
			temp[k++] = array[left++];

		while (myRight <= rightMost)
			temp[k++] = array[myRight++];

		for (int i = 0; i < num; i++, rightMost--)
			array[rightMost] = temp[rightMost];

	}
}
