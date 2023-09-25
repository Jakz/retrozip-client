package com.jakz.retrozip.ui;

import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class Toolbar extends JToolBar
{

  public Toolbar()
  {
    super(SwingConstants.HORIZONTAL);
    setFloatable(false);
    
    JButton extract = new JButton("Extract");
    
    add(extract);
  }
}
