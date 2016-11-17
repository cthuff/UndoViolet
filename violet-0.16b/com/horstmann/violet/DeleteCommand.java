package com.horstmann.violet;

import java.awt.geom.Point2D;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.horstmann.violet.framework.Edge;
import com.horstmann.violet.framework.Graph;
import com.horstmann.violet.framework.ICommand;
import com.horstmann.violet.framework.Node;

public class DeleteCommand implements ICommand{

    public DeleteCommand(Graph graph, Set selectedItem) {
        this.graph = graph;
        this.selectedItems = selectedItem; 
        lastselectedItems.addAll(selectedItem);
        
    }
    
    @Override
    public boolean Execute() {
        Iterator iter = selectedItems.iterator();
        while (iter.hasNext())
        {
           Object selected = iter.next();                 
           if (selected instanceof Node)
           {
              graph.removeNode((Node) selected);
           }
           else if (selected instanceof Edge)
           {
              graph.removeEdge((Edge) selected);
           }
        }
        return true;
    }

    @Override
    public void UndoExecute() {
        Iterator iter = lastselectedItems.iterator();
        while (iter.hasNext())
        { 
           Object selected = iter.next();   
           if (selected instanceof Node)
           {

               double[] a = ((Node) selected).location();
               Point2D.Double location = new Point2D.Double(a[0],a[1]);               
               graph.addNode((Node) selected,location);
           }
           else if (selected instanceof Edge)
           {
               //TODO
              graph.removeEdge((Edge) selected);
           }
        }
        this.selectedItems = this.lastselectedItems;
    }

    private Graph graph;
    private Set selectedItems = new HashSet();
    private Set lastselectedItems = new HashSet();
   
}
