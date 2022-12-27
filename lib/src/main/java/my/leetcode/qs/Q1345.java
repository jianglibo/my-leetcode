package my.leetcode.qs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q1345 {
    public int minJumps(int[] arr) {
        int[] dp = new int[arr.length];

        Map<Integer, Integer> values = new HashMap<>();

        for (int i = 1; i < arr.length; i++) {
            Integer P = values.putIfAbsent(arr[i], i); // if P == null no previous value.
            dp[i] = dp[i - 1] + 1; // If could'nt jump.
            for (int j = 0; j < i; j++) {
                if (arr[j] == arr[i]) { // could jump
                    // System.out.println("j == i is: " + j + " = " + i);
                    if (dp[i] > dp[j] + 1) { // if jumping could reduce the steps.
                        dp[i] = dp[j] + 1;
                        // ensure the gaps between siblings don't exceed 1.
                        for (int k = i; k > j && k - 1 >= 0; k--) {
                            if (dp[k - 1] - dp[k] > 1) {
                                dp[k - 1] = dp[k] + 1;
                            } else {
                                // System.out.println("here.");
                                break;
                            }
                        }
                    }
                    // System.out.println("here.");
                    break;
                }
            }
        }
        return dp[arr.length - 1];
    }

    public int minJumps2(int[] arr) {
        int[] dp = new int[arr.length];

        Map<Integer, List<Integer>> values = new HashMap<>();

        for (int i = 1; i < arr.length; i++) {
            List<Integer> duplicates = values.computeIfAbsent(arr[i], k -> new ArrayList<>());
            dp[i] = dp[i - 1] + 1; // If could'nt jump.

            if (!duplicates.isEmpty()) { // could jump
                int minDp = dp[duplicates.get(0)];
                int minDpIdx = duplicates.get(0);
                for (int j = 1; j < duplicates.size(); j++) {
                    if (minDp > dp[duplicates.get(j)]) {
                        minDp = dp[duplicates.get(j)];
                        minDpIdx = j;
                    }
                }

                if (dp[i] > minDp + 1) { // if jumping could reduce the steps.
                    // System.out.println("j == i is: " + P + " = " + i + " and dp[j] = " + dp[P] +
                    // ", dp[i] = " + dp[i]);
                    dp[i] = minDp + 1;
                    // ensure the gaps between siblings don't exceed 1.
                    for (int k = i; k > minDpIdx && k - 1 >= 0; k--) {
                        if (dp[k - 1] - dp[k] > 1) {
                            dp[k - 1] = dp[k] + 1;
                        } else {
                            // System.out.println("here.");
                            break;
                        }
                    }
                }
                // System.out.println("here.");
            }
            duplicates.add(i); // if P == null no previous value.
        }
        for (int i = 0; i < arr.length - 1; i++) {
            assert Math.abs(dp[i] - dp[i + 1]) < 2 : "should no more than 2.";
        }
        return dp[arr.length - 1];
    }

    public int minJumps1(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return 0;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], v -> new LinkedList<>()).add(i);
        }

        List<Integer> curs = new LinkedList<>(); // store current layer
        curs.add(0);
        Set<Integer> visited = new HashSet<>();
        int step = 0;

        // when current layer exists
        while (!curs.isEmpty()) {
            List<Integer> nex = new LinkedList<>();

            // iterate the layer
            for (int node : curs) {
                // check if reached end
                if (node == n - 1) {
                    return step;
                }

                // check same value
                for (int child : graph.get(arr[node])) {
                    if (!visited.contains(child)) {
                        visited.add(child);
                        nex.add(child);
                    }
                }

                // clear the list to prevent redundant search
                graph.get(arr[node]).clear();

                // check neighbors
                if (node + 1 < n && !visited.contains(node + 1)) {
                    visited.add(node + 1);
                    nex.add(node + 1);
                }
                if (node - 1 >= 0 && !visited.contains(node - 1)) {
                    visited.add(node - 1);
                    nex.add(node - 1);
                }
            }

            curs = nex;
            step++;
        }

        return -1;
    }

    public static int minJumps3(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return 0;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], v -> new LinkedList<>()).add(i);
        }

        HashSet<Integer> curs = new HashSet<>(); // store layers from start
        curs.add(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        visited.add(n - 1);
        int step = 0;

        HashSet<Integer> other = new HashSet<>(); // store layers from end
        other.add(n - 1);

        // when current layer exists
        while (!curs.isEmpty()) {
            // search from the side with fewer nodes
            if (curs.size() > other.size()) {
                HashSet<Integer> tmp = curs;
                curs = other;
                other = tmp;
            }

            HashSet<Integer> nex = new HashSet<>();

            // iterate the layer
            for (int node : curs) {

                // check same value
                for (int child : graph.get(arr[node])) {
                    if (other.contains(child)) {
                        return step + 1;
                    }
                    if (!visited.contains(child)) {
                        visited.add(child);
                        nex.add(child);
                    }
                }

                // clear the list to prevent redundant search
                graph.get(arr[node]).clear();

                // check neighbors
                if (other.contains(node + 1) || other.contains(node - 1)) {
                    return step + 1;
                }

                if (node + 1 < n && !visited.contains(node + 1)) {
                    visited.add(node + 1);
                    nex.add(node + 1);
                }
                if (node - 1 >= 0 && !visited.contains(node - 1)) {
                    visited.add(node - 1);
                    nex.add(node - 1);
                }
            }

            curs = nex;
            step++;
        }

        return -1;
    }
}
