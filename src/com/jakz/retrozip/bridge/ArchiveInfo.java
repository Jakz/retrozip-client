package com.jakz.retrozip.bridge;

import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;

public class ArchiveInfo extends StructObject
{
  public ArchiveInfo() { super(); }
  public ArchiveInfo(Pointer pointer) { super(pointer); }
  
  @Field(0) public long entryCount() { return this.io.getSizeTField(this, 0); }
  @Field(0) public ArchiveInfo entryCount(long v) { this.io.setSizeTField(this, 0, v); return this; }
  
  @Field(1) public long streamCount() { return this.io.getSizeTField(this, 1); }
  @Field(1) public ArchiveInfo streamCount(long v) { this.io.setSizeTField(this, 1, v); return this; }
}
