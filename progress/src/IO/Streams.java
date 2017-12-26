package IO;

import java.io.*;

public class Streams {
    public static void main (String[] args) throws IOException {
        //以字节流为导向的stream类都继承自InputStream和OutputStream
        //InputStream实现Closeable
        //OutputStream实现Closeable,Flushable
        File f = new File("src/IO/names.txt");
        InputStream inputStream = new FileInputStream(f);//-------->Extentds InputStream
        OutputStream outputStream = new FileOutputStream(f);//-------->Extentds OutputStream

        //管道输入流,主要在线程中使用,实现两个线程之间的通信.
        PipedOutputStream pipedOutputStream = new PipedOutputStream();//-------->Extentds OutputStream
        //使用管道输出流初始化一个管道输入流,连接起来
        PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);//-------->Extentds InputStream

        //把内存中的一个缓冲区作为InputStream使用.
        String str = "你好！";
        byte[] b = str.getBytes("GBK");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(b);//-------->Extentds InputStream
        int len=0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();//-------->Extentds OutputStream
        while ((len=byteArrayInputStream.read())!=-1) {
            System.out.println(byteArrayInputStream.read());
            byteArrayOutputStream.write(byteArrayInputStream.read());
        }
        String str2=byteArrayOutputStream.toString();
        System.out.println(str2);
        //序列输入流,将多个输入流连续地合并起来
        SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStream,pipedInputStream);//-------->Extentds InputStream
        //通过字节数组输入流创建对象输入流----------------->用法至default package Clone.java
        //ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);//-------->Extentds InputStream
        //通过字节数组输出流创建对象输出流
        //ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);//-------->Extentds OutputStream
        //FilterInputStream
        FilterInputStream filterInputStream = new BufferedInputStream(byteArrayInputStream);
        FilterOutputStream filterOutputStream = new BufferedOutputStream(byteArrayOutputStream);

        //*****************************************************\\
        //以字符流为导向的Stream Reader/Writer
        char[] chars=new char[10024];
        CharArrayReader charArrayReader = new CharArrayReader(chars);//---------->和ByteArrayInputStream对应,实现一个可用作字符输入流的字符缓冲区
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));//----->InputStreamReader是字节到字符的桥梁
        FileReader fileReader = new FileReader(f);
        PipedReader pipedReader = new PipedReader();
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(charArrayWriter);
        FileWriter fileWriter = new FileWriter(f);

        charArrayReader.close();
        bufferedReader.close();
        fileReader.close();
        pipedReader.close();
        charArrayWriter.close();
        bufferedWriter.close();
        fileWriter.close();
        inputStream.close();
        outputStream.close();
        pipedInputStream.close();
        pipedOutputStream.close();
        byteArrayInputStream.close();
        byteArrayOutputStream.close();
        sequenceInputStream.close();
        //objectInputStream.close();
        //objectOutputStream.close();
        filterInputStream.close();
        filterOutputStream.close();
    }
}
