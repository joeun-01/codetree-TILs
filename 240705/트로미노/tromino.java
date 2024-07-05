import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int M = Integer.parseInt(stoi.nextToken());

        int[][] table = new int[N][M];
        for(int i = 0; i < N; i++) {
            stoi = new StringTokenizer(read.readLine());
            for(int j = 0; j < M; j++) {
                table[i][j] = Integer.parseInt(stoi.nextToken());
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(i + 1 < N && j + 1 < M) {
                    int sum = table[i][j] + table[i + 1][j] + table[i + 1][j + 1];
                    max = Math.max(max, sum);

                    sum = table[i][j] + table[i][j + 1] + table[i + 1][j + 1];
                    max = Math.max(max, sum);
                }

                if(j + 2 < M) {
                    int sum = table[i][j] + table[i][j + 1] + table[i][j + 2];
                    max = Math.max(max, sum);
                }

                if(i + 2 < N) {
                    int sum = table[i][j] + table[i + 1][j] + table[i + 2][j];
                    max = Math.max(max, sum);
                }

                if(i + 2 < N && j + 2 < M) {
                    int sum = table[i][j] + table[i + 1][j + 1] + table[i + 2][j + 2];
                    max = Math.max(max, sum);
                }


                if(i - 2 >= 0 && j + 2 < M) {
                    int sum = table[i][j] + table[i - 1][j + 1] + table[i - 2][j + 2];
                    max = Math.max(max, sum);
                }
            }
        }

        System.out.println(max);
    }
}