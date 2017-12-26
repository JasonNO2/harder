import java.io.Serializable;

/**
 * Created by Jason on ${date}.<br >
 */
abstract class TestModel implements Serializable{
    //private static final long serialVersionUID=-9102017020286042305L;
    private String p1;
    private String p2;
    private int areaCode;
    private String prefix;
    private String lineNumber;
    public abstract String AnnoInnerClass();
    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public TestModel(String p1, String p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    //hashCode
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + areaCode;
        result = prime * result + (lineNumber == null ? 0 : lineNumber.hashCode());
        return result;
    }

    public TestModel() {
    }
    //Object中的一个方法,在垃圾回收期销毁此对象之前会调用此方法
    @Override
    protected void finalize() throws Throwable {
        System.out.println("被GC回收");
        super.finalize();
    }
}
