package IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @Author:Jason
 * @Description:
 * @Date:Created in 15:58 2017/12/22
 * @Modified By:
 */
public class NIOpath {
    public static void main (String[] args){
        System.out.println("删除文件操作(C:/Users/Jason/Desktop/javaio.txt):"+delFile("C:/Users/Jason/Desktop/javaio.txt"));
        System.out.println("创建多级文件夹操作:" + createDirs());
        System.out.println("创建文件操作" + createFile());
        System.out.println("写入操作"+writeStr("src/IO/a.txt"));
    }
    static boolean delFile(String file){
        boolean flag=true;
        Path path = Paths.get(file);
        try {
            Files.delete(path);

        } catch (IOException e) {
            flag=true;
            e.printStackTrace();
        }
        return flag;
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
    static boolean createDirs(){
        boolean flag=true;
        Path path = Paths.get("D:/TEST/TEST");
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            flag=false;
            e.printStackTrace();
        }
        return flag;
    }
    static boolean createFile(){
        boolean flag=true;
        Path path = Paths.get("D:/TEST/TEST/test.txt");
        try {
            Files.createFile(path);
        } catch (IOException e) {
            flag=false;
            e.printStackTrace();
        }
        return flag;
    }

    static boolean copy(String source, String target) {
        boolean flag=true;
        Path path1 = Paths.get(source);
        Path path2 = Paths.get(target);
        try {
            Files.copy(path1, path2, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            flag=false;
            e.printStackTrace();
        }
        return flag;
    }
    static void readLine(String file){
        Path path = Paths.get(file);
        try (BufferedReader bufferedReader = Files.newBufferedReader(path);){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static boolean writeStr(String file){
        Path path = Paths.get(file);
        boolean flag=true;
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            bufferedWriter.write("NIO 写入操作");
        } catch (IOException e) {
            flag=false;
            e.printStackTrace();
        }
        return flag;
    }
}
