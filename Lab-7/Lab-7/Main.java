class Main {
  public static void main(String[] args) {
    // 1. Define the vertices (buildings) based on the campus map
    String[] vertices = {
        "Liberal Arts", // vertex 0
        "Student Services", // vertex 1
        "Health Careers & Sciences", // vertex 2
        "Health Technologies Center", // vertex 3
        "Recreation Center", // vertex 4
        "Technology Learning Center", // vertex 5
        "Business & Technology", // vertex 6
        "Theatre" // vertex 7
    };

    // 2. Define Edges
    int[][] edges = {
        { 0, 1 },
        { 1, 6 },
        { 6, 7 },
        { 1, 5 },
        { 1, 2 },
        { 2, 3 },
        { 2, 4 },
        { 0, 7 }
    };

    // 3. Create the graph (name "graph") using the vertices and edges
    UnweightedGraph<String> graph = new UnweightedGraph<>(vertices, edges);

    // 4. Perform a depth-first search (name "dfs")(DFS) starting from the "Business
    // & Technology" building
    UnweightedGraph<String>.SearchTree dfs = graph.dfs(graph.getIndex("Business & Technology"));

    // 5. Retrieve and print the search order of the DFS traversal
    java.util.List<Integer> searchOrder = dfs.getSearchOrder();
    System.out.println(dfs.getNumberOfVerticesFound() + " vertices are searched in this DFS order:");
    for (int i = 0; i < searchOrder.size(); i++) {
      System.out.print(graph.getVertex(searchOrder.get(i)) + " ");
    }
    System.out.println();

    // 6. Print the parent-child relationships for each vertex during the DFS
    // traversal
    System.out.println("Parent-child relationships in the DFS tree:");
    for (int i = 0; i < searchOrder.size(); i++) {
      int v = searchOrder.get(i); // vertex visited
      int parent = dfs.getParent(v); // parent of that vertex

      if (parent != -1) {
        System.out.println("parent of " + graph.getVertex(v) + " is " + graph.getVertex(parent));
      }
    }

    // 7. Call the printPath method (assuming this method exists in the
    // UnweightedGraph class)
    // System.out.println("Path from Business & Technology to Health Technologies
    // Center:");
    dfs.printPath(graph.getIndex("Health Technologies Center"));
    System.out.println();

    // System.out.println("Path from Business & Technology to Student Services:");
    dfs.printPath(graph.getIndex("Student Services"));
    System.out.println();

    // System.out.println("Path from Business & Technology to Recreation Center:");
    dfs.printPath(graph.getIndex("Recreation Center"));
    System.out.println();

    // 8. Call printTree() to print the entire DFS tree (assuming this method exists
    // in the UnweightedGraph class)
    System.out.println("DFS Tree:");
    dfs.printTree();
  }
}