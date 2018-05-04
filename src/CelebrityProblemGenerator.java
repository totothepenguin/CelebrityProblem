import java.util.Random;

/**
 * Generates a new celebrity problem for a particular number of guests
 *
 */
public class CelebrityProblemGenerator {

    // a 2D array representing all the guests and who they know
    private int[][] problem;
    // solution: records the guest who is the celebrity
    private int celebrity;

    /**
     * Constructor for the class
     *
     * @param numGuests - number of guests
     */
    public CelebrityProblemGenerator(int numGuests) {
         this.problem = generateCelebrity(generateGuests(numGuests));

    }

    /**
     * generates a random 2D array of guests and who they know
     *
     * @param numGuests - number of guests
     * @return
     */
    public int[][] generateGuests (int numGuests) {
        Random random = new Random();
        int[][] guests = new int[numGuests][numGuests];  // initializes empty array

        // generates random array
        for (int i = 0; i < numGuests; i++) {
            for (int j = 0; j < numGuests; j++) {
                if (i == j) {
                    guests[i][j] = 0;  // guests cannot know themselves
                }
                else {
                    guests[i][j] = random.nextInt(2);
                }
            }
        }

        return guests;
    }

    /**
     * generates a random celebrity
     *
     * @param guests - random 2D array without celebrity
     * @return
     */
    public int[][] generateCelebrity (int[][] guests) {
        Random random = new Random();
        int numGuests = guests.length;

        // create celebrity
        this.celebrity = random.nextInt(numGuests);
        for (int k = 0; k < numGuests; k++) {
            guests[k][celebrity] = 1; // everyone else knows celebrity
            guests[celebrity][k] = 0; // celebrity does not know anyone
        }

        return guests;
    }

    /**
     * Getter for problem variable
     *
     * @return
     */
    public int[][] getProblem() {
        return problem;
    }

    /**
     * Getter for celebrity variable
     *
     * @return
     */
    public int getCelebrity() {
        return celebrity;
    }

//    /**
//     * main method for the class
//     * (to test the generator)
//     *
//     * @param args
//     */
//    public static void main(String[] args){
//        CelebrityProblemGenerator party = new CelebrityProblemGenerator(10);
//        int[][] guests = party.getProblem();
//
//        int numGuests = guests.length;
//        for (int i = 0; i < numGuests; i++) {
//            for (int j = 0; j < numGuests; j++) {
//                System.out.print(guests[i][j]);
//                System.out.print(' ');
//            }
//            System.out.println(' ');
//        }
//    }

}
