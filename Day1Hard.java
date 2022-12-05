import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day1Hard {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner fs = new Scanner(new File("input.txt"));
		int[] score = new int[] {1, 2, 3};
		ArrayList<Integer> arr = new ArrayList<>();
		int sum = 0;
		while (fs.hasNextLine()) {
			String s = fs.nextLine();
			if (s.isEmpty()) {
				arr.add(sum);
				sum = 0;
			} else {
				sum += Integer.parseInt(s);
			}
		}
		Collections.sort(arr);
		int ans = 0;
		for (int i = arr.size() - 1; i >= arr.size() - 3; i--) {
			ans += arr.get(i);
		}
		System.out.println(ans);
		fs.close();
	}
}
