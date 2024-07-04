import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int M = Integer.parseInt(stoi.nextToken());

        if(N == 1 && M == 1) {
            System.out.println(2);
            System.exit(0);
        }

        int[][] table = new int[N][N];
        for(int i = 0; i < N; i++) {
            stoi = new StringTokenizer(read.readLine());

            for(int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(stoi.nextToken());
            }
        }

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            int num = table[i][0], cont = 1;
            for(int j = 1; j < N; j++) {
                if(table[i][j] == num) {
                    cont++;
                } else {
                    num = table[i][j];
                    cont = 1;
                }

                if(cont >= M) {
                    cnt++;
                    break;
                }
            }
        }

        for(int j = 0; j < N; j++) {
            int num = table[0][j], cont = 1;
            for(int i = 1; i < N; i++) {
                if(table[i][j] == num) {
                    cont++;
                } else {
                    num = table[i][j];
                    cont = 1;
                }

                if(cont >= M) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}