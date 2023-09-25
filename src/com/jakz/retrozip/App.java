package com.jakz.retrozip;

import org.bridj.*;

import com.jakz.retrozip.bridge.ArchiveInfo;
import com.jakz.retrozip.bridge.EntryInfo;
import com.jakz.retrozip.bridge.Libbox;
import com.jakz.retrozip.ui.ArchiveEntryTable;
import com.jakz.retrozip.ui.Mediator;
import com.jakz.retrozip.ui.Menu;
import com.jakz.retrozip.ui.Toolbar;
import com.pixbits.lib.lang.Size;
import com.pixbits.lib.lang.StringUtils;
import com.pixbits.lib.ui.UIUtils;
import com.pixbits.lib.ui.table.ColumnSpec;
import com.pixbits.lib.ui.table.DataSource;
import com.pixbits.lib.ui.table.FilterableDataSource;
import com.pixbits.lib.ui.table.TableModel;

import static org.bridj.Pointer.*;

import java.awt.BorderLayout;
import java.util.Collection;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class App
{
  static ArchiveEntryTable table;
  
  public static void main(String[] args)
  {    
    String path = "C:\\Users\\Jack\\Documents\\dev\\retrozip\\projects\\msvc2017\\cli\\output.box";
    ArchiveInfo archive = new ArchiveInfo(path);
    
    List<EntryInfo> entries = archive.entries();

    initUI();
    
    table.refresh(entries);
  }
  
  public static void initUI()
  {
    Mediator mediator = new Mediator();
    
    table = new ArchiveEntryTable(mediator);
    var panel = UIUtils.buildFillPanel(table, new Size.Int(1024, 768));
    var frame = UIUtils.buildFrame(panel, "Entries");
    
    frame.add(new Toolbar(), BorderLayout.NORTH);
    frame.setJMenuBar(new Menu(mediator));
    frame.pack();
    
        
    frame.exitOnClose();
    frame.centerOnScreen();
    frame.setVisible(true);
  }
}
