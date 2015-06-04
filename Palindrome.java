import java.util.*;

public class Palindrome {
	static int max = 0, startRow = 0, startCol = 0, endRow = 0, endCol = 0, current = 0;
	
	public static void main(String[] args) {
		System.out.println('\n');
		System.out.println("*****************************************");
		System.out.println("MARSHALL'S SUPERIOR ALGORITHMN TO HUNG'S");
		System.out.println("*****************************************");
		char[] input = {'B', 'B', 'B', 'T', 'B', 'B', 'B', 'A', 'A', 'A', 'A', 'T', 'A', 'A'};
		char[] input2 = {'A', 'C', 'G', 'T', 'G', 'T', 'C', 'A', 'A', 'A', 'A', 'T', 'C', 'G'};
		int index = 0;
		System.out.print("  ");
		while (index < input.length) {
				System.out.print(' ');
				System.out.print(input[index]);
				index++;
			}
		int[][] filledArray = fillArray(input, input);
		findPalindrone(filledArray);
		startCol = endCol - max + 1;
		endCol++;
		System.out.println("Start Column: " + startCol + " End Column: " + endCol );
		System.out.println("Length of Palindrome: " + max);
		System.out.println("----------------------------------------");
		for (; startCol < endCol; startCol++) {
			System.out.print(input[startCol]);
			if (startCol != (endCol -1)) System.out.print(", ");
		}
		System.out.println(' ');
		System.out.println("----------------------------------------");
	}
	/* This method will take in a 2d int array and find the max length as well 
     * as the indexes of the palindrome of the inputted character array
     * These variables will be stored as static
     * Param: int[][]
     * Return: none
     */
	public static void findPalindrone(int[][] input) {
		//Ignore the top row, and the last column avoiding out of bounds exc
		for (int i = 0; i < input[0].length - 1; i++) {
			for (int j = 1; j < input[0].length; j++)
				//Check cell up one, to the right as well as own cell
				if(input[j-1][i+1] != 0 && input[j][i] != 0) {
					//Update the up one/right cell 
					current = (input[j][i] + 1); 
					input[j-1][i+1] = current;
					//Update Max
					if (current > max) {
						max = current;
						endCol = i + 1;
					}
				}
			}
		}	
	
	public static int[][] fillArray (char[] c1, char[] c2) {
		int length = Math.max(c1.length, c2.length);
		int[][] toReturn = new int[length][length];
		for (int i = 0; i < length; i++) {
			System.out.println(' ');
			System.out.print(c1[i]);
			System.out.print(' ');
			for (int j = 0; j < length; j++) {
				if (c1[i] == c2[j]) toReturn[i][j] = 1;
				else toReturn[i][j] = 0;
				System.out.print(" " + toReturn[i][j]);
			}
		}
		System.out.println('\n');
		return toReturn;
	}
}