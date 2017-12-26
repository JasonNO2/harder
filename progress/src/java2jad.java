import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;


public class java2jad {
    public static void main(String[] args) throws Exception {
        File srcDir = new File("E:/test");
        if (!srcDir.exists() && !srcDir.isDirectory()) {
            throw new Exception("目录不存在");
        }
        //匿名内部类
        File[] files = srcDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("java");
            }
        });
        File destDir = new File("E:/test/");
        //若文件夹不存在,创建
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        for (File f : files) {
            FileInputStream fis = new FileInputStream(f);
            String destFileName = f.getName().replaceAll("\\.java$", ".jad");
            FileOutputStream fos = new FileOutputStream(new File(destDir, destFileName));
            copy(fis, fos);
            fis.close();
            fos.close();
        }
    }


    private static void copy(FileInputStream ips, FileOutputStream ops) throws Exception {
        // TODO Auto-generated method stub
        int len = 0;
        byte[] buf = new byte[1024];
        while ((len = ips.read(buf)) != -1) {
            ops.write(buf, 0, len);
        }
    }
}
