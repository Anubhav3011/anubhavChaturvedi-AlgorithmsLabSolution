package com.service;

/**
 * @author AnubhavChaturvedi
 * @category AlgorithmsLabSolution
 * @date 2021-09-19
 */

public class TransactionService {

	private int[] transactions;
	private int target;

	public TransactionService(int[] transactions, int target) {
		super();
		this.transactions = transactions;
		this.target = target;
	}

	public int checkTarget() {
		int count = 0;
		int sum = 0;
		if (target <= 0)
			return -1;
		for (int i = 0; i < transactions.length; i++) {
			sum += transactions[i];
			count++;
			if (sum >= target)
				break;
			else if ((count == transactions.length) && (sum < target))
				return 0;
		}
		return count;
	}
}
