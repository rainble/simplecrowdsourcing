package cn.edu.fudan.selab.pojo;


import java.sql.Timestamp;

public class Complete {

    private int completeId;

    private int taskId;

    private Timestamp completeTime;

    private Accept accept;

    @Override
    public String toString() {
        return "Complete{" +
                "completeId=" + completeId +
                ", taskId=" + taskId +
                ", completeTime=" + completeTime +
                ", accept=" + accept +
                '}';
    }

    public int getTaskId() {
        return taskId;
    }

    public Timestamp getCompleteTime() {
        return completeTime;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setCompleteTime(Timestamp completeTime) {
        this.completeTime = completeTime;
    }

    public Accept getAccept() {
        return accept;
    }

    public void setAccept(Accept accept) {
        this.accept = accept;
    }

    public int getCompleteId() {
        return completeId;
    }

    public void setCompleteId(int completeId) {
        this.completeId = completeId;
    }
}
