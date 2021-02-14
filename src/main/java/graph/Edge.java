package graph;

public class Edge implements Comparable {
    private int v1;
    private int v2;
    private int w;

    public Edge(int v1, int v2, int w) {
        this.v1 = v1;
        this.v2 = v2;
        this.w = w;
    }

    public int getV1() {
        return v1;
    }

    public void setV1(int v1) {
        this.v1 = v1;
    }

    public int getV2() {
        return v2;
    }

    public void setV2(int v2) {
        this.v2 = v2;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    @Override
    public int compareTo(Object o) {
        Edge edge = (Edge) o;
        if (w != edge.w) return w < edge.w ? -1 : 1;
        return 0;
    }
}
