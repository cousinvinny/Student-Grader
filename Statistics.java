/*
************************* Design Steps *************************
1. Variables
	(private int[]) instance variable needed to hold quiz low scores - lowscores[]
	(private int[]) instance variable needed to hold quiz high scores - highscores[]
	(private int[]) instance variable needed to hold quiz average scores - avgscores[]
	
   Method Variables
	(int) variables needed for loop counters, # of students, lowest score, highest score, sum, quiz #, # of actual students
		- counter1, counter2, studentCounter, low, high, sum, quizNumber, actualStudents;
	(final int) variable that holds # of quizzes - quizAmount
	(Student[]) temporary object to use when performing calculations - temp[]
2. Input
	none
3. Processing
	findlow method
		loop through each quiz one at a time
		save the scores of ex. quiz 1 to a new array so long as the student id is not 0
		loop through the scores for each quiz and save the lowest score to lowscores array
		move to next quiz
	findhigh method
		loop through each quiz one at a time
		save the scores of ex. quiz 1 to a new array so long as the student id is not 0
		loop through the scores for each quiz and save the highest score to highscores array
		move to next quiz
	findavg method
		loop through each quiz one at a time
		save the scores of ex. quiz 1 to a new array so long as the student id is not 0
		loop through the scores for each quiz and save the lowest score to lowscores array
		
4. Output (in words not code)
	Print low scores: lowest score for each quiz
	Print high scores: highest score for each quiz
	Print average scores: average score for each quiz
	Print all of the above together
*/
package model;

public class Statistics {
	private int[] lowscores = new int[5];
	private int[] highscores = new int[5];
	private float[] avgscores = new float[5];

	public Statistics() {
	}// default constructor

	public void findlow(Student[] a) {
		
		Student temp[] = a;
		int counter1, counter2, studentCounter = 0, low = 0, quizNumber = 0, actualStudents = 0;
		final int quizAmount = 5;
		int quizScore[] = new int[a.length];
		for (int i = 0; i < quizAmount; i++) {
			for (counter1 = 0; counter1 < a.length; counter1++) {
				if (temp[counter1].getSID() != 0) {
					quizScore[counter1] = temp[studentCounter].getScores()[i];
					studentCounter++;
					actualStudents++;
				}
			}
			low = quizScore[0];
			for (counter2 = 0; counter2 < actualStudents; counter2++) {
				if (quizScore[counter2] < low)
					low = quizScore[counter2];
			}
			lowscores[quizNumber] = low;
			quizNumber++;
			counter1 = 0;
			counter2 = 0;
			studentCounter = 0;
			actualStudents = 0;
		}
	}

	public void findhigh(Student[] a) {
		
		Student temp[] = a;
		int counter1, counter2, studentCounter = 0, high = 0, quizNumber = 0, actualStudents = 0;
		final int quizAmount = 5;
		int quizScore[] = new int[a.length];
		for (int i = 0; i < quizAmount; i++) {
			for (counter1 = 0; counter1 < a.length; counter1++) {
				if (temp[counter1].getSID() != 0) {
					quizScore[counter1] = temp[studentCounter].getScores()[i];
					studentCounter++;
					actualStudents++;
				}
			}
			high = quizScore[0];
			for (counter2 = 0; counter2 < actualStudents; counter2++) {
				if (quizScore[counter2] > high)
					high = quizScore[counter2];
			}
			highscores[quizNumber] = high;
			quizNumber++;
			counter1 = 0;
			counter2 = 0;
			studentCounter = 0;
			actualStudents = 0;
		}
	}

	public void findavg(Student[] a) {
		
		Student temp[] = a;
		int counter1, studentCounter = 0, quizNumber = 0, actualStudents = 0;
		float sum = 0;
		final int quizAmount = 5;
		for (int i = 0; i < quizAmount; i++) {
			for (counter1 = 0; counter1 < a.length; counter1++) {
				if (temp[counter1].getSID() != 0) {
					sum += temp[studentCounter].getScores()[i];
					studentCounter++;
					actualStudents++;
				}
			}
			if(actualStudents == 0) {
				actualStudents = 1;
			}
			avgscores[quizNumber] = sum/actualStudents;
			quizNumber++;
			counter1 = 0;
			sum = 0;
			studentCounter = 0;
			actualStudents = 0;
		}
	}

	public void print(int option) {
		
		switch (option) {
		case 1:
			System.out.printf("\nLow Scores:");
			for (int i = 0; i < this.lowscores.length; i++)
				System.out.printf(" %d", this.lowscores[i]);
			System.out.printf("\n\n");
			break;
		case 2:
			System.out.printf("\nHigh Scores:");
			for (int i = 0; i < this.highscores.length; i++)
				System.out.printf(" %d", this.highscores[i]);
			System.out.printf("\n\n");
			break;
		case 3:
			System.out.printf("\nAverage Scores:");
			for (int i = 0; i < this.avgscores.length; i++)
				System.out.printf(" %.1f", this.avgscores[i]);
			System.out.printf("\n\n");
			break;
		case 4:
			System.out.printf("\n*** Printing All ***\n");
			System.out.printf("Low Scores:");
			for (int i = 0; i < this.lowscores.length; i++)
				System.out.printf(" %d", this.lowscores[i]);
			System.out.printf("\n");
			System.out.printf("High Scores:");
			for (int i = 0; i < this.highscores.length; i++)
				System.out.printf(" %d", this.highscores[i]);
			System.out.printf("\n");
			System.out.printf("Average Scores:");
			for (int i = 0; i < this.avgscores.length; i++)
				System.out.printf(" %.1f", this.avgscores[i]);
			System.out.printf("\n\n");
			break;
		default:
			break;
		}
	}
}
