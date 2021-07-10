# MegaMaze Project Report

By: Jonathan Ma, Shreyas Gupta

The algorithm we chose for our maze generation was Prim's algorithm, which is designed to create minimum spanning trees. We implemented this algorithm by first creating a list of walls and a list of visited nodes. While the walls list had a positive size, we kept creating edges between the wall and the node, and added its neighbors to the walls list. In the end, we were left with a MST graph, which became our maze.

We also added random number generation so that each maze would be different. 
However, by substituting a seed to our random number generator, we can ensure that each maze created with the same seed and dimensions will be the same.

Our Maze Solver was created using the A star algorithm. We started with Djikstra's algorithm, where we used a priority queue to find the nearest node that has not been visited yet. Since this was an unweighted graph, this was a same process as a BFS. We then added a heuristic (the node at the bottom right) to our Comparator in order to transform this algorithm into the A star algorithm.

The most interesting part of this project was understanding how MST and shortest-path algorithms work, as well as heuristics. It was challenging to figure out how to properly implement randomness and seeds to our maze generation, and many of our early attempts looked a little strange. All in all, however, this project was very fun and interesting.