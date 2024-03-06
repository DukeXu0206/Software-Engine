import java.io.IOException;
import java.util.List;

public class ClassDirector extends User{
    public ClassDirector(String username, String password) {
        super(username, password);
    }
    // ClassDirector 类中添加方法
    public void createAndSaveRequirementsAndTeachers(List<TeachingRequirement> requirements, List<PartTimeTeacher> teachers) {
        try {
            operateData.serialize(requirements, "requirements.ser");
            operateData.serialize(teachers, "teachers.ser");
            System.out.println("Requirements and teachers saved.");
        } catch (IOException e) {
            System.out.println("Failed to save requirements and teachers.");
            e.printStackTrace();
        }
    }
}
