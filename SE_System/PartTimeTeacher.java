import java.util.ArrayList;
import java.util.List;

public class PartTimeTeacher extends User{
    private String name;
    private String subject;
    private String workTime;
    private List<TeachingRequirement> acceptedRequests = new ArrayList<>();
    public PartTimeTeacher(String name, String subject, String workTime) {
        this.name = name;
        this.subject = subject;
        this.workTime = workTime;
    }

    public PartTimeTeacher(String username, String password) {
        super(username, password);
    }

    public void receiveTrainingDetails(TrainingSession session) {
        System.out.println("Received training plan: Subject - " + session.getSubject() + ", Date - " + session.getDate() + ", Location - " + session.getLocation());
    }
    public void receiveTeachingRequest(TeachingRequirement request) {
        System.out.println("Received teaching request: Subject - " + request.getSubject() + ", Details - " + request.getSubject());
        // 这里简化处理，实际应用中可能需要用户输入来决定接受或拒绝
        boolean accept = true; // 假设教师接受请求
        if (accept) {
            acceptedRequests.add(request);
            System.out.println("Accepted teaching request: " + request.getSubject());
        } else {
            System.out.println("Declined teaching request: " + request.getSubject());
        }
    }

    public List<TeachingRequirement> getAcceptedRequests() {
        return acceptedRequests;
    }
    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 设置
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * 获取
     * @return workTime
     */
    public String getWorkTime() {
        return workTime;
    }

    /**
     * 设置
     * @param workTime
     */
    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String toString() {
        return "PartTimeTeacher{name = " + name + ", subject = " + subject + ", workTime = " + workTime + "}";
    }
}
