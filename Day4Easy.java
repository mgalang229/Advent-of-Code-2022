import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4Easy {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner fs = new Scanner(new File("input.txt"));
		int counter = 0;
		while (fs.hasNextLine()) {
			char[] s = fs.nextLine().toCharArray();
			int n = s.length;
			int firstStart = -1, firstEnd = -1;
			int secondStart = -1, secondEnd = -1;
			String num = "";
			for (int i = 0; i < n; i++) {
				if (s[i] == '-' && firstStart == -1) {
					firstStart = Integer.parseInt(num);
					num = "";
				} else if (s[i] == ',') {
					firstEnd = Integer.parseInt(num);
					num = "";
				} else if (s[i] == '-' && firstStart != -1) {
					secondStart = Integer.parseInt(num);
					num = "";
				} else {
					num += s[i];
				}
			}
			secondEnd = Integer.parseInt(num);
			if ((secondStart >= firstStart && secondEnd <= firstEnd) ||
				(firstStart >= secondStart && firstEnd <= secondEnd)) {
				counter++;
			}
		}
		System.out.println(counter);
		fs.close();
	}
}
