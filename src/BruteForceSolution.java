

public class BruteForceSolution {

    private int[][] problem;
    private int celebrity = -1;

    public BruteForceSolution(int[][] problem) {
        this.problem = problem;

    }

    public int findCelebrity() {
        int numGuests = problem.length;

        for (int i = 0; i < numGuests; i++) {
            if (isCelebrity(i) == true) {
                this.celebrity = i;
                break;
            }
        }

        if (celebrity < 0) {
            throw new java.lang.RuntimeException("There is no celebrity!");
        }
        else {
            System.out.println("The celebrity is guest number " + celebrity + "!");
        }

        return celebrity;
    }

    public boolean isCelebrity(int guestNumber) {

        for (int i = 0; i < problem.length; i++) {
            if (problem[guestNumber][i] == 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        CelebrityProblemGenerator party = new CelebrityProblemGenerator(10);
        int[][] guests = party.getProblem();
        int answer = party.getCelebrity();

        int numGuests = guests.length;
        for (int i = 0; i < numGuests; i++) {
            for (int j = 0; j < numGuests; j++) {
                System.out.print(guests[i][j]);
                System.out.print(' ');
            }
            System.out.println(' ');
        }

        BruteForceSolution solve = new BruteForceSolution(guests);

        System.out.println("Actual solution: " + answer);
        System.out.println("Program's solution: " + solve.findCelebrity());
    }
}
