import java.util.ArrayList;

public class RecursiveSolution {
    private int[][] problem;
    private ArrayList<Integer> guests = new ArrayList<>();
    private int celebrity = -1;

    public RecursiveSolution(int[][] problem) {
        this.problem = problem;
        for (int i = 0; i < problem.length; i++) {
            guests.add(i);
        }

    }

    public int findCelebrity() {
        int c = findCelebrityRecurse(guests);
        return c;

    }

    public int findCelebrityRecurse(ArrayList<Integer> remainingGuests) {

        if (remainingGuests.size() == 1) {
            if (isCelebrity(guests.get(0)) == true) {
                this.celebrity = guests.get(0);
                System.out.println("The celebrity is guest number " + celebrity + "!");
            }
            else {
                throw new java.lang.RuntimeException("There is no celebrity!");
            }
        }
        else {
            int A = guests.get(0);
            int B = guests.get(1);
            guests.remove(guests.indexOf(eliminateFromPair(A, B)));
            findCelebrityRecurse(guests);
        }

        return celebrity;

    }

    public int eliminateFromPair (int A,int B) {
            if (problem[A][B] == 1) {
                return A;
            }
            else {
                return B;
            }
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
        int[][] guestList = party.getProblem();
        int answer = party.getCelebrity();

        int numGuests = guestList.length;
        for (int i = 0; i < numGuests; i++) {
            for (int j = 0; j < numGuests; j++) {
                System.out.print(guestList[i][j]);
                System.out.print(' ');
            }
            System.out.println(' ');
        }

        RecursiveSolution solve = new RecursiveSolution(guestList);

        System.out.println("Actual solution: " + answer);
        System.out.println("Program's solution: " + solve.findCelebrity());
    }
}
