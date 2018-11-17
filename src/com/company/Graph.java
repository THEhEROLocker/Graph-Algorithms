package com.company;

import java.util.*;
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

    public Graph primsAlgorithm(String start){
        return primsAlgorithm(adjacencyList.get(adjacencyList.indexOf(new Vertex(start))));
    }

    private Graph primsAlgorithm(Vertex start){
        Graph minimumSpanningTree = new Graph();
        minimumSpanningTree.insertVertex(start.getName());

        while(minimumSpanningTree.adjacencyList.size()!= adjacencyList.size()){
            String minimumNameFrom = null;
            String minimumNameTo = null;
            int minimumweight = Integer.MAX_VALUE;
            for(int i=0; i<minimumSpanningTree.adjacencyList.size(); ++i){
                Vertex value = adjacencyList.get(adjacencyList.indexOf(minimumSpanningTree.adjacencyList.get(i))).getMinimum(minimumSpanningTree.adjacencyList);
                int weight = Integer.MAX_VALUE;
                if(value != null) {
                    weight = adjacencyList.get(adjacencyList.indexOf(minimumSpanningTree.adjacencyList.get(i))).getConnectionWeight(value.getName());
                }
                if(weight < minimumweight){
                    minimumweight = weight;
                    minimumNameFrom = minimumSpanningTree.adjacencyList.get(i).getName();
                    minimumNameTo = value.getName();
                }
            }

            minimumSpanningTree.insertEdge(minimumNameFrom,minimumNameTo,minimumweight);
        }

        return minimumSpanningTree;
    }

    public void displayGraph(){
        for(int i = 0; i<adjacencyList.size(); ++i){
            System.out.print(adjacencyList.get(i).getName() + " ");
            adjacencyList.get(i).display();
            System.out.println();
        }
    }


    public void dijkstraAlgorithm(String start){
        ArrayList<DijkstraTable> notVisited= new ArrayList<>();
        ArrayList<DijkstraTable> visited = new ArrayList<>();

        for(Vertex elem: adjacencyList){
            if(elem.getName().equals(start)){
                notVisited.add(new DijkstraTable(elem,new Vertex(),0));
            }
            else{
                notVisited.add(new DijkstraTable(elem,null,Integer.MAX_VALUE));
            }
        }

        Collections.sort(notVisited);

        while(notVisited.size()!=0){
            DijkstraTable smallest = notVisited.get(0);
            notVisited.remove(0);
            visited.add(smallest);


            for(Edge neighbor: adjacencyList.get(adjacencyList.indexOf(smallest.getValue())).getConnections()){
                if(visited.indexOf(new DijkstraTable(neighbor.getTo(),new Vertex(),1)) == -1){
                    int newW = neighbor.getWeight()+smallest.getPathCostToHere();
                    int oldW = notVisited.get(notVisited.indexOf(new DijkstraTable(neighbor.getTo(),new Vertex(),1))).getPathCostToHere();

                    if(newW < oldW){
                        DijkstraTable v =  notVisited.get(notVisited.indexOf(new DijkstraTable(neighbor.getTo(),new Vertex(),1)));
                        v.setPathCostToHere(newW);
                        v.setParent(smallest.getValue());
                    }
                }
            }

            Collections.sort(notVisited);

        }
        for(DijkstraTable elem: visited){
            System.out.println(elem.getValue().getName()+ " "+ elem.getPathCostToHere() + " " + elem.getParent().getName());
        }
    }


}
