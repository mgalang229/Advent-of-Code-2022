import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*

A = rock
B = paper
C = scissors

X = rock
Y = paper
Z = scissors

opp:
A > Z
B > X
C > Y

me:
X > C
Y > A
Z > B

 */

public class Day2Hard {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner fs = new Scanner(new File("input.txt"));
		int[] score = new int[] {1, 2, 3};
		int total = 0;
		while (fs.hasNextLine()) {
			String s = fs.nextLine();
			char opp = s.charAt(0), me = s.charAt(2);
			total += score[me-'X'];
			if ((me == 'X' && opp == 'C') || (me == 'Y' && opp == 'A') || (me == 'Z' && opp == 'B')) {
				total += 6;
			} else if (me - 'X' == opp - 'A') {
				total += 3;
			}
		}
		System.out.println(total);
		fs.close();
	}
}
