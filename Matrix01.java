// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

/*
 * Problem: 542
 * 
 * Level order traversal or BFS.
 * 
 * We start with all zeros in a queue.
 * And make all 1 to -1; as distance cant be -1 and we can mark our distances
 * 
 * once we have all zeros in a queue; the neighbours of corresponding zeros would be at a distance of level+1 and so on.
 */

import java.util.*;

public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        int[][] directions = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[] { i, j });
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        int level = 0;
        while (!queue.isEmpty()) {
            int sizeOfELementsInLevel = queue.size();
            for (int k = 0; k < sizeOfELementsInLevel; k++) {
                int[] curr = queue.poll();
                for (int[] dir : directions) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == -1) {
                        mat[nr][nc] = level + 1;
                        queue.add(new int[] { nr, nc });
                    }
                }
            }
            level++;
        }

        return mat;
    }

}