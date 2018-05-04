import java.util.ArrayList;

/**
 * Recursive solution for the celebrity problem
 *
 */
public class RecursiveSolution {

    // a 2D array representing all the guests and who they know
    private int[][] problem;
    // stores all guests that need to be checked
    private ArrayList<Integer> guests = new ArrayList<>();
    // solution: records the guest who is the celebrity
    private int celebrity = -1;

    /**
     * Constructor for the class
     *
     * @param problem
     */
    public RecursiveSolution(int[][] problem) {
        this.problem = problem;
        for (int i = 0; i < problem.length; i++) {
            guests.add(i);
        }

    }

    /**
     * Finds the celebrity
     *
     * @return
     */
    public int findCelebrity() {
        int c = findCelebrityRecurse(guests);

        return c;
    }

    /**
     * Recursive function to find celebrity that
     * decreases the problem size by 1 every time it is called
     *
     * @param remainingGuests - list of guests to be checked
     * @return
     */
    public int findCelebrityRecurse(ArrayList<Integer> remainingGuests) {
        // if only one guest remains in the list,
        // checks to see whether they are celebrity
        if (remainingGuests.size() == 1) {
            if (isCelebrity(guests.get(0)) == true) {
                this.celebrity = guests.get(0);
            }
            else {
                throw new java.lang.RuntimeException("There is no celebrity!");  // throws exception if no celebrity
            }
        }
        // else checks the first two guests in the list
        // and eliminates on of them
        else {
            int A = guests.get(0);
            int B = guests.get(1);
            guests.remove(guests.indexOf(eliminateFromPair(A, B)));
            findCelebrityRecurse(guests);
        }

        return celebrity;

    }

    /**
     * Takes in two guests and eliminates one
     *
     * @param A
     * @param B
     * @return
     */
    public int eliminateFromPair (int A,int B) {
        // if A knows B, A cannot be celebrity and is eliminated
        if (problem[A][B] == 1) {
            return A;
        }
        // if A does not know B, B cannot be celebrity and is eliminated
        else {
            return B;
        }

    }

    /**
     * checks to see if a guest is a celebrity
     * by ensuring the guest does not know anyone else at the party
     *
     * @param guestNumber - identifying number of the guest to be checked
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
//        int[][] guestList = party.getProblem();
//        int answer = party.getCelebrity();
//
//        int numGuests = guestList.length;
//        for (int i = 0; i < numGuests; i++) {
//            for (int j = 0; j < numGuests; j++) {
//                System.out.print(guestList[i][j]);
//                System.out.print(' ');
//            }
//            System.out.println(' ');
//        }
//
//        RecursiveSolution solve = new RecursiveSolution(guestList);
//
//        System.out.println("Actual solution: " + answer);
//        System.out.println("Program's solution: " + solve.findCelebrity());
//    }

}
