package com.jakz.retrozip.bridge;

import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;

import static org.bridj.Pointer.*;


public class EntryInfo extends StructObject
{
  public EntryInfo() { super(); }
  public EntryInfo(Pointer pointer) { super(pointer); }
  
  @Field(0) public Pointer<Byte> nativeName() { return this.io.getPointerField(this, 0); }
  @Field(0) public EntryInfo nativeName(Pointer<Byte> v) { this.io.setPointerField(this, 0, v); return this; }
  
  public String name() { return nativeName().getCString(); }
  public EntryInfo name(String v) { nativeName(pointerToCString(v)); return this; }
  
  @Field(1) public long size() { return this.io.getSizeTField(this, 1); }
  @Field(1) public EntryInfo size(long v) { this.io.setSizeTField(this, 1, v); return this; }
  
  @Field(2) public long filteredSize() { return this.io.getSizeTField(this, 2); }
  @Field(2) public EntryInfo filteredSize(long v) { this.io.setSizeTField(this, 2, v); return this; }
  
  @Field(3) public long crc32() { return this.io.getLongField(this, 3); }
  @Field(3) public EntryInfo crc32(long v) { this.io.setLongField(this, 3, v); return this; }
  
  @Field(4) public Pointer<Byte> nativeMd5() { return this.io.getPointerField(this, 4); }
  @Field(4) public EntryInfo nativeMd5(Pointer<Byte> v) { this.io.setPointerField(this, 4, v); return this; }
  
  public byte[] md5() { return nativeMd5().getBytes(16); }
  public EntryInfo md5(byte[] v) { nativeMd5(Pointer.pointerToBytes(v)); return this; }
  
  @Field(5) public Pointer<Byte> nativeSha1() { return this.io.getPointerField(this, 5); }
  @Field(5) public EntryInfo nativeSha1(Pointer<Byte> v) { this.io.setPointerField(this, 5, v); return this; }
  
  public byte[] sha1() { return nativeSha1().getBytes(20); }
  public EntryInfo sha1(byte[] v) { nativeSha1(Pointer.pointerToBytes(v)); return this; }
}
