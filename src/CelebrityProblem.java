/**
 * Compares the time taken by two algorithms (BruteForceSolution and RecursiveSolution)
 * to solve the celebrity problem for increasing sizes of the problem.
 *
 */
public class CelebrityProblem {

    /**
     * Main method of the class.
     *
     * @param args
     */
    public static void main(String[] args){

        double numTries = 20.00;
        int problemSize = 625;
        while (problemSize < 20001) {

            long total_time_BF = 0;
            long total_time_R = 0;

            for (int i = 0; i < numTries; i++) {

                // generates a new problem
                CelebrityProblemGenerator party = new CelebrityProblemGenerator(problemSize);
                int[][] guests = party.getProblem();

                // solves the problem using a brute force algorithm
                // and records the time taken by the algorithm to solve it
                long start_time_BF = System.currentTimeMillis();
                BruteForceSolution solve1 = new BruteForceSolution(guests);
                System.out.println("The celebrity is guest number " + solve1.findCelebrity() + "!");
                long end_time_BF = System.currentTimeMillis();
                long time_taken_BF = end_time_BF - start_time_BF;
                total_time_BF += time_taken_BF;

                // solves the problem using a recursive algorithm
                // and records the time taken by the algorithm to solve it
                long start_time_R = System.currentTimeMillis();
                RecursiveSolution solve2 = new RecursiveSolution(guests);
                System.out.println("The celebrity is guest number " + solve2.findCelebrity() + "!");
                long end_time_R = System.currentTimeMillis();
                long time_taken_R = end_time_R - start_time_R;
                total_time_R += time_taken_R;

            }

            // calculates and prints the average time taken
            // by the brute force algorithm to solve the problem
            double avg_time_BF = total_time_BF/(long)numTries;
            System.out.println("The average time taken by the Brute Force Solution for a problem of size " + problemSize + " is " + avg_time_BF + " milliseconds.");

            // calculates and prints the average time taken
            // by the recursive algorithm to solve the problem
            double avg_time_R = total_time_R/(long)numTries;
            System.out.println("The average time taken by the Recursive Solution for a problem of size " + problemSize + " is " + avg_time_R + " milliseconds.");

            problemSize *= 2;  // doubles the problem size

        }

    }

}
