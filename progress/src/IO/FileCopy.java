package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileCopy {
    public static void fileCopy(String source, String target) throws IOException{
        //TWR
        try (FileInputStream in = new FileInputStream(source)) {
            try (FileOutputStream out = new FileOutputStream(target)) {
                byte[] bytes = new byte[1024];
                int bytesToRead;
                while ((bytesToRead = in.read(bytes)) != -1) {
                    out.write(bytes, 0, bytesToRead);
                }
            }
        }
    }
    public static void fileCopyNIO(String source, String target) throws IOException{
        try (FileInputStream in = new FileInputStream(source)) {
            try (FileOutputStream out = new FileOutputStream(target)) {
                FileChannel inChannel=in.getChannel();
                FileChannel outChannel=out.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                while (inChannel.read(buffer) != -1) {
                    buffer.flip();
                    outChannel.write(buffer);
                    buffer.clear();
                }
            }
        }
    }
    public static void main (String[] args) throws IOException {
        //String path = FileCopy.class.getResource("").getPath();
        String source =  "src/IO/a.txt";
        String target =  "src/IO/targetDir/c_a.txt";
        //System.out.println(path+" "+source+" "+target);
        fileCopyNIO(source, target);
    }
}
