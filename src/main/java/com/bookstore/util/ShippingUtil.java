package com.bookstore.util;

import java.util.PriorityQueue;

public class ShippingUtil {
      private static final int[][] districtsMatrix = {
        //  1   3   4   5   6   7   8   10  11  12  TB  PN  GV  Bthanh  Btan  Tphu  TD
        {  0,  3,  3,  6,  0,  0,  0,   0,  0,  0,   0,   4,  0,     8,     0,    0,   0 }, // 1
        {  3,  0,  0,  0,  0,  0,  0,   4,  0,  0,   6,   3,  0,     0,     0,    0,  0 }, // 3
        {  3,  0,  0,  7,  0,  6,  0,   0,  0,  0,   0,   0,  0,     0,     0,    0,   16 }, // 4
        {  6,  0,  7,  0,  6,  0,  0,   3,  3,  0,   0,   0,  0,     0,     0,    0,   0 }, // 5
        {  0,  0,  0,  6,  0,  0,  4,   0,  3,  0,   0,   0,  0,     0,     0,    7,  0 }, // 6
        {  0,  0,  6,  0,  0,  0, 16,   0,  0,  0,   0,   0,  0,     0,     0,    0,   19 }, // 7
        {  0,  0,  12,  6,  4, 16,  0,   0,  0,  0,   0,   0,  0,     0,     7,    0,  0 }, // 8
        {  0,  4,  0,  3,  0,  0,  0,   0,  3,  0,   7,   0,  0,     0,     0,    0,   0 }, // 10
        {  0,  0,  0,  3,  3,  0,  0,   3,  0,  0,   7,   0,  0,     0,     0,    7,   0 }, // 11
        {  0,  0,  0,  0,  0,  0,  0,   0,  0,  0,   14,   0,  7,     12,     17,    13,   13 }, // 12
        {  0,  6,  0,  0,  0,  0,  0,   7,  7,  14,   0,   4,  10,     0,     0,    4,   0 }, // TB
        {  4,  3,  0,  0,  0,  0,  0,  0,   0,  0,    4,   0,  6,     6,     0,    0,   0 }, // PN
        {  0,  0,  0,  0,  0,  0,  0,   0,  0,  7,   10,   6,  0,     6,     0,    0,   0 }, // GV
        {  8,  0,  0,  0,  0,  0,  0,   0,  0,  12,   0,   6,  6,     0,     0,    0,   9 }, // Bthanh
        {  0,  0,  0,  0,  5,  0,  7,   0,  0,  17,   0,   0,  0,     0,     0,    8,   0 }, // Btan
        {  0,  0,  0,  0,  7,  0,  0,   0,  7,  13,   4,   0,  0,     0,     8,    0,  18 }, // Tphu
        {  0, 0,  16,  0,  0,  19, 0,   0,  0,  13,   0,   0,  0,     0,     0,   18,   0 }  // TD
    };

    private static final String[] districts = {
        "District 1", "District 3", "District 4", "District 5", "District 6", "District 7",
        "District 8", "District 10", "District 11", "District 12", "Tan Binh", "Phu Nhuan", "Go Vap", "Binh Thanh", "Binh Tan", "Tan Phu", "Thu Duc"
    };

    public static int findDistrictIndex(String district) {
        for (int i = 0; i < districts.length; i++) {
            if (districts[i].equalsIgnoreCase(district)) {
                return i;
            }
        }
        return -1;
    }
    public static int dijkstra(int source, int target) {
        int n = districtsMatrix.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[] { source, 0 });

        while (!pq.isEmpty()) {
        int[] current = pq.poll();
        int currentNode = current[0];
        int currentDist = current[1];

        if (visited[currentNode]) continue;
        visited[currentNode] = true;

        

        if (currentNode == target) return currentDist;

        for (int neighbor = 0; neighbor < n; neighbor++) {
            if (!visited[neighbor] && districtsMatrix[currentNode][neighbor] > 0) {
                int newDist = currentDist + districtsMatrix[currentNode][neighbor];
                if (newDist < dist[neighbor]) {
                    dist[neighbor] = newDist;
                    pq.add(new int[] { neighbor, newDist });
                    
                }
            }
     }
}

        return dist[target];
    }
    public static double calculateFee(int shippingDistance){
        double shippingFee = 0;
        if(shippingDistance <= 3){
            shippingFee = shippingDistance * 1.5 + 1;
        }
        else{
            shippingFee = shippingDistance * 1.3;
        }
        return shippingFee;
    }
}
