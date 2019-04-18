package com.jtarun.practice.domion_data_lab;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Solution {
    private static void printPaths(Map<Integer, Set<Integer>> graph, int source, List<Integer> path) {
        path.add(source);
        Set<Integer> children = graph.get(source);
        if (children.isEmpty()) {
            // print the path;
            for (int i = 0; i < path.size(); i++) {
                if (i > 0) System.out.print("->");
                System.out.print(path.get(i));
            }
            System.out.println();
        } else {
            for (Integer child : children) {
                printPaths(graph, child, path);
            }
        }
        path.remove(path.size() - 1);
    }

    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        // Read the input file.
        InputStream inputStream = new FileInputStream(new File("C://TestFile"));
        //InputStream inputStream = System.in;
        Scanner scan = new Scanner(inputStream);
        try {
            Map<Integer, Set<Integer>> graph = new HashMap<>();
            int totalNodes = Integer.parseInt(scan.nextLine().trim());
            boolean[] parentPresent = new boolean[totalNodes];
            for (int node = 0; node < totalNodes; node++) {
                graph.put(node, new HashSet<>());
            }

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] nodes = line.split(",");
                int src = Integer.parseInt(nodes[0].trim());
                int dest = Integer.parseInt(nodes[1].trim());
                graph.get(src).add(dest);
                parentPresent[dest] = true;
            }

            for (int node = 0; node < totalNodes; node++) {
                if (!parentPresent[node]) {
                    printPaths(graph, node, new ArrayList<>());
                }
            }
        } finally {
            scan.close();
        }
    }

}


