import java.util.*;

public class Collections {
    public void collectoins() {
        
        //Arraylist : dynamic array not need to specify the size beforehand
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Spring");

        // HashSet: used to store unique elements
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("A"); // ignored

        //HashMap: used to key-value pairs
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Abhav");
        map.put(2, "Java");




    }
}
