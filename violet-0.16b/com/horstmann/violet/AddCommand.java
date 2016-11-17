package com.horstmann.violet;

import java.awt.geom.Point2D;
import java.awt.Component;

import com.horstmann.violet.framework.Edge;
import com.horstmann.violet.framework.Graph;
import com.horstmann.violet.framework.ICommand;
import com.horstmann.violet.framework.Node;

public class AddCommand implements ICommand{

    
    public AddCommand(Graph graph, Node n, Point2D p ) {
        this.graph = graph;
        this.point = p;
        this.node = n;
        isNode = true;
    }
    
    public AddCommand(Graph graph, Edge e, Point2D downPoint, Point2D endPoint) {
        this.graph = graph;
        this.edge = e;
        this.mouseDownPoint = downPoint;
        this.point = endPoint;
        isNode = false;
        
    }
    
    @Override
    public boolean Execute() { 
        if(isNode) {
            graph.add(node, point);
            
        }
        else if(!isNode) {
            graph.connect(edge, mouseDownPoint, point);
        }
            
        return true;
    }

    @Override
    public void UndoExecute() {
        if(isNode) {
            graph.removeNode(node);
        }
        else if(!isNode) {
            graph.removeEdge(edge);
        }

        
    }

    private Graph graph;
    private Point2D point;
    private Point2D mouseDownPoint;
    private Node node;
    private Edge edge;
    private boolean isNode = true;
    
    
}
