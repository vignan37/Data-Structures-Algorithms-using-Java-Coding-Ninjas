//Have a boolean array that tracks who will win in each index, if index =1 then beerus will win if 0 the wiss
//3 cases where
// i<x&y they can only make 1 move
// if x<i<y person can make either 1 or x move
// if x<y<i then person can make any of three moves 1 , x or y
// Trick if A wins at n-1 state, b will win at n state., use not.

public class Solution {

	public static String findWinner(int n, int x, int y) {
		// We are assuming that y is greater than or equal to x
		if (x > y) {
			int tmp = x;
			x = y;
			y = tmp;
		}
		/*
		 * dp[i] represents whether Beerus will winn provided that "i" coins
		 * are remaining and it is Beerus' turn.
		 * If Beerus will win in that scenario, dp[i] will be true otherwise
		 * it'll be false.
		 */
		boolean[] dp = new boolean[n + 1];

		// i represent number of remaining coins
		for (int i = 1; i <= n; i++) {
			// Trivial case: if 1, x or y coins are remaining and it's Beerus turn,
			// he will simply pick up all coins and win the game.
			if (i == 1 || i == x || i == y)
				dp[i] = true;
			/*
			 * If less than x coins remain, each player can only pick up one coin per turn.
			 * so the result of the game when i coins are remaining will be the reverse
			 * of the result when there were i - 1 coins.
			 */
			else if (i < x)
				dp[i] = !dp[i - 1];
			/*
			 * If the number of coins is between x and y, each player can pick up either 1
			 * or x coins
			 * per turn. Now, each player wants tow in, so they will look ar the state of
			 * the game
			 * when i -1 coins remain and also when i - x coins remain. If the player is
			 * winning in
			 * any of those states, he will try to get to that state, i.e, if the player is
			 * winning
			 * in i -1 state, he will remove 1 coin. If he's winning in the i - x state,
			 * then it
			 * doesn't matter what he does, he will still lose.
			 * So to get the value of dp[i], we will first AND the values of
			 * dp[i - 1] and do[i - x] and then NOT it.
			 */
			else if (i < y)
				dp[i] = !(dp[i - x] && dp[i - 1]);
			// The reasoning for this case is similar to the one explained above.
			else
				dp[i] = !(dp[i - x] && dp[i - y] && dp[i - 1]);
		}
		return dp[n] ? "Beerus" : "Whis";
	}

}

/*

Coin Tower

Whis and Beerus are playing a new game today. They form a tower of N coins and make a move in alternate turns. Beerus plays first. In one step, the player can remove either 1, X, or Y coins from the tower. The person to make the last move wins the game. Can you find out who wins the game?
 Input format :
The first and the only line of input contains three integer values separated by a single space. They denote the value of N, X and Y, respectively.
Output format :
Prints the name of the winner, either 'Whis' or 'Beerus' (Without the quotes).
Constraints :
1 <= N <= 10 ^ 6
2 <= X <= Y<= 50

Time Limit: 1 sec
Sample Input 1 :
4 2 3
Sample Output 1 :
Whis
Sample Input 2 :
10 2 4
Sample Output 2 :
Beerus
Explanation to Sample Input 1:
Initially, there are 4 coins,  In the first move, Beerus can remove either 1, 2, or 3 coins in all three cases, Whis can win by removing all the remaining coins. 
*/
