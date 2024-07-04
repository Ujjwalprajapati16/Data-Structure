package Graph;

import java.util.ArrayList;

public class CycleDetection {
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
    }

    public static void createCyclicGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));
    }

    public static boolean isCycleDetected(ArrayList<Edge> graph[], boolean vis[], int curr, boolean rec[]){
        vis[curr] = true;
        rec[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(rec[e.dest]){//cycle
                return true;
            } else if(!vis[e.dest]){
                if(isCycleDetected(graph, vis, e.dest, rec)){
                    return true;
                }
            }
        }

        rec[curr] = false;
        return false;
    }

    public static boolean isCyclicUndirected(ArrayList<Edge> graph[], boolean vis[], int curr, int par){
        // Mark the current node as visited and part of recursion stack.
        vis[curr] = true;

        /* Recur for all adjacent vertices of current vertex. If any adjacent
           vertex is not visited, then it is a separate component and we find if there is cycle in this component. */
        
         for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest] && e.dest != par){
                return true;
            } else if(!vis[e.dest]){
                if(isCyclicUndirected(graph, vis, e.dest, curr)){
                    return true;
                }
            }
        } 
        return false; 
    }
    public static void main(String[] args) {
        // int V = 4;

        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createGraph(graph);

        // boolean vis[] = new boolean[V];
        // boolean rec[] = new boolean[V];

        // for(int i=0; i<V; i++){
        //     if(!vis[i]){
        //         boolean isCycle = isCycleDetected(graph, vis, 0, rec);
        //         if(isCycle){
        //             System.out.println(isCycle);
        //             break;
        //         }
        //     }
        // }

        int V = 6;
        
        ArrayList<Edge> graph[] = new ArrayList[V];
        createCyclicGraph(graph);
        System.out.println(isCyclicUndirected(graph, new boolean[V], 0, -1));
    }
}
