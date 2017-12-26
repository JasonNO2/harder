import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortList {
    public static void main (String[] args){
        //第一种排序方式,实现Comparable接口重写compareTo方法
        List<StudentModel> list = new ArrayList<>();
        list.add(new StudentModel("Jason",20));
        list.add(new StudentModel("Tom",15));
        list.add(new StudentModel("Jack",13));
        list.add(new StudentModel("Lily",19));
        list.add(new StudentModel());
        Collections.sort(list);
        list.forEach(System.out::println);
        //第二种排序方式,使用Collections工具类的匿名内部类
        Collections.sort(list, new Comparator<StudentModel>() {
            @Override
            public int compare(StudentModel o1, StudentModel o2) {
                if(o1.getName()!=null&&o2.getName()!=null)
                    return o1.getName().compareTo(o2.getName());
                else
                    return 0;
            }
        });
        list.forEach(System.out::println);
    }
}
