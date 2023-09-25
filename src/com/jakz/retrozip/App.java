package com.jakz.retrozip;

import org.bridj.*;

import com.jakz.retrozip.bridge.ArchiveInfo;
import com.jakz.retrozip.bridge.EntryInfo;
import com.jakz.retrozip.bridge.Libbox;
import com.pixbits.lib.lang.StringUtils;

import static org.bridj.Pointer.*;

public class App
{
  public static void main(String[] args)
  {    
    Pointer<?> pointer = pointerToCString("C:\\Users\\Jack\\Documents\\dev\\retrozip\\projects\\msvc2017\\cli\\output.box");
    
    Libbox l = new Libbox();
    
    Pointer<?> handle = l.boxOpenArchive(pointer);
    ArchiveInfo info = new ArchiveInfo();
    
    Pointer<ArchiveInfo> info2 = getPointer(info);
    
    l.boxFillArchiveInfo(handle, info2);
    
    EntryInfo entry = new EntryInfo();
    Pointer<EntryInfo> entry2 = getPointer(entry);
    
    System.out.println("first");
    l.boxFillEntryInfo(handle, 1, entry2);
    System.out.println("after");
    
    System.out.println("Entries: "+entry.size()+" "+entry.filteredSize()+" "+StringUtils.toHexString(entry.md5()));
  }
}
