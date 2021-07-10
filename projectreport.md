# MegaMaze Project Report

By: Jonathan Ma, Shreyas Gupta

The algorithm we chose for our maze generation was Prim's algorithm, which is designed to create minimum spanning trees. 
We implemented this algorithm by first creating a list of walls and a list of visited nodes. 
While the walls list was not empty, we kept creating edges between a random wall and a random visited neighbor. 
We then added the neighbors of the newly connected cell to the walls list. In the end, we were left with a MST graph, which became our maze.  

The addition of a random number generation meant that each generated maze was different.
However, by passing in a seed to our random number generator, we can ensure that each maze created with the same seed and dimensions will be the same.

Our maze solver is based on the A* algorithm. We started with Djikstra's algorithm, where we used a priority queue to find the nearest node that has not been visited yet. 
Since this was an unweighted graph, this would be the same process as a BFS. However, we implemented Djikstra's because the heuristic of the A* algorithm would essentially give the graph weights.
The heuristic that we ended up choosing was the distance between the current cell and the ending cell of the maze.

The most interesting part of this project was understanding how MST and shortest-path algorithms work, as well as heuristics. 
It was challenging to figure out how to properly implement randomness and seeds to our maze generation, and many of our early attempts looked a little strange compared to conventional mazes we saw in the past.
However, we later found out that the abundance of short dead ends, 4 way intersections, and a direct solution were in fact characteristics of Prim's algorithm, not our mistakes. (Source: https://medium.com/analytics-vidhya/maze-generations-algorithms-and-visualizations-9f5e88a3ae37)
One final thing we noticed was that adding the heuristic in our A* algorithm did not actually result in a faster runtime. 
We thought this was strange as the Euclidean and Manhattan distance from each cell to the end is both admissible and consistent.
All in all, however, this project was very fun and interesting and we definitely learned a lot!