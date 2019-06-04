package cn.edu.fudan.selab.pojo;


import java.sql.Timestamp;

public class Accept {

    private int acceptId;

    private int taskId;

    private int workerId;

    private Timestamp acceptTime;

    private Publish publish;

    @Override
    public String toString() {
        return "Accept{" +
                "acceptId=" + acceptId +
                ", taskId=" + taskId +
                ", workerId=" + workerId +
                ", acceptTime=" + acceptTime +
                ", publish=" + publish.toString() +
                '}';
    }

    public void setPublish(Publish publish) {
        this.publish = publish;
    }

    public Publish getPublish() {
        return publish;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public void setAcceptTime(Timestamp acceptTime) {
        this.acceptTime = acceptTime;
    }

    public int getTaskId() {
        return taskId;
    }

    public int getWorkerId() {
        return workerId;
    }

    public Timestamp getAcceptTime() {
        return acceptTime;
    }

    public int getAcceptId() {
        return acceptId;
    }

    public void setAcceptId(int acceptId) {
        this.acceptId = acceptId;
    }
}
