import java.io.*;

public class Clone {
    //禁止实例化
    private Clone(){throw new AssertionError();}

    public static <T extends Serializable> T clone(T obj) throws Exception{
        //字节数组输出流
        ByteArrayOutputStream bout=new ByteArrayOutputStream();
        //通过字节数组流创建对象输出流
        ObjectOutputStream oos=new ObjectOutputStream(bout);
        //将obj写入
        oos.writeObject(obj);
        //字节数组输入流
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        //通过字节数组输入流创建对象输入流
        ObjectInputStream ois = new ObjectInputStream(bin);
        //读取
        return (T)ois.readObject();
    }
}
