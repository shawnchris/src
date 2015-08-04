package com.google.intern;

public class DungeonGame {
	
	public int calculateMinimumHP(int[][] dungeon) {
        int M = dungeon.length;
        int N = dungeon[0].length;
        
        // Stands for the min health before the Knight enters a room.
        int[][] health = new int[M][N];
        if (dungeon[M-1][N-1] < 0)
            health[M-1][N-1] = 1-dungeon[M-1][N-1];
        else
            health[M-1][N-1] = 1;
        
        for (int n = N - 2; n >= 0; n--) {
            int h = health[M-1][n+1] - dungeon[M-1][n];
            health[M-1][n] = (h > 0 ? h : 1);
        }
        for (int m = M - 2; m >= 0; m--) {
            int h = health[m+1][N-1] - dungeon[m][N-1];
            health[m][N-1] = (h > 0 ? h : 1);
        }
        
        for (int m = M - 2; m >= 0; m--) {
            for (int n = N - 2; n >= 0; n--) {
                int h = Math.min(health[m+1][n], health[m][n+1]) - dungeon[m][n];
                health[m][n] = (h > 0 ? h : 1);
            }
        }
        
        printDebug(dungeon, health);
        
        return health[0][0];
    }
	
	void printDebug(int[][] dp, int[][] hp) {
		int N = dp.length;
        int M = dp[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
            	System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
            	System.out.print(hp[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println();
	}
	
	public static void main(String[] args) {
		DungeonGame dg = new DungeonGame();
		int[][] input1 = {{1,-2, 3},
						  {2,-2,-2}};
		
		System.out.println(dg.calculateMinimumHP(input1));
	}

}
