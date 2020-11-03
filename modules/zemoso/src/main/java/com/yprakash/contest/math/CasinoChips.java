/**
 * @author Prakash Yenugandula
 * Date  : 2020-11-03

When John gambles at the casino, he always uses a special system of tactics that he devised himself.
It's based on always betting in one of two ways in each game:
- betting exactly one chip (to test his luck)
- betting all-in (he bets everything he has).
Wins in the casino are paid equal to the wager, so if he bets C chips and wins, he gets 2C chips back.
If he loses, he doesn't get any chips back. It was a very lucky day yesterday and John won every game he played,
starting with one chip and leaving the casino with N chips. We also know that John played all-in no more than K times.
Your task is to calculate the smallest possible number of rounds he could have played.
Note: betting just one chip is never considered playing all-in.
Given an integer N and an integer K, write a function to return the minimum number of rounds
that are necessary for John to leave the casino with N chips, having played all-in no more than K times.
Limits: 0 <= K <= 100 and 1 <= N <= 2,147,483,647
8, 0 => 7
18, 2 => 6
10, 10 => 4
5, 1 => 3
 */

package com.yprakash.contest.math;

public class CasinoChips
{
	public static void main(String[] args) {
		int m = 4;
		int[] n = {8, 18, 10, 5};
		int[] k = {0, 2, 10, 1};
		for (int i = 0; i < m; i++) {
			System.out.println(n[i] + ", " + k[i] + " => " + solution(n[i], k[i]));
		}
	}

	private static int solution(int N, int K) {
		// if (K <= 0) return N-1; // Not needed
		int count = 0;
		while (N > 1 && K > 0) {
			if (N % 2 == 0) { // play all-in If N is even, he could get N chips from N/2 in one step
				K--;
				N /= 2;
			} else {
				N--; // Don't combine these two steps
			}
			count++;
		}
		// System.out.println(count + " " + N + " " + K);
		count += N - 1;
		return count;
	}
}
