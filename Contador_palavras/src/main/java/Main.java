import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> stringList=new ArrayList<>(List.of("banana","pera","frango","banana","guarana","chocolate","açai"));


        Map<String, Integer> list2 = new HashMap<>();

        for (String s : stringList) {
            list2.put(s, list2.getOrDefault(s, 0) + 1);
        }

        Set<String> treeSet=new TreeSet<>(stringList);
        System.out.println(stringList);
        System.out.println(treeSet);
        System.out.println(list2);

    }
}
