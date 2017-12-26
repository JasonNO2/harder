package IO;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @Author:Jason
 * @Description:获取某一目录下的所有文件
 * @Date:Created in 15:33 2017/12/22
 * @Modified By:
 */
public class FileList {
    public static void main (String[] args) throws IOException {
        String directory="C:/Users/Jason/Desktop/harder";
        //itDir(directory);

        //使用NIO做同样的事情
        itDitINO(directory);
    }

    static void itDir(String directory) {
        File file = new File(directory);
        File[] files=file.listFiles();
        for (int i = 0; i < files.length; i++) {
            File file1 = files[i];
            String dir=directory+"/"+file1.getName();
            if (file1.isFile()) {
                System.out.println(dir);
            }
            if (file1.isDirectory()) {
                itDir(dir);
            }
        }
    }
    static void itDitINO(String directory) throws IOException {
        Path initPath = Paths.get(directory);
        Files.walkFileTree(initPath, new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.getFileName().toAbsolutePath());
                return super.visitFile(file, attrs);
            }
        });
    }
}
