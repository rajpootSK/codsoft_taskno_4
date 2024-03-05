package myPackege;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

public class QuizeApplication {
	private static Scanner scanner = new Scanner(System.in);
	private static Timer timer = new Timer();
	private static boolean timeUp = false;

	public static void main(String[] args) {
		// simple quiz data
		String[] question = {
				"What is the capital of France?",
				"What is the largest planet in our solar system?",
				"What is the capital of Utter Pradesh?",
				"What is the capital of India?"
		};
		String[][] option = {
				{"Paris", "London", "Berlin"},
				{"Saturn", "Jupiter", "Earth"}, 
				{"Kanpur", "Ayodhya", "Lucknow"},
				{"Kolkata", "Delhi", "Pune"}
				
		};
		int[] answer = {1, 2 ,3, 2}; // Index of correct options (Paris, Jupiter)
		int timeLimit = 30; // Time Limit for the entire quiz in seconds
		
		// Start the timer 
		timer.schedule(new TimerTask() {
		     @Override
		     public void run() {
		    	 timeUp = true;
		     }
	},
	 timeLimit * 1000);
		
		// Run the quiz
		runQuiz(question, option,answer);
		
		// Cancel the timer 
		timer.cancel();
}
	private static void runQuiz(String[] questions, String[][] options, int[] answer) {
		int score =0;
		
		for(int i = 0; i < questions.length; i++) {
			if(timeUp) {
				System.out.println("Time's up!");
				break;
			}
			System.out.println(	"Question "+ (i+1)+ ":" + questions[i]);
			for(int j=0; j< options[i].length; j++) {
				System.out.println((j+1)+ "."+ options[i][j]);
			}
			
			int userChoice;
			try {
				userChoice = Integer.parseInt(scanner.nextLine());
			}catch (NumberFormatException e) {
				System.out.println("Invelid input! Please enter a number");
				continue;
			}
			if(userChoice == answer[i]) {
				System.out.println("Correct!");
				score++;
			}else {
				System.out.println("Incorrect!");
			}
		}
		
		System.out.println("\nYour final score is - " + score+ "/" + questions.length);
	}

}
