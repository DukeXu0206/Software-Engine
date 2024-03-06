import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Administrator extends User{
    public Administrator(String username, String password) {
        super(username, password);
    }

    // Administrator 类中添加方法
    public void reviewMatchesAndNotifyTeachers() {
        try {
            Map<TeachingRequirement, List<PartTimeTeacher>> matches =
                    (Map<TeachingRequirement, List<PartTimeTeacher>>) operateData.deserialize("matches.ser");
            for (Map.Entry<TeachingRequirement, List<PartTimeTeacher>> entry : matches.entrySet()) {
                TeachingRequirement requirement = entry.getKey();
                List<PartTimeTeacher> matchedTeachers = entry.getValue();

                System.out.println("Requirement: " + requirement.getSubject() + ", Needed: " + requirement.getNeededTeachers());
                System.out.println("Matched Teachers: ");
                for (PartTimeTeacher teacher : matchedTeachers) {
                    System.out.println(teacher.getName() + " - " + teacher.getSubject() + " - " + teacher.getWorkTime());
                    // 发送通知，这里简化为控制台输出
                    System.out.println("Notifying " + teacher.getName() + " about teaching opportunity.");
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Failed to review matches or notify teachers.");
            e.printStackTrace();
        }
    }

    public void arrangeTraining(List<String> agreedTeachers, TrainingSession session) {
        try {
            operateData.serialize(session, "trainingSession.ser");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Arranging training for agreed teachers...");
        agreedTeachers.forEach(teacher -> {
            System.out.println("Training arranged for: " + teacher);
            // 发送培训的具体信息给教师，这里简化为控制台输出
            System.out.println("Training details: Subject - " + session.getSubject() + ", Date - " + session.getDate() + ", Location - " + session.getLocation());
        });
    }
}
