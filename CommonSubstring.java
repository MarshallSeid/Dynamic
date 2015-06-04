import java.util.*;

public class CommonSubstring {
	//Find longest common substring between two string
	public static void main(String[] args) {
		//Two strings to be inputted
		char[] s1 = {'M', 'A', 'N', 'R', 'S'};
		char[] s2 = {'M', 'A', 'R', 'S', 'H', 'A', 'L', 'L'};
		int[][] returned = findLongestSubStr(s1, s2);
		//Print out bool array
		int max = 0, startI =0, startJ = 0, endI = 0, endJ = 0;
		int length = Math.max(s1.length, s2.length);
		//Top to bottom
		for (int i = 0; i < Math.max(s1.length, s2.length); i++) {
			System.out.println(' ');
			for (int j = 0; j < Math.max(s1.length, s2.length); j++) {
				//Deal with first column
				if (i == 0 || j == 0 ) {
					System.out.print(' ');
					System.out.print(returned[j][i]);
					System.out.print(' ');
					if (returned[j][i] == 1) { 
						endI = i; 
						endJ = j;
					}
					continue;
				}
				if (returned[j-1][i-1]!=0 && returned[j][i] == 1) {
					returned[j][i] = (returned[j-1][i-1] +1);
				}
				if (returned[j][i] > max) {
					max = returned[j][i];
					endI = i;
					endJ = j;
				}
				System.out.print(' ');
				System.out.print(returned[j][i]);
				System.out.print(' ');
			}
		}
		//Calculating start indexes
		startI = endI - max + 1;
		startJ = endJ - max + 1;
		endI = endI + 1;
		endJ = endJ + 1;
		System.out.println(' ');
		System.out.println("StartI " + startI);
		System.out.println("EndI: " + endI);
		System.out.println("StartJ: " + startJ);
		System.out.println("End j: " + endJ);
		System.out.println("Max: " + max);
		for (int index = startI; index < endI; index++) {
			System.out.print(s2[index]);
			if(index != (endI-1))System.out.print(", ");
			else System.out.println(' ');
		}
	}
/* Fills out 2D int array with 1's if the row string letter matches the column 
 * string letter, 0's if they do not match
 * Parameters: char[] s1, char[] se2
 * Return: 2D Boolean Array
 */
   public static int[][] findLongestSubStr(char[] s1, char[] s2) {
   	//Find max length of char arrays to get size of int array
   	int length = Math.max(s1.length, s2.length);
	int[][] compareArr = new int[length][length];
	if (length == 0) return compareArr;
	//Loop top to bottom, then row
   	for (int i = 0; i < s1.length; i++) {
   		System.out.println(' ');
   		for (int j = 0; j < s2.length; j++) {
	   		//Check if letters are equal
			if (s1[i] == s2[j]) compareArr[i][j] = 1;
			else compareArr[i][j] = 0;
      }
   	}
   	//Print out the array
   	for (int k = 0; k < length; k++) {
   			System.out.println(' ');
   		for (int l = 0; l < length; l++) {
   			System.out.print(' ');
			System.out.print(compareArr[l][k]);
			System.out.print(' ');
   		}
   	}
   	System.out.println(' ');

   	return compareArr;
   }
}