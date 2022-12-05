import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day3Easy {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner fs = new Scanner(new File("input.txt"));
		int sum = 0;
		while (fs.hasNextLine()) {
			char[] s = fs.nextLine().toCharArray();
			int n = s.length;
			Component firstComp = new Component();
			Component secondComp = new Component();
			for (int i = 0; i < n; i++) {
				if (isUpper(s[i])) {
					if (i < n / 2) {
						firstComp.upper[s[i]-'A']++;
					} else {
						secondComp.upper[s[i]-'A']++;
					}
				} else {
					if (i < n / 2) {
						firstComp.lower[s[i]-'a']++;
					} else {
						secondComp.lower[s[i]-'a']++;
					}
				}
			}
			int res = 0;
			for (int i = 0; i < 26; i++) {
				if (firstComp.upper[i] > 0 && secondComp.upper[i] > 0) {
					res += 27 + i;
				}
				if (firstComp.lower[i] > 0 && secondComp.lower[i] > 0) {
					res += i + 1;
				}
			}
			sum += res;
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
		int[] upper;
		int[] lower;
		
		Component() {
			upper = new int[26];
			lower = new int[26];
			Arrays.fill(upper, 0);
			Arrays.fill(lower, 0);
		}
	}
}
