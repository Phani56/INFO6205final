import java.util.*;
class LargestTree{
    static void addEdge(LinkedList<Integer> adj[], int u, int v)
    {
        //TO-DO:
        adj[u].add(v);
        adj[v].add(u);
    }

    static int DFS(int u, LinkedList<Integer> adj[], Vector<Boolean> visited)
    {
        visited.add(u, true);
        int size = 1;

        // Iterate through all the nodes and perform DFS if the node is not yet visited
        //TO-DO
        for (int i = 0; i < adj[u].size(); i++) {
            if (visited.get(adj[u].get(i)) == false) {
                size += DFS(adj[u].get(i), adj, visited);
            }
        }
        return size;
    }

    public int largestTree(LinkedList<Integer> adj[], int V)
    {
        //TO-DO:
        int result = 0;

        Vector<Boolean> visited = new Vector<>();
        for(int i = 0; i < V; i++) visited.add(false);
        for (int i = 0; i < V; i++)
        {
            if (visited.get(i) == false) result = Math.max(result, DFS(i, adj, visited));
        }
        return result;

    }
}