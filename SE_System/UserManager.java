import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, User> users = new HashMap<>();

    public UserManager() {
        // 初始化一些用户
        users.put("director", UserFactory.createUser("ClassDirector", "director", "director1"));
        users.put("assistant", UserFactory.createUser("AssistantDirector", "assistant", "assistant1"));
        users.put("admin", UserFactory.createUser("Administrator", "admin", "admin1"));
        users.put("teacher", UserFactory.createUser("PartTimeTeacher", "teacher", "teacher1"));
    }

    public UserManager(Map<String, User> users) {
        this.users = users;
    }

    public User loginUser(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("User logged in: " + username);
            return user;
        } else {
            System.out.println("Login failed for user: " + username);
            return null;
        }
    }


    /**
     * 获取
     * @return users
     */
    public Map<String, User> getUsers() {
        return users;
    }

    /**
     * 设置
     * @param users
     */
    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public String toString() {
        return "UserManager{users = " + users + "}";
    }
}
