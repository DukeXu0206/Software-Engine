import java.io.Serializable;

public class TeachingRequirement implements Serializable {
    private String subject;
    private int neededTeachers;


    public TeachingRequirement() {
    }

    public TeachingRequirement(String subject, int neededTeachers) {
        this.subject = subject;
        this.neededTeachers = neededTeachers;
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
     * @return neededTeachers
     */
    public int getNeededTeachers() {
        return neededTeachers;
    }

    /**
     * 设置
     * @param neededTeachers
     */
    public void setNeededTeachers(int neededTeachers) {
        this.neededTeachers = neededTeachers;
    }

    public String toString() {
        return "TeachingRequirement{subject = " + subject + ", neededTeachers = " + neededTeachers + "}";
    }
}
