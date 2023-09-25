package com.jakz.retrozip.bridge;

import static org.bridj.Pointer.*;

import java.util.ArrayList;
import java.util.List;

import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;

public class ArchiveInfo extends StructObject
{
  Pointer<?> handle;

  public ArchiveInfo()
  {
    super();
  }

  public ArchiveInfo(Pointer pointer)
  {
    super(pointer);
  }

  public ArchiveInfo(String path)
  {
    handle = Libbox.lib.boxOpenArchive(pointerToCString(path));
    Libbox.lib.boxFillArchiveInfo(handle, getPointer(this));
  }

  @Field(0)
  public long entryCount()
  {
    return this.io.getSizeTField(this, 0);
  }

  @Field(0)
  public ArchiveInfo entryCount(long v)
  {
    this.io.setSizeTField(this, 0, v);
    return this;
  }

  @Field(1)
  public long streamCount()
  {
    return this.io.getSizeTField(this, 1);
  }

  @Field(1)
  public ArchiveInfo streamCount(long v)
  {
    this.io.setSizeTField(this, 1, v);
    return this;
  }

  public List<EntryInfo> entries()
  {
    List<EntryInfo> entries = new ArrayList<>();

    final long count = entryCount();
    for (int i = 0; i < count; ++i)
    {
      EntryInfo entry = new EntryInfo();
      Libbox.lib.boxFillEntryInfo(handle, i, getPointer(entry));
      entries.add(entry);
    }

    return entries;
  }
}
