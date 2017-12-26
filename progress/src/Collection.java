import java.util.*;

public class Collection {
    /*
     * Collection
     *   |-List
     *       |-ArrayList
     *       |-LinkedList
     *       |-Vector
     *   |-Set
     *       |-HashSet
     *       |-TreeSet
     * Map
     *   |-HashTable
     *   |-HashMap
     *   |-WeakHashMap
     * */
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<String>();
        List<String> list3 = new Vector<String>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new TreeSet<>();
        set1.add(1);
        Map<String, Object> map1 = new Hashtable<String, Object>();
        Map<String, Object> map2 = new HashMap<String, Object>();
        Map<String, Object> map3 = new WeakHashMap<String, Object>();

        for (int i = 0; i < list3.size(); i++) {
            String s = list3.get(i);

        }
        for (Iterator<Integer> iterator = set2.iterator(); iterator.hasNext(); ) {
            Integer next = iterator.next();

        }
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

        }
    }
}
