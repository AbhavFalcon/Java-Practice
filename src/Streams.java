import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
            public void stream(){
                List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
                List<String> result= names.stream()
                        .filter(name -> name.startsWith("A"))
                        .map(String::toUpperCase)
                        .collect(Collectors.toList());

                System.out.println(result);

//                The Conventional Way without Streams

//                List<String> result = new ArrayList<>();
//
//                for (String name : names) {
//                    if (name.startsWith("B")||name.startsWith("C")) {
//                        result.add(name.toUpperCase());
//                    }
//                }
//                System.out.println(result);
            }
}
