
/**
 * Write a description of class StaffCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StaffCard extends Card 
{
    private int employeeNumber;  // Employee number
    private String jobDescription; // Job description
    private int journeyScore; // Journey score

    // Constructor to initialize a staff card with highest luxury rating of 10, 0 bitcoins, employee number, and job description
    public StaffCard(int cardId, String name, int luxuryRating, int employeeNumber, String jobDescription) {
        super(cardId, name, 10, 0);  // 0 bitcoins by default, luxuryRating = 10
        this.employeeNumber = employeeNumber;
        this.jobDescription = jobDescription;
        this.journeyScore = 0;
    }
    
    // Update after shuttle journey: no points added, but journey score increases by 1
    @Override
    public void updateAfterShuttleJourney() {
        journeyScore++; // Add 1 to journey score
        // No need to deduct bitcoins as it's always 0 for staff
    }

    // Override toString() to include employee information and journey score
    @Override
    public String toString() {
        return super.toString() + ", Job Description: " + jobDescription + ", Employee Number: " + employeeNumber + ", Journey Score: " + journeyScore;
    }
}


