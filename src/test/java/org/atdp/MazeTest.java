package org.atdp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MazeTest {

    static Maze m = new Maze(5, 5);

    @Before
    public void init() {
//        m = new Maze(5, 5);
    }

    // Write additional tests below. Make sure to check that generated mazes are valid
    // (all tiles connected to at least one of its neighbors, and none of its non-neighbors).

    // make sure all tiles are connected
    @Test
    public void testConnectivity() {
        for (Vertex v : m.vertices) {
            assertFalse(v.id + " does not have any edges", v.edges.isEmpty());
        }
    }

    // make sure tiles have < 3 neighbors
    @Test
    public void testEdgeCounts() {
        for (Vertex v : m.vertices) {
            assertTrue(v.id + " has too many edges (" + v.edges.size() + ")",
                    v.edges.size() <= 3);
        }
    }

    // make sure connected tiles both have an edge to each other
    @Test
    public void testEdgesShared() {
        for (Vertex v : m.vertices) {
            for (Vertex edgeTo : v.edges) {
                assertTrue(edgeTo.id + "does not sare an edge with " + v.id,
                        edgeTo.edges.contains(v));
            }
        }
    }

    // make sure all edges connect to neighboring tiles
    @Test
    public void testEdgesValid() {
        for (Vertex v : m.vertices) {
            for (Vertex edgeTo : v.edges) {
                assertTrue(edgeTo.id + " not valid neighbor for " + v.id,
                        m.getNeighbors(v).contains(edgeTo));
            }
        }
    }
}
