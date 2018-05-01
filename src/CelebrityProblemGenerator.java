import java.util.Random;

public class CelebrityProblemGenerator {

    private int[][] problem;
    private int celebrity;

    public CelebrityProblemGenerator(int numGuests) {
         this.problem = generateCelebrity(generateGuests(numGuests));

    }

    public int[][] generateGuests (int numGuests) {
        Random random = new Random();
        int[][] guests = new int[numGuests][numGuests];

        // generate random matrix
        for (int i = 0; i < numGuests; i++) {
            for (int j = 0; j < numGuests; j++) {
                if (i == j) {
                    guests[i][j] = 0;
                }
                else {
                    guests[i][j] = random.nextInt(2);
                }
            }
        }

        return guests;
    }

    public int[][] generateCelebrity (int[][] guests) {
        Random random = new Random();
        int numGuests = guests.length;

        // create celebrity
        this.celebrity = random.nextInt(numGuests);
        for (int k = 0; k < numGuests; k++) {
            guests[k][celebrity] = 1;
            guests[celebrity][k] = 0;
        }

        return guests;

    }

    public int[][] getProblem() {
        return problem;
    }

    public int getCelebrity() {
        return celebrity;
    }

/*    public static void main(String[] args){
        CelebrityProblemGenerator party = new CelebrityProblemGenerator(10);
        int[][] guests = party.getProblem();

        int numGuests = guests.length;
        for (int i = 0; i < numGuests; i++) {
            for (int j = 0; j < numGuests; j++) {
                System.out.print(guests[i][j]);
                System.out.print(' ');
            }
            System.out.println(' ');
        }

    }*/
}
