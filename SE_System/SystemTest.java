import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SystemTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UserManager userManager = new UserManager();
        List<TeachingRequirement> requirements = new ArrayList<>();
        System.out.println("----------------------模拟教学需求业务流程-------------------------");
        // 模拟班主任登录并创建教学需求和教师名单
        User directorUser = userManager.loginUser("director", "director1");
        if (directorUser instanceof ClassDirector) {
            ClassDirector director = (ClassDirector) directorUser;
            requirements.add(new TeachingRequirement("Math", 2));
            List<PartTimeTeacher> teachers = new ArrayList<>();
            teachers.add(new PartTimeTeacher("Jack", "Math", "Morning"));
            teachers.add(new PartTimeTeacher("Tom", "Science", "Afternoon"));
            director.createAndSaveRequirementsAndTeachers(requirements, teachers);
        }

        // 模拟助理主任登录并匹配教师
        User assistantUser = userManager.loginUser("assistant", "assistant1");
        if (assistantUser instanceof AssistantDirector) {
            AssistantDirector assistant = (AssistantDirector) assistantUser;
            assistant.matchTeachersToRequirements();
        }

        // 模拟管理员登录并查看匹配结果并通知教师
        User adminUser = userManager.loginUser("admin", "admin1");
        if (adminUser instanceof Administrator) {
            Administrator admin = (Administrator) adminUser;
            admin.reviewMatchesAndNotifyTeachers();
        }
        // 模拟兼职教师接收教学请求
        User teacherUser = userManager.loginUser("teacher", "teacher1");
        if (teacherUser instanceof PartTimeTeacher) {
            PartTimeTeacher teacher = (PartTimeTeacher) teacherUser;
            List<TeachingRequirement> request = (List<TeachingRequirement>) operateData.deserialize("requirements.ser");
            for (TeachingRequirement teachingRequirement : request) {
                teacher.receiveTeachingRequest(teachingRequirement);
            }
            // 假设教师接受了所有请求，现在保存接受的请求
            List<TeachingRequirement> acceptedRequests = teacher.getAcceptedRequests();
            // 这里简化处理，实际应用中可能需要将接受的请求序列化存储或进行其他处理
            System.out.println("Accepted requests saved.");
        }
        System.out.println("----------------------模拟培训业务流程-------------------------");
        User adminUser2 = userManager.loginUser("admin", "admin1");
        if (adminUser2 instanceof Administrator) {
            Administrator admin = (Administrator) adminUser2;
            List<String> agreedTeachers = Arrays.asList("Jack", "Tom");
            TrainingSession session = new TrainingSession("Advanced Math", "2024-03-06", "Room A");
            admin.arrangeTraining(agreedTeachers, session);
        }


        User teacherUser2 = userManager.loginUser("teacher", "teacher1");
        if (teacherUser2 instanceof PartTimeTeacher) {
            PartTimeTeacher teacher = (PartTimeTeacher) teacherUser2;
            TrainingSession session = (TrainingSession) operateData.deserialize("trainingSession.ser");
            teacher.receiveTrainingDetails(session);
        }
    }
}
