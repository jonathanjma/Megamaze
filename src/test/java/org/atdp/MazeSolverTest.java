package org.atdp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MazeSolverTest {

    /** 
     * Uses the basic TestMaze layout for a simple solve test.
     */
     @Test
     public void testBasicSolve() {
         Maze m = new TestMaze(3, 3);
         MazeSolver ms = new MazeSolver();
         List<Integer> result = ms.solve(m);
         List<Integer> ref = new ArrayList<Integer>();
         ref.add(0);
         ref.add(1);
         ref.add(4);
         ref.add(5);
         ref.add(8);
         assertEquals(ref, result);
     }

    // Create additional tests below.
}
