package com.horstmann.violet.framework;

public interface ICommand
{
    boolean Execute();
    void UndoExecute();
}