import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AssistantDirector extends User{
    public AssistantDirector(String username, String password) {
        super(username, password);
    }

    // AssistantDirector 类中添加方法
    public void matchTeachersToRequirements() {
        try {
            List<TeachingRequirement> requirements = (List<TeachingRequirement>) operateData.deserialize("requirements.ser");
            List<PartTimeTeacher> teachers = (List<PartTimeTeacher>) operateData.deserialize("teachers.ser");
            Map<TeachingRequirement, List<PartTimeTeacher>> matches = new HashMap<>();

            // 简化的匹配逻辑
            for (TeachingRequirement requirement : requirements) {
                List<PartTimeTeacher> matchedTeachers = teachers.stream()
                        .filter(teacher -> teacher.getSubject().equals(requirement.getSubject()))
                        .collect(Collectors.toList());
                matches.put(requirement, matchedTeachers);
            }

            operateData.serialize(matches, "matches.ser");
            System.out.println("Matched teachers to requirements.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Failed to match teachers to requirements.");
            e.printStackTrace();
        }
    }
}
