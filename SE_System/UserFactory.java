import java.util.HashMap;

public class UserFactory {
    private HashMap<String, User> users = new HashMap<>();
    public static User createUser(String type, String username, String password) {
        switch (type) {
            case "ClassDirector":
                return new ClassDirector(username, password);
            case "AssistantDirector":
                return new AssistantDirector(username, password);
            case "Administrator":
                return new Administrator(username, password);
            case "PartTimeTeacher":
                return new PartTimeTeacher(username, password);
            default:
                return null;
        }
    }
}
