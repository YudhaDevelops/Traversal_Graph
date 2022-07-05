package traversal_graph;
import java.util.ArrayList;
public class Traversal_Graph {
    public static void main(String[] args) {
        //data yang masukk dulu nanti di keluar akhir
        ArrayList MST;
        Graph g = new Graph();
        
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        g.addVertex('F');
        g.addVertex('G');
        g.addVertex('H');
        g.addVertex('I');
        g.addVertex('J');
        
        g.addEdge('A', 'B', 5);
        g.addEdge('B', 'E', 9);
        g.addEdge('E', 'I', 9);
        g.addEdge('I', 'J', 7);
        g.addEdge('A', 'C', 5);
        g.addEdge('C', 'F', 7);
        g.addEdge('F', 'G', 3);
        g.addEdge('G', 'J', 7);
        g.addEdge('B', 'D', 4);
        g.addEdge('C', 'D', 4);
        g.addEdge('D', 'E', 8);
        g.addEdge('D', 'F', 6);
        g.addEdge('F', 'E', 10);
        g.addEdge('E', 'G', 10);
        g.addEdge('E', 'H', 8);
        g.addEdge('H', 'I', 4);
        g.addEdge('H', 'G', 6);
        g.addEdge('H', 'J', 6);
        
        System.out.println("");
        System.out.println("A B C D E F G H I J");
        System.out.println("0 1 2 3 4 5 6 7 8 9");
        System.out.println("");
        MST = g.getPrimEdges(6);
        for (int i = 0; i < MST.size(); i++) {
            System.out.println(MST.get(i));
        }
        System.out.println("");
//        System.out.println("");
//        g.show();
//        System.out.println("");
//        g.setFlag();
//        System.out.println("");
//        System.out.println("DFS");
//        g.dfs();
//        System.out.println(g.toString());
//        System.out.println("");
//        g.setFlag();
//        System.out.println("");
//        System.out.println("BFS");
//        g.bfs();
        
        
//        System.out.println(g.toString());
    }
    
}
