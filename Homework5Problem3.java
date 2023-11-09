import java.util.*;

class Solution {
    public static void main(String[] args) {
        int [][] graph = {{1,2,3}, {0}, {0}, {0}};

        System.out.println("Shortest path length is " + shortestPath(graph));

    }

    public static int shortestPath(int [][] graph) {
        if(graph.length > 12 | graph.length <= 0) return -1;
        //Node State, using bitmask
        //[0] = node, [1] = mask, [2] = length
        int len = graph.length;
        //Using node state/bitmask
        //Queue for bfs
        Queue<int[]> queue = new LinkedList<int[]> ();
        //visted = set of nodes visited during bfs
        Set<Integer> visited = new HashSet<Integer> ();
        //Used to indicate if all nodes are visited
        int allVisited = (1 << len) - 1;

        //Initialize Queue
        for (int i = 0; i < len; i++) {
            int [] tempNode = {i, 1 << i, 0};
            queue.add(tempNode);
            visited.add((1 << i) * 16 + i);
        }

        //Actually do bfs
        while (!queue.isEmpty()) {
            //Get front of queue
            int [] curNode = queue.poll();

            //If all nodes are visisted, return distance
            if (curNode[1] == allVisited) {
                return curNode[2] - 1;
            }
            else { //Otherwise go through graph
                for (int adj : graph[curNode[0]]) {
                    int newMask = curNode[1];

                    newMask = curNode[1] | (1 << adj);
                    int hashKey = newMask * 16 + adj;

                    //If not visited
                    if (!visited.contains(hashKey)) {
                        //Add nodes to queue and visited
                        visited.add(hashKey);
                        int [] tempNode = {adj, newMask, curNode[2] + 1};
                        queue.offer(tempNode);
                    }

                }
            }
        }

        //failed to get anything
        return -1;
    }
}
