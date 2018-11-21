package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Graph graph = new Graph();

//        graph.insertEdge("0","1",4);
//        graph.insertEdge("0","7",8);
//        graph.insertEdge("1","7",11);
//        graph.insertEdge("1","2",8);
//        graph.insertEdge("2","3",7);
//        graph.insertEdge("2","5",4);
//        graph.insertEdge("2","8",2);
//        graph.insertEdge("3","4",9);
//        graph.insertEdge("3","5",14);
//        graph.insertEdge("4","5",10);
//        graph.insertEdge("5","6",2);
//        graph.insertEdge("6","8",6);
//        graph.insertEdge("6","7",1);
//        graph.insertEdge("7","8",7);

        graph.insertEdge("A","B",-1,false);
        graph.insertEdge("A","C",4,false);
        graph.insertEdge("B","E",2,false);
        graph.insertEdge("B","D",1,false);
        graph.insertEdge("B","C",3,false);
        graph.insertEdge("D","C",5,false);
        graph.insertEdge("D","B",2,false);
        graph.insertEdge("E","D",-3,false);

        // graph.depthFirstSearch("7");
        // graph.breadthFirstSearch("0");
        graph.displayGraph();
        //Graph minimumSpanningTree = graph.primsAlgorithm("0");
        //System.out.println();
        //minimumSpanningTree.displayGraph();
        ArrayList<DijkstraTable> returned = graph.bellmanFordAlgorithm("A");

        for(DijkstraTable elem: returned){
            System.out.println(elem.getValue().getName()+ " "+ elem.getPathCostToHere());
        }
    }
}
