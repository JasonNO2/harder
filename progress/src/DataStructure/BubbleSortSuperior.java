package DataStructure;

import java.util.Comparator;

/**
 * @Author:Jason
 * @Description: 排序器接口(策略模式：将算法封装到具有共同接口的独立的类中使他们可以相互替换)
 * @Date:Created in 14:17 2017/12/27
 * @Modified By:
 */
public interface BubbleSortSuperior {
    /**
     *排序
     *@param list 待排序的数组
     **/
    public <T extends Comparable<T>> void sort(T[] list);

    /**
     * 排序
     *
     * @param list 待排序的数组
     * @param comp 比较两个对象的比较器
     **/
    public <T> void sort(T[] list, Comparator<T> comp);
}
