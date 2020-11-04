/**
 * @author Prakash Yenugandula
 * Date  : 2020-11-03
 * https://www.hackerrank.com/challenges/reduced-string/problem
 */

package algorithms.strings;

public class CamelCase
{
	public static void main(String[] args) {
		System.out.println(camelcase("aBcZyAx")); // 4
		System.out.println(camelcase("oneTwoThree")); // 3
		System.out.println(camelcase("saveChangesInTheEditor")); // 5
	}

	static int camelcase(String s) {
		// |s| <= 10^5, takes too much time sequentially
		return 1 + s.chars().parallel()
				.map(c -> c < 95 ? 1 : 0)
				.reduce(0, Integer::sum);
	}
}
