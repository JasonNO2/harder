import java.io.*;

public class Stream {
    public static void main (String[] args) throws FileNotFoundException,IOException {
        File src=new File("C:/Users/Jason/Desktop/炫光力量/progress/src");
        if (!src.exists()&& !src.isDirectory()) {
            throw new FileNotFoundException("找不到目标,或者目标不是一个文件夹");
        }
        File[] files = src.listFiles();
        System.out.println(files.length);
        File tar = new File("E:/test");
        if (!tar.exists()) {
            tar.mkdir();
        }
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            String sb = file.getName();
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(new File(tar,sb));
            int len=0;
            byte[] b = new byte[1024];
            while ((len=fis.read(b))!=-1){
                fos.write(b,0,len);
            }
            fis.close();
            fos.close();
        }

    }
    public void dosomething() throws CustomerException{
        System.out.println("do something");
    }
}
