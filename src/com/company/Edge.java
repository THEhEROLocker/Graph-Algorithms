package com.company;

public class Edge {
    private Vertex from;
    private Vertex to;
    private int weight;

    Edge(){
        from = to = null;
        weight = 0;
    }

    Edge(Vertex FROM, Vertex TO, int WEIGHT){
        this.from = FROM;
        this.to = TO;
        this.weight = WEIGHT;
    }

    public Vertex getFrom() {
        return from;
    }

    public Vertex getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }
}
