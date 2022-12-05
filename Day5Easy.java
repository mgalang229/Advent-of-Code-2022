import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/*

sample input 0:
   	[D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 

jagged array:
1 -> Z N
2 -> M C D
3 -> P

move 1 from 2 to 1
1 -> Z N D
2 -> M C
3 -> P

move 3 from 1 to 3
1 -> 
2 -> M C
3 -> P D N Z

move 2 from 2 to 1
1 -> C M
2 -> 
3 -> P D N Z

move 1 from 1 to 2
1 -> C 
2 -> M
3 -> P D N Z

answer: CMZ
1 -> (C) 
2 -> (M)
3 -> P D N (Z)

sample input 1:
    [G]         [P]         [M]    
    [V]     [M] [W] [S]     [Q]    
    [N]     [N] [G] [H]     [T] [F]
    [J]     [W] [V] [Q] [W] [F] [P]
[C] [H]     [T] [T] [G] [B] [Z] [B]
[S] [W] [S] [L] [F] [B] [P] [C] [H]
[G] [M] [Q] [S] [Z] [T] [J] [D] [S]
[B] [T] [M] [B] [J] [C] [T] [G] [N]
 1   2   3   4   5   6   7   8   9 

 */

public class Day5Easy {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner fs = new Scanner(new File("input.txt"));
		int size = 9;
		ArrayDeque<Character>[] arr = new ArrayDeque[size];
//		arr[0] = new ArrayDeque<>(Arrays.asList('Z', 'N'));
//		arr[1] = new ArrayDeque<>(Arrays.asList('M', 'C', 'D'));
//		arr[2] = new ArrayDeque<>(Arrays.asList('P'));
		arr[0] = new ArrayDeque<>(Arrays.asList('B', 'G', 'S', 'C'));
		arr[1] = new ArrayDeque<>(Arrays.asList('T', 'M', 'W', 'H', 'J', 'N', 'V', 'G'));
		arr[2] = new ArrayDeque<>(Arrays.asList('M', 'Q', 'S'));
		arr[3] = new ArrayDeque<>(Arrays.asList('B', 'S', 'L', 'T', 'W', 'N', 'M'));
		arr[4] = new ArrayDeque<>(Arrays.asList('J', 'Z', 'F', 'T', 'V', 'G', 'W', 'P'));
		arr[5] = new ArrayDeque<>(Arrays.asList('C', 'T', 'B', 'G', 'Q', 'H', 'S'));
		arr[6] = new ArrayDeque<>(Arrays.asList('T', 'J', 'P', 'B', 'W'));
		arr[7] = new ArrayDeque<>(Arrays.asList('G', 'D', 'C', 'Z', 'F', 'T', 'Q', 'M'));
		arr[8] = new ArrayDeque<>(Arrays.asList('N', 'S', 'H', 'B', 'P', 'F'));
		int counter = 0;
		while (fs.hasNextLine()) {
			char[] s = fs.nextLine().toCharArray();
			int n = s.length, len = 0, origin = 0, dest = 0;
			String str = "";
			for (int i = 5; i < n; i++) {
				 if (isDigit(s[i])) {
					 str += s[i];
				 } else if (s[i] == ' ') {
					 if (!str.isEmpty()) {
						 if (len == 0) {
							 len = Integer.parseInt(str);
						 } else {
							 origin = Integer.parseInt(str);
						 }
					 }
					 str = "";
				 }
			}
			dest = Integer.parseInt(str);
			while (len > 0) {
				arr[dest-1].addLast(arr[origin-1].pollLast());
				len--;
			}
		}
//		printStack(arr, size);
		String ans = "";
		for (int i = 0; i < size; i++) {
			ans += arr[i].peekLast();
		}
		System.out.println(ans);
		fs.close();
	}
	
	static boolean isDigit(char ch) {
		return '0' <= ch && ch <= '9';
	}
	
	static void printStack(ArrayDeque<Character>[] arr, int size) {
		for (int i = 0; i < size; i++) {
			System.out.print((i + 1) + " -> ");
			for (Character ch : arr[i]) {
				System.out.print(ch + " ");
			}
			System.out.println();
		}
	}
}
