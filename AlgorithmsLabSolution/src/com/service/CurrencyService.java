package com.service;

/**
 * @author AnubhavChaturvedi
 * @category AlgorithmsLabSolution
 * @date 2021-09-19
 */

public class CurrencyService {

	private int[] currencies;
	private int[] noteCounter;

	public CurrencyService(int[] currencies) {
		super();
		this.currencies = currencies;
		this.noteCounter = new int[currencies.length];
	}

	public int[] checkAmount(int amount) {
		if (amount <= 0)
			return null;
		for (int i = 0; i < currencies.length; i++) {
			if (amount >= currencies[i]) {
				noteCounter[i] = amount / currencies[i];
				amount = amount - noteCounter[i] * currencies[i];
			}
		}
		if (amount > 0)
			return null;
		return noteCounter;
	}
}
