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

    public int getConnectionWeight(String toName){
        for(int i=0;i<connections.size();++i){
            if(connections.get(i).getTo().getName().equals(toName)){
                return connections.get(i).getWeight();
            }
        }
        return 0;
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

    public Vertex getMinimum(ArrayList<Vertex> notInHereAlready){
        int minimumWeight = Integer.MAX_VALUE;
        int solutionConnectionIndex = 0;

        for(int i=0;i<connections.size();++i){
            if(connections.get(i).getWeight() < minimumWeight && isNtOneOfFormTheList(connections.get(i).getTo(),notInHereAlready)){
                solutionConnectionIndex = i;
                minimumWeight = connections.get(i).getWeight();
            }
        }

        if(minimumWeight == Integer.MAX_VALUE){
            return null;
        }
        else{
            return new Vertex(connections.get(solutionConnectionIndex).getTo().getName());
        }
    }

    public boolean isNtOneOfFormTheList(Vertex thing, ArrayList<Vertex> list){
        for(int i=0;i<list.size();++i){
            if(list.get(i).getName().equals(thing.getName())){
                return false;
            }
        }
        return true;
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
