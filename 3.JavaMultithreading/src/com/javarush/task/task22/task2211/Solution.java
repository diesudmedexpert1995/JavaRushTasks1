package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?";
        String fileInput = args[0];
        String fileOutput = args[1];
        FileInputStream fileInputStream = new FileInputStream(fileInput);
        FileOutputStream fileOutputStream = new FileOutputStream(fileOutput);
        byte[] bytesInp = new byte[fileInputStream.available()];
        fileInputStream.read(bytesInp);
        String str = new String(bytesInp, "Windows-1251");
        byte[] bytesOut = str.getBytes("UTF-8");
        fileOutputStream.write(bytesOut);
        fileOutputStream.close();
        fileInputStream.close();
    }
}
