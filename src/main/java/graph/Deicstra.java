package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Deicstra {

    public int[] deicstra(int[][] input) {
        int[] result = new int[input.length];
        HashMap<Integer, Mark> marks = new HashMap<Integer, Mark>(input.length);
        marks.put(0, new Mark(0, getVertexEdges(0, input), 0));
        for (int i = 1; i < input.length; i++) {
            marks.put(i, new Mark(i, getVertexEdges(i, input), Integer.MAX_VALUE));
        }
        while (!marks.isEmpty()) {
            Mark mark = minMark(marks);
            for (Edge edge : mark.getEdges()) {
                if (marks.containsKey(edge.getV2())) {
                    if (mark.getDistance() + edge.getW() < marks.get(edge.getV2()).getDistance()) {
                        marks.get(edge.getV2()).setDistance(mark.getDistance() + edge.getW());
                    }
                }
            }
            result[mark.getVertex()] = mark.getDistance();
            marks.remove(mark.getVertex());
        }
        return result;

    }

    class Mark {
        int vertex;
        int distance;
        ArrayList<Edge> edges;

        public Mark(int vertex, ArrayList<Edge> edges, int distance) {
            this.vertex = vertex;
            this.edges = edges;
            this.distance = distance;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public ArrayList<Edge> getEdges() {
            return edges;
        }

        public int getVertex() {
            return vertex;
        }
    }

    private Mark minMark(HashMap<Integer, Mark> marks) {
        return marks.values().stream().min(Comparator.comparing(Mark::getDistance)).get();
    }

    ArrayList<Edge> getVertexEdges(int v, int[][] input) {
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < input[v].length; i++) {
            if (input[v][i] != 0) {
                edges.add(new Edge(v, i, input[v][i]));
            }
        }
        return edges;
    }
}
