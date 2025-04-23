import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserService {
    private static final Map<Integer, User> userDatabase = new HashMap<>();

    static {
        userDatabase.put(1,new User(1,"Abhav"));
        userDatabase.put(2,new User(2,"Bob"));
    }

    public Optional<User> findUserByInt(int id){
        return Optional.ofNullable(userDatabase.get(id));
    }
}
