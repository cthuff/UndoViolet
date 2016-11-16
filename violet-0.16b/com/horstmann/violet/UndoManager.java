import java.util.Stack;

import javax.swing.undo.UndoableEdit;

/**
 * This class manage a stack of UndoableEdits that can later be undone and
 * redone in the graph
 * 
 * @author craig
 *
 */
public class UndoManager
{
    /**
     * Constructs an UndoableEdit Stack
     * 
     * @param editable Stack to be initialized
     */
    public UndoManager(Stack<UndoableEdit> editable)
    {
        this.edits = editable;
    }

    /**
     * Adds the newest edit to the stack
     * @param e the edit to be added to the Stack
     */
    public void add(UndoableEdit e)
    {
        edits.add(e);
    }

    /**
     * When the undo button is clicked 
     */
    public void undo()
    {

    }

    public void redo()
    {

    }

    private Stack<UndoableEdit> edits;
}
