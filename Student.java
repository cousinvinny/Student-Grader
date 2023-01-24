/*
Name: Vinh Nguyen
Class: 35A 63Z
Assignment #5
Due Date: 3/7/22
Date Submitted: 3/7/22

************************* Design Steps *************************
1. Variables
	(private int) instance variable needed to hold student id # - SID
	(private int[]) instance variable needed to hold student's quiz scores - scores[]
2. Input
	none
3. Processing
	setters and getters
4. Output (in words not code)
	Print student ID followed by 5 quiz scores
*/
package model;

public class Student {
	private int SID;
	private int scores[] = new int[5];
	public Student() {} //default constructor
	public Student(int sID, int[] scores) {
		super();
		this.SID = sID;
		this.scores = scores;
	}
	public int getSID() {
		return SID;
	}
	public void setSID(int sID) {
		SID = sID;
	}
	public int[] getScores() {
		return scores;
	}
	
	
	public void setScores(int[] scores) {
		for(int i = 0; i < 5; i ++)
			this.scores[i] = scores[i];
	}
	
	public void print() {
		System.out.printf("%4d", SID);
		for(int i = 0; i < 5; i++) {
			System.out.printf(" %3d ", scores[i]);
		}
		System.out.printf("\n");
	}
}
