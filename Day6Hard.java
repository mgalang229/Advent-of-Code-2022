import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day6Hard {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner fs = new Scanner(new File("input.txt"));
		int ans = 0;
		outer: while (fs.hasNextLine()) {
			char[] s = fs.nextLine().toCharArray();
			int n = s.length;
			for (int i = 13; i < n; i++) {
				String marker = "";
				for (int j = i; j >= i - 13; j--) {
					marker += s[j];
				}
				if (isUnique(marker)) {
					ans = i + 1;
					break outer;
				}
			}
		}
		System.out.println(ans);
	}
	
	static boolean isUnique(String s) {
		char[] ss = s.toCharArray();
		boolean[] visited = new boolean[26];
		Arrays.fill(visited, false);
		for (int i = 0; i < ss.length; i++) {
			if (!visited[ss[i]-'a']) {
				visited[ss[i]-'a'] = true;
			} else {
				return false;
			}
		}
		return true;
	}
}
