
public class CelebrityProblem {

    public static void main(String[] args){

        long total_time_BF = 0;
        long total_time_R = 0;

        int numTries = 100;
        int problemSize = 20000;
        for (int i = 0; i < numTries; i++) {

            CelebrityProblemGenerator party = new CelebrityProblemGenerator(problemSize);
            int[][] guests = party.getProblem();

            long start_time_BF = System.currentTimeMillis();
            BruteForceSolution solve1 = new BruteForceSolution(guests);
            System.out.println("The celebrity is guest number " + solve1.findCelebrity() + "!");
            long end_time_BF = System.currentTimeMillis();

            long time_taken_BF = end_time_BF - start_time_BF;
            total_time_BF += time_taken_BF;
            System.out.println("Total Time: " + total_time_BF);

            long start_time_R = System.currentTimeMillis();
            RecursiveSolution solve2 = new RecursiveSolution(guests);
            System.out.println("The celebrity is guest number " + solve2.findCelebrity() + "!");
            long end_time_R = System.currentTimeMillis();

            long time_taken_R = end_time_R - start_time_R;
            total_time_R += time_taken_R;
            System.out.println("Total Time: " + total_time_R);

        }

        double avg_time_BF = total_time_BF/(long)numTries;
        System.out.println("The average time taken by the Brute Force Solution for a problem of size " + problemSize + " is " + avg_time_BF + " milliseconds.");

        double avg_time_R = total_time_R/(long)numTries;
        System.out.println("The average time taken by the Recursive Solution for a problem of size " + problemSize + " is " + avg_time_R + " milliseconds.");

    }

}
