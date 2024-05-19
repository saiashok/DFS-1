// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 * problem#733
 * 
 * Get the color at sr & sc ; this is the color we want to change to given color.
 * 
 * We have to visit in all 4 directions..
 * and at each new row and column if valid check if the cell has old color if so, change the color to given color and add it queue and continue until the queue is empty
 * 
 */

import java.util.*;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] directions = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        int oldColor = image[sr][sc];
        if (oldColor == color)
            return image;

        int m = image.length;
        int n = image[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { sr, sc });
        image[sr][sc] = color;

        while (!queue.isEmpty()) {
            // dont need a size variable we are not doing levels
            int[] curr = queue.poll();

            for (int[] dir : directions) {
                int nr = dir[0] + curr[0];
                int nc = dir[1] + curr[1];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == oldColor) {
                    image[nr][nc] = color;
                    queue.add(new int[] { nr, nc });
                }
            }

        }

        return image;
    }

}