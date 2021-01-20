package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length < 4 || !args[0].equals("-c")) return;
        float price;
        int qty;


        try {
            price = Float.parseFloat(args[args.length - 2]);
            qty = Integer.parseInt(args[args.length - 1]);
        } catch (NumberFormatException e) {
            return;
        }

        String productName;
        if (args.length > 4) {
            StringBuffer buf = new StringBuffer();
            for (int i = 1; i < args.length - 2; i++)
                buf.append(args[i]).append(" ");
            productName = buf.substring(0, buf.length() - 1);
        } else
            productName = args[1];

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = consoleReader.readLine();
        consoleReader.close();

        List<String> lines = new ArrayList<>();
        try(BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))){
            while (fileReader.ready()){
                lines.add(fileReader.readLine());
            }
        }
        Pattern pattern = Pattern.compile("[0-9]{1,8}");
        int max_id = 0;
        for (String line: lines){
            Matcher m = pattern.matcher(line);
            if (m.lookingAt()){
                try {
                    int id = Integer.parseInt(line.substring(m.start(), m.end()));
                    if (id > max_id){
                        max_id = id;
                    }
                }catch (NumberFormatException ex){
                    continue;
                }
            }
        }

        if (max_id++ == 999999999)return;

        String toFile = String.format(Locale.ROOT, "%-8d%-30s%-8.2f%-4d",max_id, productName, price, qty);

        lines.add(toFile);

        try(BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)))){
            for (String line: lines) {
                bufferedWriter.write(line+"\r\n");
            }
        }

    }
}
