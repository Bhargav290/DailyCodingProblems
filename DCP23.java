import java.util.ArrayList;

    public class DCP23{
        /**
         * Special element to hold the co-ordinate and distance of the index
         */
        static class ArrayElement{
            public int x;
            public int y;
            public int distance;
            public ArrayElement(int x,int y, int distance){
                this.x = x;
                this.y = y;
                this.distance = distance;
            }
        }

        public static int findMinStepsRequired(int[][] matrix,int[] start,int[] end) {
            // If starting and ending index are same
            if (start[0] == end[0] && start[1] == end[1]) return 0;

            ArrayList<ArrayElement> queue = new ArrayList<>();

            int startX = start[0];
            int startY = start[1];

            // adding all possible indexes to queue
            queue.add(new ArrayElement(startX + 1, startY,1));
            queue.add(new ArrayElement(startX - 1, startY, 1));
            queue.add(new ArrayElement(startX, startY - 1, 1));
            queue.add(new ArrayElement(startX, startY + 1, 1));

            // marking visited node as wall node, to prevent going back
            matrix[startX][startY] = 1;

            int endX = end[0];
            int endY = end[1];

            while (queue.size() != 0) {
                // Deque operation
                ArrayElement coordAndDistance = queue.remove(0);

                int x = coordAndDistance.x;
                int y = coordAndDistance.y;
                int distance = coordAndDistance.distance;

                if (endX == x && endY == y) return distance;

                // check out of bounds
                if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) continue;

                // check for wall
                if (matrix[x][y] == 1) continue;

                // mark wall as we traversed that index
                matrix[x][y] = 1;

                queue.add(new ArrayElement(x - 1, y, distance + 1));
                queue.add(new ArrayElement(x + 1, y, distance + 1));
                queue.add(new ArrayElement(x, y - 1, distance + 1));
                queue.add(new ArrayElement(x, y + 1, distance + 1));
            }

            return -1;
        }
        public static void main(String[] args){
            // 0 represents walkable path, 1 represents a wall
            int[][] matrix = {{0,0,0,0},{1,1,0,1},{0,0,0,0},{0,0,0,0}};
            int[] start = {3,0};
            int[] end = {0,0};
            int ans = findMinStepsRequired(matrix,start,end);
            System.out.println(ans);
        }
    }

