package traversal_graph;

import java.util.Stack;

public class Stack_Graph {
    Stack <Graph> stackGraph = new Stack <Graph>();
    Graph graph;
    
    public void push(char data){
        graph.addVertex(data);
        stackGraph.add(graph);
    }
    
    public void pop(){
        stackGraph.pop();
    }
    
}
