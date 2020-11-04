/**
 * @author Prakash Yenugandula
 * Date  : 2020-11-03
 * https://www.hackerrank.com/challenges/weighted-uniform-string/problem
 */

package algorithms.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WeightedUniformStrings
{
	// It is 100% accepted solution
	static String[] weightedUniformStrings(String s, int[] queries) {
		int max = 10000001;
		boolean[] res = new boolean[max];
		char[] ch = s.toCharArray();
		int i, j, n = ch.length;
		for(i = 0; i < n; ) {
			int x = getInt(ch[i]);
			// System.out.println(ch[i] + " = " + x);
			int sum = 1;
			res[x] = true;
			for(j = i+1; j < n && ch[i] == ch[j]; j++) {
				sum++;
				if(sum * x < max) {
					res[sum * x] = true;
				}
			}
			i = j;
		}

		n = queries.length;
		String[] res2 = new String[n];
		for (i = 0; i < n; i++) {
			res2[i] = res[queries[i]] ? "Yes" : "No";
		}
		return res2;
	}

	private static int getInt(char c) {
		return (int) c - 96;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scanner.nextLine();

		int queriesCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] queries = new int[queriesCount];

		for (int i = 0; i < queriesCount; i++) {
			int queriesItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			queries[i] = queriesItem;
		}

		String[] result = weightedUniformStrings(s, queries);

		for (int i = 0; i < result.length; i++) {
			bufferedWriter.write(result[i]);

			if (i != result.length - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();
		bufferedWriter.close();
		scanner.close();
	}
}