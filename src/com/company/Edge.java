package com.company;

public class Edge implements Comparable {
    private Vertex from;
    private Vertex to;
    private int weight;

    public void setWeight(int weight) {
        this.weight = weight;
    }

    Edge() {
        from = to = null;
        weight = 0;
    }

    Edge(Vertex FROM, Vertex TO, int WEIGHT) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;

        Edge edge = (Edge) o;

        return (getTo() != null ? getTo().equals(edge.getFrom()) : edge.getFrom() != null);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public int compareTo(Object comparestu) {
        return this.weight - ((Edge) comparestu).getWeight();
    }

    @Override
    public String toString() {
        return "Edge{" +
                "from=" + from +
                ", to=" + to +
                ", weight=" + weight +
                '}';
    }
}
