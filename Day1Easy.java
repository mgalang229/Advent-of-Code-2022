import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1Easy {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner fs = new Scanner(new File("input.txt"));
		int best = Integer.MIN_VALUE, sum = 0;
		while (fs.hasNextLine()) {
			String s = fs.nextLine();
			if (s.isEmpty()) {
				best = Math.max(best, sum);
				sum = 0;
			} else {
				sum += Integer.parseInt(s);
			}
		}
		System.out.println(best);
		fs.close();
	}
}
