package org.atdp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * A basic undirected, unweighted graph implementation.
 */
public class Graph {
    /**
     * List of vertices in this graph.
     */
    ArrayList<Vertex> vertices;

    /**
     * Initializes a new Graph with a give number of vertices.
     * For each vertex, set vertex labels consecutively.
     * 
     * For example, a new Graph(3) would have 3 vertices
     * with labels 0, 1, and 2.
     */
    public Graph(int numVertices) {
        vertices = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            vertices.add(new Vertex(i));
        }
    }

    /**
     * Creates an edge between the vertex with label U and vertex with label V.
     * Remember to add the edge to both vertices since the graph is undirected!
     * 
     * In the case that u == v, do nothing (simple graphs only).
     */
    public void addEdge(int u, int v) {
        if (u != v) {
            vertices.get(u).edges.add(vertices.get(v));
            vertices.get(v).edges.add(vertices.get(u));
        }
    }

    /**
     * Returns the Vertex with label ID.
     * Returns null if the ID does not exist in the graph.
     */
    public Vertex getVertex(int id) {
        if (id >= 0 && id < vertices.size()) {
            return vertices.get(id);
        }
        return null;
    }
}


/**
 * A Vertex class: every vertex has a set of edges.
 * Don't worry too much about what a HashSet is for now;
 * what you need to know is that you can call `edges.add(other_vertex)`
 * to add to the set, and that there are no duplicates.
 */
class Vertex {
    int id;
    Set<Vertex> edges;
    
    Vertex(int id) {
        edges = new HashSet<>();
        this.id = id;
    }

    public String toString() {
        String s = id + ": [";
        if (edges.isEmpty()) return s + "]";
        for (Vertex v : edges) {
            s += v.id + ", ";
        }
        return s.substring(0, s.length() - 2) + "]";
    }
}