import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());

        int[] DP = new int[N + 1];
        DP[0] = 0;
        DP[1] = 1;
        for(int i = 2; i <= N; i++) {
            DP[i] = DP[i - 1] + DP[i - 2];
        }

        System.out.println(DP[N]);
    }
}