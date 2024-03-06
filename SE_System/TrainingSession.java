import java.io.Serializable;

public class TrainingSession implements Serializable {
    private String subject;
    private String date;
    private String location;

    public TrainingSession(String subject, String date, String location) {
        this.subject = subject;
        this.date = date;
        this.location = location;
    }


    public TrainingSession() {
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
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * 设置
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 获取
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    public String toString() {
        return "TrainingSession{subject = " + subject + ", date = " + date + ", location = " + location + "}";
    }
}
