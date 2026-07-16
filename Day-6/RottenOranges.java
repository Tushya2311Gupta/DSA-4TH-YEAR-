import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        // Step 1: Initialize the queue with all rotten oranges and count fresh ones
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        
        // If there are no fresh oranges, it takes 0 minutes
        if (freshCount == 0) return 0;
        
        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // Down, Up, Right, Left
        
        // Step 2: Perform BFS level by level
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            
            // Process all oranges at the current minute
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                
                for (int[] dir : directions) {
                    int newRow = current[0] + dir[0];
                    int newCol = current[1] + dir[1];
                    
                    // If the adjacent cell is within bounds and is a fresh orange
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; // Make it rotten
                        freshCount--;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
            minutes++;
        }
        
        // Step 3: If there are still fresh oranges left, return -1
        return freshCount == 0 ? minutes : -1;
    }
}