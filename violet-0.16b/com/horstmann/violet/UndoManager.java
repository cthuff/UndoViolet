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
    public UndoManager(Stack<UndoableEdit> editable)
    {
        this.edits = editable;
    }

    public void add(UndoableEdit e)
    {
        edits.add(e);
    }

    public void undo()
    {

    }

    public void redo()
    {

    }

    private Stack<UndoableEdit> edits;
}
