import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda {
    public static void main (String[] args){
        String[] arr={"Rafael Nadal","Novak Djokovic","Stanislas Wawrinka","David Ferrer","Roger Federer"};
        List<String> names = Arrays.asList(arr);
        //在java8中使用双冒号操作符
        names.forEach(System.out::println);
        //lambda表达式
        names.forEach((name)->System.out.println(name+";"));

        //排序
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1.compareTo(o2));
            }
        });
        names.forEach(System.out::println);

        //lambda排序
        Arrays.sort(arr, (String s1, String s2)->(s1.compareTo(s2)));
        names.forEach(System.out::println);


    }
}
