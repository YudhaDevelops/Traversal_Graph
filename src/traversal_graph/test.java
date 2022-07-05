package traversal_graph;

import java.util.Arrays;

public class test {

    int[][] primAlgorithmMST(int[][] G, int V) {
        int distance[] = new int[V];
        boolean vis[] = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        int source = 0;
        distance[source] = 0;
        parent[source] = -1;
        for (int i = 0; i < V; i++) {
            vis[source] = true;
            for (int j = 0; j < V; j++) {
                if (G[source][j] != 0 && !vis[j]) {
                    if (distance[j] > G[source][j]) {
                        distance[j] = G[source][j];
                        parent[j] = source;
                    }
                }
            }
            source = minNode(V, vis, distance);

        }
        int ans[][] = new int[V][V];
        for (int i = 0; i < V; i++) {
            if (i != source) {
                ans[parent[i]][i] = G[parent[i]][i];
                ans[i][parent[i]] = G[parent[i]][i];
            }
        }
        return ans;
    }

    void print(int[][] G, int V) {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(G[i][j] + " ");
            }
            System.out.println();
        }
    }

    int minNode(int V, boolean vis[], int dis[]) {
        int min = Integer.MAX_VALUE;
        int node = 0;
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (min > dis[i]) {
                    min = dis[i];
                    node = i;
                }
            }
        }
        return node;
    }
    public static class WeightedGraphAM {
	private int V;
	private int[][] G;
	public WeightedGraphAM(int noOfvertices) {
		this.V=noOfvertices;
		this.G=new int[V][V];
	}
	int[][] getGraph() {
		return G;
	}
	int getTotalNode() {
		return V;
	}
	//add edge
	void addEdge(int source,int destination,boolean directed,int weight) {
		G[source][destination]=weight;
		if(!directed) {//if undirected graph then add destination to source
			G[destination][source]=weight;
		}
	}
	//remove edge
	void removeEdge(int source,int destination,boolean directed) {
		G[source][destination]=0;
		if(!directed) {//if directed then don't remove
			G[destination][source]=0;
		}
	}
	//print Graph
	 public String toString() {
		    StringBuilder s = new StringBuilder();
		    for (int i = 0; i < V; i++) {
		      for (int j : G[i]) {
		        s.append(j + " ");
		      }
		      s.append("\n");
		    }
		  return s.toString();
	}

}
    public static void main(String[] args) {
        WeightedGraphAM weightedGraphAM = new WeightedGraphAM(5);
        weightedGraphAM.addEdge(0, 1, false, 4);
        weightedGraphAM.addEdge(0, 2, false, 1);
        weightedGraphAM.addEdge(1, 2, false, 2);
        weightedGraphAM.addEdge(1, 4, false, 4);
        weightedGraphAM.addEdge(2, 3, false, 2);
        weightedGraphAM.addEdge(3, 4, false, 3);
        System.out.println(weightedGraphAM.toString());

        test algoritmMST = new test();
        int[][] ans = algoritmMST.primAlgorithmMST(weightedGraphAM.getGraph(), weightedGraphAM.getTotalNode());
        algoritmMST.print(ans, weightedGraphAM.getTotalNode());
    }

}
