import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static int[] y = {-1, 1, 0, 0};
    public static int[] x = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int n = Integer.parseInt(stoi.nextToken());
        int m = Integer.parseInt(stoi.nextToken());

        int[][] table = new int[n][m];
        for(int i = 0; i < n; i++) {
            stoi = new StringTokenizer(read.readLine());
            for(int j = 0; j < m; j++) {
                table[i][j] = Integer.parseInt(stoi.nextToken());
            }
        }

        Queue<Node> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[n][m];

        queue.add(new Node(0, 0));
        isVisited[0][0] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nextR = node.r + y[i];
                int nextC = node.c + x[i];

                if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= m) continue;

                if(!isVisited[nextR][nextC] && table[nextR][nextC] == 1) {
                    queue.add(new Node(nextR, nextC));
                    isVisited[nextR][nextC] = true;

                    if(nextR == n - 1 && nextC == m - 1) {
                        System.out.println(1);
                        System.exit(0);
                    }
                }
            }
        }

        System.out.println(0);
    }
}