# JohnParkerWilsonCSS497Assigment5

Problem 1:
To tackle this problem, I had the function essentially tally up all the amount of open and closed parentheses, and if there were any extra parentheses the function would mark where those parentheses would be and remove them from the string. Then the function would do another once through in reverse to check for other permutations. The function is using a sort of Depth First Search method, so the time complexity would be around O(n) in a best case or average case, and the space complexity would be O(E) where E would be the edges of the graph, but in this case are the parentheses pairs.

Problem 2:
The solution to this was to simply recursively traverse the tree in an in-order fashion, keeping track of the minimum difference between nodes as it traverses. Since we're traversing a binary tree recursively, visiting each node, the time complexity would be O(n) and the space complexity would be O(h) where h is the height which on average is around log(n).

Problem 3:
In order to solve this, I made a function go through the graph using a Breadth-First-Search and keeping track of the nodes through a bit mask method, using a queue to keep track of visited nodes and their distances from one another, gradually visiting every adjacent node until we find a shortest path. By going through the graph using BFS, the time complexity would be O(V+E) where V and E are the vertices and edges respectively, and the space complexity would also be O(V+E) for the collections being used to track the nodes.

Problem 4:
To solve this, I used a slightly modified version of code to answer a similar problem where I had a function recursively traverse the tree in pre-order traversal while keeping track of the maximum sums between nodes each time. For a tree traversal, the time complexity would be O(n) and the space complexity would be O(h) with h being the height of the tree.

Problem 5:
The solution for this was to essentially go through each digit for each number of 1 to 9 up to the target number that would be passed to the function. By doing this, we can get the numbers in lexigraphical order where numbers with 1s or 0s in them would be before the 2s and so and so forth. My first thought was to sort of brute force it and sort the array after the numbers were made, but by doing this we can get a time complexity of O(n) and a space complexity of O(1).
