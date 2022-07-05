package traversal_graph;
public class Vertex {
    public char label;
    public boolean flagVisited;

    public Vertex(char label) {
        this.label = label;
        flagVisited = false;
    }

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }

    public boolean isFlagVisited() {
        return flagVisited;
    }

    public void setFlagVisited(boolean flagVisited) {
        this.flagVisited = flagVisited;
    }
}
