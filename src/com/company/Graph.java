package com.company;

import java.util.ArrayList;
import java.util.Queue;
import java.util.stream.Stream;

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
            insertVertex(vertexNameFrom);
            indexFrom = adjacencyList.size() -1;
        }

        int indexTo = adjacencyList.indexOf(new Vertex(vertexNameTo));
        if(indexTo == -1){
            insertVertex(vertexNameTo);
            indexTo = adjacencyList.size() -1;
        }

        adjacencyList.get(indexFrom).insertEdge(new Edge(adjacencyList.get(indexFrom),adjacencyList.get(indexTo),weight));
        adjacencyList.get(indexTo).insertEdge(new Edge(adjacencyList.get(indexTo),adjacencyList.get(indexFrom),weight));
    }

    public void depthFirstSearch(String vertexFrom){
        depthFirstSearch(adjacencyList.get(adjacencyList.indexOf(new Vertex(vertexFrom))));
    }

    private void depthFirstSearch(Vertex start){
        start.setVisited();
        System.out.println(start.getName());

        for(Edge neighbor:start.getConnections()){
            if(!neighbor.getTo().isVisited()){
                depthFirstSearch(neighbor.getTo());
            }
        }
    }

    public void breadthFirstSearch(String from){
        breadthFirstSearch(adjacencyList.get(adjacencyList.indexOf(new Vertex(from))));
    }

    private void breadthFirstSearch(Vertex start){
        ArrayList<Vertex> queue = new ArrayList<>();

        queue.add(start);

        while(queue.size() != 0 ) {
            Vertex top = queue.get(0);
            queue.remove(0);
            top.setVisited();
            System.out.println(top.getName());

            for (Edge connnection : top.getConnections()) {
                if(!connnection.getTo().isVisited() && !queue.contains(connnection.getTo()))
                    queue.add(connnection.getTo());
            }
        }
    }

    public void primsAlgorithm(String start){
        primsAlgorithm(adjacencyList.get(adjacencyList.indexOf(new Vertex(start))));
    }

    private void primsAlgorithm(Vertex start){
        ArrayList<Vertex> minimumSpanningTree = new ArrayList<>();


    }

    public void displayGraph(){
        for(int i = 0; i<adjacencyList.size(); ++i){
            System.out.print(adjacencyList.get(i).getName() + " ");
            adjacencyList.get(i).display();
            System.out.println();
        }
    }

}
