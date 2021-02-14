package graph;

import java.util.ArrayList;

import static java.util.Arrays.sort;

public class Kruscala {

    public Edge[] mstKruskal(int[][] input) {
        Edge[] edges = matrixToEdge(input);
        UnionFind uf = new UnionFind(input);
        sort(edges);
        ArrayList<Edge> ost = new ArrayList<>();
        for (Edge edge:
             edges) {
            if (uf.find(edge.getV1()) != uf.find(edge.getV2())){
                ost.add(edge);
                uf.union(edge.getV1(),edge.getV2());
            }
        }
        return ost.toArray(new Edge[ost.size()]);
    }

    Edge[] matrixToEdge(int[][] input){
        ArrayList<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < input[0].length;i++){
            for (int j = i; j < input.length;j++){
                if (input[i][j] != 0){
                    edges.add(new Edge(i,j,input[i][j]));
                }
            }
        }
        return edges.toArray(new Edge[edges.size()]);
    }

    class UnionFind{
        int [] parrent;

        UnionFind(int[][] input){
            parrent = new int[input.length];
            for (int i = 0; i < input.length;i++){
                parrent[i] = i;
            }
        }

        int find(int v){
            if (parrent[v] == v){
                return v;
            } else {
                return find(parrent[v]);
            }
        }

        void union(int v1,int v2){
            if (parrent[v2] >=  parrent[v1]){
                parrent[v2] = parrent[v1];
            } else {
                parrent[v1] = parrent[v2];
            }
        }
    }
}
