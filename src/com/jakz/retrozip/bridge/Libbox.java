package com.jakz.retrozip.bridge;

import org.bridj.ann.Library;
import org.bridj.BridJ;
import org.bridj.Pointer;

@Library("dll")
public class Libbox
{
  static {
    BridJ.register();
  }
  
  public native Pointer boxOpenArchive(Pointer name);
  public native void boxFillArchiveInfo(Pointer handle, Pointer<ArchiveInfo> info);
  public native void boxFillEntryInfo(Pointer handle, long index, Pointer<EntryInfo> info);
  
  
  static Libbox lib = new Libbox();
}
