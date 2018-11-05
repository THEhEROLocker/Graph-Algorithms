package com.company;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Vertex> adjacencyList;

    Graph(){
        adjacencyList = new ArrayList<>();
    }

    public void insertVertex(String name){
        Vertex newVertex = new Vertex(name);
        adjacencyList.add(newVertex);
    }

    public void insertEdge(String vertexNameFrom, String vertexNameTo, int weight){
        int indexFrom = adjacencyList.indexOf(new Vertex(vertexNameFrom));
        if(indexFrom == -1){
            adjacencyList.add(new Vertex(vertexNameFrom));
            indexFrom = adjacencyList.size() -1;
        }

        int indexTo = adjacencyList.indexOf(new Vertex(vertexNameTo));
        if(indexTo == -1){
            adjacencyList.add(new Vertex(vertexNameTo));
            indexTo = adjacencyList.size() -1;
        }

        adjacencyList.get(indexFrom).insertEdge(new Edge(adjacencyList.get(indexFrom),adjacencyList.get(indexTo),weight));
        adjacencyList.get(indexTo).insertEdge(new Edge(adjacencyList.get(indexTo),adjacencyList.get(indexFrom),weight));
    }
}
