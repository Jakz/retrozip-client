package com.jakz.retrozip.ui;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class Actions
{
  public static abstract class Base extends AbstractAction
  {
    private Mediator mediator;
    
    Base(Mediator mediator, String text)
    {
      super(text);
      this.mediator = mediator;
    }
  }
  
  public static class Exit extends Base
  {
    Exit(Mediator mediator)
    {
      super(mediator, "Exit");
    }
 
    @Override
    public void actionPerformed(ActionEvent e)
    {
      System.exit(0);

    }
    
  }
}
