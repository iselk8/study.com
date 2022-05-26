import java.util.Scanner;

public class StudentQuizScore {

    // Static integer variable to keep track of the grades total, later used to compute the average
    static int gradeTotal = 0;
    // Static integer variable to count how many grades have been added to our array.
    static int gradeCounter = 0;
    // Static integer array used to store the user input
    static int[] quizGrade = new int[10];

    // The main method serves as a starting point for the application and makes the method calls for our program execution.
    public static void main(String[] args) {
        printProgramSpecification();
        inputQuizGrade();
        printGrades();
        calculateAverage();
    }

    //This method satisfies the first requirement, which is to print the programming specification. This is done with a print statement.
    private static void printProgramSpecification() {
        System.out.println("1- Create a Java project in IDE and begin the Project Program by developing a Java Method to print the programming specifications for the project.\n\n" +
                "2- Expand the Project Program and create Java code to input from the console (keyboard) the first quiz grade. Use a loop to allow the user to continue to enter grades as long as they don't enter 999 to quit.\n\n" +
                "3- Expand the Project Program and create Java code to populate the array of the student's quiz grades. The grade is added to a running total, and the count of grades entered is incremented. If the grade entered is the 10th grade, the grade is forced to 999 and the loop ends; otherwise, the user enters another quiz grade. When the loop ends count holds the number of grades entered.\n\n" +
                "4- Expand the Project Program and create Java code use another loop to print all grades in the array.\n\n" +
                "5- Expand the Project Program and create Java code to compute the average quiz grade.\n\n" +
                "6- Expand the Project Program and create Java code to use decision logic to find out the letter grade of the average based on the following grading scale and print to the console.\n" +
                "A = 90-100\n" +
                "B = 80-89\n" +
                "C = 70-79\n" +
                "D = 60-69\n" +
                "F = 0-59\n");
    }

    /* This method satisfies the second requirement, which is to accept user input through the console to allow the user to enter up to
   ten (10) quiz grades. The user is able to exit the loop by entering 999 at any time.

   This method also satisfies the third requirement, which is to populate the array of student grades and computing a total for
   the grades entered. Once the 10th grade is entered, the loop breaks.
   -----
   This was done using an instance of the Scanner Class to accept user input, a while loop to allow the user to enter multiple
   grades and if/else if statements for logical validation.
 */
    private static void inputQuizGrade() {

        Scanner consoleInput = new Scanner(System.in);
        System.out.println("Please enter a quiz grade - enter 999 to quit");
        int grade = consoleInput.nextInt();

        while (grade != 999 && gradeCounter <= 9) {
            if (grade < 0 || grade > 100) {
                System.out.println("The grade you entered is not valid, please enter a grade between 0 and 100");
                grade = consoleInput.nextInt();
            } else if (grade >= 0 && grade <= 100) {
                quizGrade[gradeCounter] = grade;
                gradeTotal += grade;
                if (++gradeCounter < 10) {
                    System.out.println("Please enter a quiz grade - enter 999 to quit");
                    grade = consoleInput.nextInt();
                }
            }
        }
    }

    /* This method satisfies the fourth requirement, which is to use a loop to print all the grades in the array.
   The grades are printed using a for loop to iterate through the array and printing each grade to the console.
 */
    private static void printGrades() {
        for (int i = 0; i < gradeCounter; i++) {
            System.out.println(quizGrade[i]);
        }
    }

    /* This method satisfies the fifth and sixth requirement, which is to compute the average quiz grade
       and use decision logic to find out the letter grade of the average based on the grade scale provided.

       The average was computed by using our static class variables and arithmetic operations.
       The letter grade is determined by if/else if statements.
     */

    private static void calculateAverage() {
        float average = (float) gradeTotal / gradeCounter;
        char letterGrade;

        if (average <= 100 && average >= 90)
            letterGrade = 'A';
        else if (average < 90 && average >= 80)
            letterGrade = 'B';
        else if (average < 80 && average >= 70)
            letterGrade = 'C';
        else if (average < 70 && average >= 60)
            letterGrade = 'D';
        else if (average < 60 && average >= 0)
            letterGrade = 'F';
        else
            letterGrade = ' ';

        System.out.println("Grade Total: " + gradeTotal);
        System.out.println("Student Counter: " + gradeCounter);
        System.out.println("Average Grade: " + average + "% - " + letterGrade);
    }


}
