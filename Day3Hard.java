import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day3Hard {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner fs = new Scanner(new File("input.txt"));
		int sum = 0, num = 0;
		Component comp = new Component();
		while (fs.hasNextLine()) {
			char[] s = fs.nextLine().toCharArray();
			int n = s.length;
			for (int i = 0; i < n; i++) {
				if (isUpper(s[i])) {
					if (!comp.upperVisited[s[i]-'A']) {
						comp.upper[s[i]-'A']++;
						comp.upperVisited[s[i]-'A'] = true;
					}
				} else {
					if (!comp.lowerVisited[s[i]-'a']) {
						comp.lower[s[i]-'a']++;
						comp.lowerVisited[s[i]-'a'] = true;
					}
				}
			}
			num++;
			comp.clearBooleanArrays();
			if (num % 3 == 0) {
				for (int i = 0; i < 26; i++) {
					if (comp.upper[i] == 3) {
						sum += 27 + i;
					}
					if (comp.lower[i] == 3) {
						sum += i + 1;
					}
				}
				comp.clearIntegerArrays();
			}
		}
		System.out.println(sum);
		fs.close();
	}
	
	static boolean isUpper(char c) {
		return 'A' <= c && c <= 'Z';
	}
	
	static boolean isLower(char c) {
		return 'a' <= c && c <= 'z';
	}
	
	static class Component {
		int[] upper, lower;
		boolean[] upperVisited, lowerVisited;
		
		Component() {
			upper = new int[26];
			lower = new int[26];
			upperVisited = new boolean[26];
			lowerVisited = new boolean[26];
			clearIntegerArrays();
			clearBooleanArrays();
		}
		
		void clearIntegerArrays() {
			Arrays.fill(upper, 0);
			Arrays.fill(lower, 0);
		}
		
		void clearBooleanArrays() {
			Arrays.fill(upperVisited, false);
			Arrays.fill(lowerVisited, false);
		}
	}
}
