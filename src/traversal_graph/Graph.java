package traversal_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    private int MaxVertex = 10;
    private Vertex[] vertexList;
    private int[][] adjacencyMatrix;
    private int countVertex = 0;
    
    ArrayList<Edge> primEdge = new ArrayList<>();
    ArrayList<Integer> primVertexs = new ArrayList<>();
    Queue qGraph = new LinkedList();

    public Graph() {
        vertexList = new Vertex[MaxVertex];
        adjacencyMatrix = new int[MaxVertex][MaxVertex];
        for (int i = 0; i < MaxVertex; i++) {
            for (int j = 0; j < MaxVertex; j++) {
                if (i == j) {
                    adjacencyMatrix[i][j] = 0;
                }
            }
        }
    }

    public void addVertex(char label) {
        if (countVertex < MaxVertex) {
            vertexList[countVertex] = new Vertex(label);
            countVertex++;
            System.out.println("Data Masuk : " + label);
        }
    }

    public void addEdge(int dataAwal, int dataAkhir, int value) {
        adjacencyMatrix[dataAwal][dataAkhir] = value;
    }

    public void addEdge(char labelAwal, char labelAkhir, int value) {
        int dataAwal = indexVertex(labelAwal);
        int dataAkhir = indexVertex(labelAkhir);
        if (dataAwal != -1 || dataAkhir != -1) {
            addEdge(dataAwal, dataAkhir, value);
            addEdge(dataAkhir, dataAwal, value);
        } else {
            System.out.println("Gagal Membuat Edge");
        }
    }

    private int indexVertex(char label) {
        for (int i = 0; i < countVertex; i++) {
            if (vertexList[i] != null) {
                if (vertexList[i].label == label) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void show() {
        for (int i = 0; i < MaxVertex; i++) {
            for (int j = 0; j < MaxVertex; j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    System.out.println(vertexList[i].getLabel()
                            + " terhubung ke " + vertexList[j].getLabel()
                            + " dengan beban " + adjacencyMatrix[i][j]);
                }
            }
        }
    }

    public int getMaxVertex() {
        return MaxVertex;
    }

    public void setMaxVertex(int MaxVertex) {
        this.MaxVertex = MaxVertex;
    }

    public Vertex[] getVertexList() {
        return vertexList;
    }

    public void setVertexList(Vertex[] vertexList) {
        this.vertexList = vertexList;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public int getCountVertex() {
        return countVertex;
    }

    public void setCountVertex(int countVertex) {
        this.countVertex = countVertex;
    }

    //DFS 
    public void dfs() {
        int seed = 0;
        Stack stackGraph = new Stack();
        stackGraph.push(seed);
        while (!stackGraph.isEmpty()) {
            int bantu = (Integer) stackGraph.pop();
            if (!vertexList[bantu].isFlagVisited()) {
                System.out.print(vertexList[bantu].getLabel() + " ");
                vertexList[bantu].setFlagVisited(true);
                for (int i = countVertex - 1; i >= 0; i--) {
                    if (adjacencyMatrix[bantu][i] >= 1 && !vertexList[i].isFlagVisited()) {
                        stackGraph.push(i);
                    }
                }
            }
        }
        System.out.println("\n");
    }

    @Override
    public String toString() {
        for (int i = 0; i < vertexList.length; i++) {
            for (int j = 0; j < vertexList.length; j++) {
                System.out.printf("%3d", adjacencyMatrix[i][j]);
            }
            System.out.println("");
        }
        return "";
    }

    //BFS
    public void bfs() {
        int seed = 0;
        Queue qGraph = new LinkedList();
        qGraph.add(seed);
        while (!qGraph.isEmpty()) {
            int bantu = (Integer) qGraph.remove();
            if (!vertexList[bantu].isFlagVisited()) {
                System.out.print(vertexList[bantu].getLabel() + " ");
                vertexList[bantu].setFlagVisited(true);
                for (int i = 0; i <= countVertex - 1; i++) {
                    if (adjacencyMatrix[bantu][i] >= 1 && !vertexList[i].isFlagVisited()) {
                        qGraph.add(i);
                    }
                }
            }
        }
    }

    public void setFlag() {
        for (int i = 0; i < vertexList.length; i++) {
            if (vertexList[i] != null) {
                vertexList[i].setFlagVisited(false);
            }
        }
    }

    //MST
    public ArrayList<Edge> getPrimEdges(int val) {
        int vertexSeed = val;
        primVertexs.add(vertexSeed);
        vertexList[vertexSeed].setFlagVisited(true);

        while (primVertexs.size() < MaxVertex) {
            int tempMinWeight = Integer.MAX_VALUE;
            int tempMinIndekVertexI = -1;
            int tempMinIndekVertexJ = -1;

            for (int i = 0; i < primVertexs.size(); i++) {
                for (int j = 0; j < MaxVertex; j++) {
                    if (adjacencyMatrix[primVertexs.get(i)][j] >= 1 
                            && !vertexList[j].isFlagVisited() 
                            && adjacencyMatrix[primVertexs.get(i)][j] < tempMinWeight) {
                        
                        tempMinWeight = adjacencyMatrix[primVertexs.get(i)][j];
                        tempMinIndekVertexI = primVertexs.get(i);
                        tempMinIndekVertexJ = j;
                    }
                }
            }
            primVertexs.add(tempMinIndekVertexJ);
            vertexList[tempMinIndekVertexJ].setFlagVisited(true);
            Edge edge = new Edge();
            edge.setVertexA(tempMinIndekVertexI);
            edge.setVertexB(tempMinIndekVertexJ);
            edge.setWeight(tempMinWeight);
            primEdge.add(edge);
        }
        return primEdge;
    }
}
