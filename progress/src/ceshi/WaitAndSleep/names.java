package ceshi.WaitAndSleep;

import java.io.*;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class names {
    public static void main (String[] args) throws IOException {
        //获取资源且生成字节流
        //names.class.getResourceAsStream("src/ceshi/names.txt");
        File f = new File("src/ceshi/WaitAndSleep/names.txt");
        TreeMap<String, Integer> namesMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        FileReader fileReader = new FileReader(f);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String key=null;
        while ((key=bufferedReader.readLine())!=null) {
            if (namesMap.containsKey(key)) {
                int val = namesMap.get(key);
                namesMap.replace(key, ++val);
            } else {
                namesMap.put(key, 1);
            }
        }
        Set<String> keySet=namesMap.keySet();
        for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext(); ) {
            String next =  iterator.next();
            System.out.println(next+"出现的次数:"+namesMap.get(next));
        }
    }
}
