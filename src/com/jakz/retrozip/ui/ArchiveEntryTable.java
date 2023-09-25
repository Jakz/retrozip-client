package com.jakz.retrozip.ui;

import java.awt.BorderLayout;
import java.util.Collection;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.jakz.retrozip.bridge.EntryInfo;
import com.pixbits.lib.ui.table.ColumnSpec;
import com.pixbits.lib.ui.table.DataSource;
import com.pixbits.lib.ui.table.FilterableDataSource;
import com.pixbits.lib.ui.table.TableModel;

public class ArchiveEntryTable extends JPanel
{
  private Mediator mediator;
  
  private FilterableDataSource<EntryInfo> data;

  private TableModel<EntryInfo> model;
  private JTable table;
  
  public ArchiveEntryTable(Mediator mediator)
  {
    this.mediator = mediator;
    
    table = new JTable();
    table.setAutoCreateRowSorter(true);
    model = new Model(table);
    
    model.addColumn(new ColumnSpec<EntryInfo, String>("Name", String.class, e -> e.name()));
    model.addColumn(new ColumnSpec<EntryInfo, Long>("Size", Long.class, e -> e.size()));
    model.addColumn(new ColumnSpec<EntryInfo, Long>("Filtered Size", Long.class, e -> e.filteredSize()));

    setLayout(new BorderLayout());
    add(new JScrollPane(table), BorderLayout.CENTER);
  }
  
  public void refresh(Collection<EntryInfo> data)
  {
    this.data = FilterableDataSource.of(data);
    model.setData(this.data);
    model.fireTableDataChanged();
  }
  
  private class Model extends TableModel<EntryInfo>
  {
    Model(JTable table)
    {
      super(table, DataSource.empty());
    }
  }
}
