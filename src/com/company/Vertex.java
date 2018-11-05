package com.company;

import java.util.ArrayList;

public class Vertex {
    private String name;
    private ArrayList<Edge> connections;
    private boolean visited;

    Vertex(){
        this.name = null;
        this.connections = new ArrayList<>();
    }

    Vertex(String NAME){
        this.name = NAME;
        this.connections = new ArrayList<>();
    }

    public void insertEdge(Edge toInsert) {
        connections.add(toInsert);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Edge> getConnections() {
        return connections;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited() {
        this.visited = true;
    }

    public void display(){
        for(int i=0; i< connections.size(); ++i){
            System.out.print("("+connections.get(i).getTo().getName() + " " + connections.get(i).getWeight()+ ")");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        return getName().equals(vertex.getName());

    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
