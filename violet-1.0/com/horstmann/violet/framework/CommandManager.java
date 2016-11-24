package com.horstmann.violet.framework;

import java.util.Stack;

class CommandManager
{
    private Stack<ICommand> commandUndoStack = new Stack<ICommand>();
    private Stack<ICommand> commandRedoStack = new Stack<ICommand>();

    public void ExecuteCommand(ICommand cmd)
    {
        cmd.Execute();
        commandUndoStack.push(cmd);
    }

    public void Undo()
    {
        if (!commandUndoStack.empty())
        {       
            ICommand cmd = commandUndoStack.pop();
            cmd.UndoExecute();
            commandRedoStack.push(cmd);
              
        }
    }

    public void Redo()
    {
        if (!commandRedoStack.empty())
        {
            ICommand cmd = commandRedoStack.pop();
            cmd.Execute();
            commandUndoStack.push(cmd);
        }
    }
}