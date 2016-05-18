package com.shjt.map;

import java.security.MessageDigest;

public class MD5Util {
	
  public static final String MD5(String src) {
    char[] keys = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
    try
    {
      byte[] arrMd5 = src.getBytes();
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(arrMd5);
      byte[] tmp = md.digest();
      int i = tmp.length;
      char[] dst = new char[i * 2];
      int j = 0;
      int k = 0;
      while (true) {
        if (j >= i) {
          return new String(dst);
        }
        int m = tmp[j];
        int n = k + 1;
        dst[k] = keys[(0xF & m >>> 4)];
        k = n + 1;
        dst[n] = keys[(m & 0xF)];
        j++;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}