package org.atdp;

import java.util.*;

public class MazeSolver {

    // You do not need to use the following variables, but you may find them helpful.
    final int INFINITY = Integer.MAX_VALUE - 10000;
    private Map<Integer, Integer> distTo;
    private Map<Integer, Vertex> edgeTo;
    private PriorityQueue<Vertex> pq;
    private Maze m;

    /**
     * Finds the shortest path from the start (top left) to the end (bottom right) of a maze M.
     * @return A list of integers starting from 0 and ending in (m.length * m.width) - 1, describing the
     * path from the start to finish. For example, in the maze:
     * +---+---+---+
     * | 0   1 | 2 |
     * +---+   +   +
     * | 3 | 4   5 |
     * +   +---+   +
     * | 6   7   8 |
     * +---+---+---+
     * The solution should be a list of {0, 1, 4, 5, 8}.
     */
    public List<Integer> solve(Maze m) {
        long start = System.currentTimeMillis(); this.m = m;
        // Again, the following is optional. You may remove it if you do not need it for your implementation.
        distTo = new HashMap<>();
        edgeTo = new HashMap<>();
        pq = new PriorityQueue<>(m.getHeight() * m.getWidth(), new DistComparator());
        int nodesVisited = 0;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < m.vertices.size(); i++) {
            distTo.put(i, i == 0 ? 0 : INFINITY);
            pq.add(m.vertices.get(i));
        }

        while (!pq.isEmpty()) {
            Vertex v = pq.remove();
            for (Vertex edge : v.edges) {
                if (distTo.get(edge.id) > nodesVisited + 1) {
                    distTo.put(edge.id, nodesVisited + 1);
                    edgeTo.put(edge.id, v);
                    pq.remove(edge);
                    pq.add(edge);
                }
            }

//            System.out.println(pq);
            nodesVisited++;

            if (v.id == m.getWidth() * m.getHeight() - 1) {
                break;
            }
        }

//        System.out.println("\n"+distTo);
//        System.out.println(edgeTo);

        Vertex v = m.vertices.get(m.getWidth() * m.getHeight() - 1);
        result.add(v.id);
        while (v.id != 0) {
            v = edgeTo.get(v.id);
            result.add(v.id);
        }

        Collections.reverse(result);
//        System.out.println(result);
//
//        System.out.println(nodesVisited + " "+ (m.getHeight()*m.getWidth()));
//        System.out.println("\nTime to solve: " + (System.currentTimeMillis() - start) + " ms");

        return result;
    }

    public int h(int v) {
        int x = v % m.getWidth() + 1;
        int y = v / m.getHeight() + 1;
        return (int) Math.sqrt(Math.pow(m.getWidth() - x, 2) + Math.pow(m.getHeight() - y, 2)); // euclidean
//        return ((m.getWidth() - x) + (m.getHeight() - y)); // manhattan
    }

    // Feel free to create additional methods below, if needed.

    /**
     * This is passed into PriorityQueue as a parameter to properly compare the distTo values for two vertices.
     * You can delete this if you decide not to use distTo.
     * IMPORTANT: If distTo is changed, the PriorityQueue will NOT automatically update!
     * To update a PriorityQueue, remove a vertex and then immediately add it back.
     * If you would like to learn more: 
     * https://stackoverflow.com/questions/683041/how-do-i-use-a-priorityqueue
     */
    private class DistComparator implements Comparator<Vertex> {
        @Override
        public int compare(Vertex v1, Vertex v2) {
            int d1 = distTo.get(v1.id) + h(v1.id);
            int d2 = distTo.get(v2.id) + h(v2.id);

            if (d1 < d2) return -1;
            else if (d1 > d2) return 1;
            return 0;
        }
    }
}