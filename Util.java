/*

************************* Design Steps *************************
1. Variables
	Method Variables
	(int) variable needed for line #, student count, student id, and file column - lineCount, studentCount, studentID, fileColumn
	(int []) variable needed to save quiz scores after reading from file - quizScores[]
	(String) variable needed temporarily when tokenizing line
	(StringTokenizer) variable needed to start tokenizing lines - st
2. Input
	none
3. Processing
	Open file, file reader, and buffered reader
	while not end of file, read each line
		skip the header line
		tokenize each line 
			1st token is the student id
			the rest of the tokens are the quiz scores
			save student id and quiz scores to student object
		loop and go to next line
4. Output (in words not code)
	Print low scores: quiz1 quiz2 quiz3 quiz4 quiz5
	Print high scores: quiz1 quiz2 quiz3 quiz4 quiz5
	Print average scores: quiz1 quiz2 quiz3 quiz4 quiz5
	Print all of the above together
*/
package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import model.Student;

public class Util {

	public Util() {
	}

	public static Student[] readFile(String filename, Student[] stu) {
		int lineCount = 0, studentCount = 0, studentID = 0, fileColumn = 0;
		int[] quizScores = new int[5];
		String save1 = "";
		
		try {
			FileReader file = new FileReader(filename); // Open the file using FileReader Object.
			BufferedReader buff = new BufferedReader(file);
			boolean eof = false;
			while (!eof) {
				String line = buff.readLine(); // In a loop read a line using readLine method.
				lineCount++;
				if (line == null)
					eof = true;
				else {
					if (lineCount == 1)// ignore header in file
						;
					if (lineCount > 1 && studentCount < 40 && line.length() > 0) {
						StringTokenizer st = new StringTokenizer(line);
						while (st.hasMoreTokens()) {
							save1 = st.nextToken(); //get next part of token
							studentID = Integer.parseInt(save1); //convert string SID to integer
							stu[studentCount].setSID(studentID); //save ID for each student
							for (fileColumn = 2; fileColumn <= 6; fileColumn++) {
								save1 = st.nextToken();
								quizScores[fileColumn - 2] = Integer.parseInt(save1); //convert string score to integer
							}
							stu[studentCount].setScores(quizScores); //save scores to each student
							studentCount++;
						}
					}
				}
			}
			buff.close();
		} catch (IOException e) {
			System.out.println("Error -- " + e.toString());
		}
		return stu;
	}
	
	public void print(){
		System.out.printf("This is Util class!");
	}
}

