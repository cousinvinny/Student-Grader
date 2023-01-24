/*
************************* Design Steps *************************
1. Variables
	(int) variable needed to store input from user in menu - userInput
	(Scanner) variable needed to instantiate Scanner object - in
	(Student) array needed for student objects and perform calculations with - students[]
2. Input
	Use scanner to read in user input for menu, options that show analytics across 5 quizzes
		input 1 to show low scores
		input 2 to show high scores
		input 3 to show average scores
		input 4 to print low, high, and average scores
		input 0 to quit
3. Processing
	Read in student IDs and quiz scores from text file using readFile method
	Find the low scores, high scores, and average scores across 5 quizzes
4. Output (in words not code)
	Print data from file
	Print welcome to app prompt
	Print menu and options
		option 1 - print low scores, one for each quiz
		option 2 - print high scores, one for each quiz
		option 3 - print average scores, one for each quiz
		option 4 - print all analytics
	Print exit message
*/

package driver;

import java.util.Scanner;
import model.*;
import util.*;

public class Driver {

	public static void main(String[] args) {
		int userInput = 1;
		Scanner in = new Scanner(System.in);
		Student students[] = new Student[40];
		Statistics stats = new Statistics();
		for(int i = 0; i < 40; i++) {
			students[i] = new Student();
		}
		students = Util.readFile("C:\\Users\\Vinh T Nguyen\\eclipse-workspace\\assignment5\\src\\quizdata4.txt", students);
		System.out.printf("  ***Student Quiz Scores***\nStud  Q1   Q2   Q3   Q4   Q5\n");
		for(int i = 0; i < 40; i++) {
			if(students[i].getSID() != 0)
				students[i].print();
		}
		stats.findlow(students);
		stats.findhigh(students);
		stats.findavg(students);
		System.out.printf("******************************");
		System.out.printf("\n\nWelcome to Quiz Analytics App!\n\n");
		while(userInput != 0) {
			System.out.printf("Analytics Menu\n");
			System.out.printf(" 1) Low Scores\n");
			System.out.printf(" 2) High Scores\n");
			System.out.printf(" 3) Average Scores\n");
			System.out.printf(" 4) Low, High, and Average Scores\n");
			System.out.printf("\nEnter a number between <1-4> or 0 to quit: ");
			userInput = in.nextInt();
			while(userInput < 0 || userInput > 4) {
				System.out.printf("Error -- Please enter a number between <0-4>: ");
				userInput = in.nextInt();
			}
			stats.print(userInput);
		}
		in.close();
		System.out.printf("\nThank you for using Quiz Analytics App\n\tNow Exiting...");
	}
}

/*
  ***Student Quiz Scores***
Stud  Q1   Q2   Q3   Q4   Q5
1234  52    7  100   78   34 
2134  90   36   90   77   30 
3124 100   45   20   90   70 
4532  11   17   81   32   77 
5678  20   12   45   78   34 
6134  34   80   55   78   45 
7874  60  100   56   78   78 
8026  70   10   66   78   56 
9893  34    9   77   78   20 
1947  45   40   88   78   55 
2877  55   50   99   78   80 
3189  22   70  100   78   77 
4602  89   50   91   78   60 
5405  11   11    0   78   10 
6999   0   98   89   78   20 
******************************

Welcome to Quiz Analytics App!

Analytics Menu
 1) Low Scores
 2) High Scores
 3) Average Scores
 4) Low, High, and Average Scores

Enter a number between <1-4> or 0 to quit: 1

Low Scores: 0 7 0 32 10

Analytics Menu
 1) Low Scores
 2) High Scores
 3) Average Scores
 4) Low, High, and Average Scores

Enter a number between <1-4> or 0 to quit: 2

High Scores: 100 100 100 90 80

Analytics Menu
 1) Low Scores
 2) High Scores
 3) Average Scores
 4) Low, High, and Average Scores

Enter a number between <1-4> or 0 to quit: -3
Error -- Please enter a number between <0-4>: 5
Error -- Please enter a number between <0-4>: 3

Average Scores: 46.2 42.3 70.5 75.7 49.7

Analytics Menu
 1) Low Scores
 2) High Scores
 3) Average Scores
 4) Low, High, and Average Scores

Enter a number between <1-4> or 0 to quit: 4

*** Printing All ***
Low Scores: 0 7 0 32 10
High Scores: 100 100 100 90 80
Average Scores: 46.2 42.3 70.5 75.7 49.7

Analytics Menu
 1) Low Scores
 2) High Scores
 3) Average Scores
 4) Low, High, and Average Scores

Enter a number between <1-4> or 0 to quit: -1
Error -- Please enter a number between <0-4>: 0

Thank you for using Quiz Analytics App
	Now Exiting...
*/
