package com.jakz.retrozip.ui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar
{
  public Menu(Mediator mediator)
  {
    JMenu file = new JMenu("File");
    
    JMenuItem exit = new JMenuItem("Exit");
    exit.setAction(new Actions.Exit(mediator));
    file.add(exit);
    
    JMenu view = new JMenu("View");
    
    add(file);
    add(view);
  }
}
