package IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class StatisticsName {
    public static void main (String[] args) throws IOException {
        File f = new File("src/IO/names.txt");
        //根据文件对象,创建文件读取流

        FileReader reader = new FileReader(f);
        BufferedReader bufferedReader = new BufferedReader(reader);
        TreeMap<String, Integer> nameMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        //HashMap<String, Integer> nameMap = new HashMap<>();
        while (bufferedReader.read()!=-1) {
            String str=bufferedReader.readLine();
            String[] sl=str.split(",");
            String key=sl[1];
            if (nameMap.containsKey(key)) {
                int value = nameMap.get(key);
                nameMap.replace(key, value, ++value);
            } else {
                nameMap.put(key, 1);
            }
        }
        Set<String> names=nameMap.keySet();
        for (Iterator<String> stringIterator = names.iterator(); stringIterator.hasNext(); ) {
            String next =  stringIterator.next();
            System.out.println(next+"的出现次数:"+nameMap.get(next));
        }
    }
}
