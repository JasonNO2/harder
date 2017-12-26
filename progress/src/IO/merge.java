package IO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class merge {
    public static void main (String[] args) throws IOException {
        //将文件a.txt与b.tx交叉合并
        String root=System.getProperty("user.dir");
        File f1 = new File("src/IO/a.txt");
        File f2 = new File("src/IO/b.txt");
        File f3 = new File("src/IO/c.txt");



        FileReader r1 = new FileReader(f1);
        FileReader r2 = new FileReader(f2);
        FileWriter r3 = new FileWriter(f3);

        char[] c1 = new char[(int)f1.length()];
        char[] c2 = new char[(int)f2.length()];
        int len1=r1.read(c1);
        int len2=r2.read(c2);
        
        for (int i = 0; i < len1; i++) {
            r3.write(c1[i]);
            r3.write(c2[i]);
        }
        if (len2 > len1) {
            for (int i = len1; i < len2; i++) {
                r3.write(c2[i]);
            }
        }
        r1.close();
        r2.close();
        r3.close();
    }
}
