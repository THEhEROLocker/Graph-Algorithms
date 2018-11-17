package com.company;

public class DijkstraTable implements Comparable{
    private Vertex parent = null;
    private int pathCostToHere;
    private Vertex value = null;

    DijkstraTable(){
        this.parent = null;
        this.pathCostToHere = 0;
        this.value = null;
    }

    DijkstraTable(Vertex VALUE, Vertex PARENT, int PATHCOST){
        if(VALUE != null)
            this.value = new Vertex(VALUE.getName());
        if (PARENT != null)
            this.parent = new Vertex(PARENT.getName());

        this.pathCostToHere = PATHCOST;
    }

    public Vertex getParent() {
        return parent;
    }

    public int getPathCostToHere() {
        return pathCostToHere;
    }

    public Vertex getValue() {
        return value;
    }

    public void setPathCostToHere(int pathCostToHere) {
        this.pathCostToHere = pathCostToHere;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    @Override
    public int compareTo(Object o) {
        DijkstraTable obj = (DijkstraTable)o;

        return pathCostToHere - obj.pathCostToHere;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return getValue().getName().equals(((DijkstraTable)obj).getValue().getName());
    }
}
