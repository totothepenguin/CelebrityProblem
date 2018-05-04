/**
 * Brute Force solution for the celebrity problem
 *
 */
public class BruteForceSolution {

    // a 2D array representing all the guests and who they know
    private int[][] problem;
    // solution: records the guest who is the celebrity
    private int celebrity = -1;

    /**
     * Constructor for the class
     *
     * @param problem
     */
    public BruteForceSolution(int[][] problem) {
        this.problem = problem;

    }

    /**
     * finds the celebrity in the party by checking all the guests
     *
     * @return
     */
    public int findCelebrity() {
        int numGuests = problem.length;

        for (int i = 0; i < numGuests; i++) {
            if (isCelebrity(i) == true) {
                this.celebrity = i;
                break;
            }
        }

        if (celebrity < 0) {
            throw new java.lang.RuntimeException("There is no celebrity!");  // throws exception if no celebrity
        }
        else {
            System.out.println("The celebrity is guest number " + celebrity + "!");
        }

        return celebrity;
    }

    /**
     * checks to see if a guest is a celebrity
     * by ensuring the guest does not know anyone else at the party
     *
     * @param guestNumber
     * @return
     */
    public boolean isCelebrity(int guestNumber) {
        for (int i = 0; i < problem.length; i++) {
            if (problem[guestNumber][i] == 1) {
                return false;
            }
        }

        return true;
    }

//    /**
//     * main method for the class
//     * (to test the algorithm)
//     *
//     * @param args
//     */
//    public static void main(String[] args){
//        CelebrityProblemGenerator party = new CelebrityProblemGenerator(10);
//        int[][] guests = party.getProblem();
//        int answer = party.getCelebrity();
//
//        int numGuests = guests.length;
//        for (int i = 0; i < numGuests; i++) {
//            for (int j = 0; j < numGuests; j++) {
//                System.out.print(guests[i][j]);
//                System.out.print(' ');
//            }
//            System.out.println(' ');
//        }
//
//        BruteForceSolution solve = new BruteForceSolution(guests);
//
//        System.out.println("Actual solution: " + answer);
//        System.out.println("Program's solution: " + solve.findCelebrity());
//    }

}
