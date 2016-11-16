/**
 * Creates an UndoableEdit, which consists of an Edge or a Node. The purpose is
 * for the UndoManager to keep track of which actions were drawn by the user and
 * to then take them and have the opportunity to undo them.
 * 
 * @author craig
 *
 */
public class UndoableEdit
{
    /**
     * Constructs an UndoableEdit object that contains an Edge
     * 
     * @param e the edge that was added to the UML Diagram
     */
    public UndoableEdit()
    {
        
    }
    
    public UndoableEdit(Edge e)
    {
        this.edge = e;

    }

    /**
     * Constructs an UndoableEdit object that contains a Node
     * 
     * @param n the node that was added to the UML Diagram
     */
    public UndoableEdit(Node n)
    {
        this.node = n;
    }

    Edge edge;
    Node node;

}
