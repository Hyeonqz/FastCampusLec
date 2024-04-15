package org.example.flow;

public class TribonacciSequence {
	public double[] tribonacci(double[] s, int n) {

		double[] result = new double[n];

		for (int i = 0; i < s.length ; i++) {
			result[i] = s[i];
		}

		for (int i = 0; i < n-3; i++) {
			result[i+3] = result[i] + result[i+1] +result[i+2];
		}
		return result;
	}
}
