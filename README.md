Celebrity Problem:

The celebrity problem is a fairly simple problem. There is a party with a group of n people. The celebrity is the one person in the group who knows nobody but is known by everyone else. The goal of the problem is to identify the celebrity by only asking the question: “Does A know B?”

This program implements two different solutions for this problem and compares the time taken by these solutions to solve the problem:
1) Brute Force Solution
2) Recursive Solution (Decrease-By-One)


Implementation:

The problem is implemented as a 2-dimensional array. The size of the array (n) represents the number of people at the party. Each row and column represent a guest. Each value represents whether the guest in the row knows the guest in the column. A value of 0 means "does not know person" and a value of 1 means "knows person". We assume people don’t know themselves.

The program includes a CelebrityProblemGenerator class that can generate a celebrity problem of n size.


Brute Force Solution:

The BrutForceSolution class checks each row in the 2D array. If all values in the row are 0, the guest represented by that row is the celebrity.


Recursive Solution: 

The RecursiveSolution class uses a recursive funtion to decreases problem size by 1 every time it is called. If there are more than one people, the program compares the first two people, A and B. If A knows B, then A cannot be the celebrity. A is eliminated and B might be the celebrity. If A does not know B, then B cannot be the celebrity. B is eliminated and A might be the celebrity. After eliminating one person, the program runs the algorithm recursively on the remaining people. If there is only one person, the program checks whether that person is the celebrity (i.e. they  know no one else). 

Alternative Stack Implementation:
The decrease-by-one solution can be implemented more efficiently using a stack. Each guest is put in a stack. The top two guests are removed and compared using the same criteria as above. One of them is eliminated. The remaining guest is put back on the stack and the process is repeated. This implementation is not included in the program.


Time Comparison:

The CelebrityProblem class generates a new celebrity problem for every try and then used both solutions to solve it, recording the time taken by each of them. The average time taken by both solutions was recorded for  100 tries. The problem size used was n = 2000. The Recursive Solution took 6.5 milliseconds on average and the Brute Force Solution took 2 milliseconds on average. The Brute Force Solution is much faster as recursion makes the program call the function multiple times. 


Future Improvements:

The stack implementation for the decrease-by-one solution is more efficient and should be compared as well. If the problem is implemented using a graph, more solutions can be tested. Other possible solutions are:
 - Decrease-by-half
 - Using two pointers (solving from both ends)

