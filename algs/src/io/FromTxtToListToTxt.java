package io;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 将字符串文本读入，放到list中，打乱顺序，再写入到新的文件中
 */
public class FromTxtToListToTxt {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("test-resource/sort-test-100000words.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test-resource/sort-test-100000words-new.txt"));

        String line;

        ArrayList<String> strings = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null) {
            String temp = line.trim();
            if (!"".equals(temp)) {
                strings.add(temp);
            }
        }

        bufferedReader.close();
        Collections.shuffle(strings);

        for (String s : strings) {
            bufferedWriter.write(s);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }

        bufferedWriter.close();
    }

}
