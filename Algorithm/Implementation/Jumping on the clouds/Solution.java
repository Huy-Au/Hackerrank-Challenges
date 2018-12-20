import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        /*
        Dynamic programming with O(1) space and O(n) time complexity
        */
        int backtwostep = 0;
        int backonestep = 1;
        int cur = 0;
        if (c.length == 2){
            return 1;
        }

        for (int i = 2; i < c.length; i++) {
            if (c[i] == 1) {
                cur = Integer.MAX_VALUE;
                backtwostep = backonestep;
                backonestep = cur;
            } else {
                cur = Math.min(backtwostep, backonestep) + 1;
                backtwostep = backonestep;
                backonestep = cur;
            }
        }
        return cur;

        /*
            Dynamic Programming, O(n) space and O(n) time
        */
        /*
        int[] dp = new int[c.length];
        // Assuming first two elements are always reachable
        dp[0] = 0;
        dp[1] = 1; 
        for(int i = 2; i < c.length; i++){
            if (c[i] == 1){
                dp[i] = Integer.MAX_VALUE;    
            } else {
                dp[i] = Math.min(dp[i-2], dp[i-1]) + 1;
            }
        }
        return dp[c.length - 1];
        */

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
