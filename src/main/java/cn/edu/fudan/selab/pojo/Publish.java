package cn.edu.fudan.selab.pojo;


import java.sql.Timestamp;

public class Publish {

    private int publishId;

    private int taskId;

    private int publisherId;

    private String callbackUrl;

    private Timestamp publishTime;

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    public Timestamp getPublishTime() {
        return publishTime;
    }

    private SimpleTask simpleTask;

    @Override
    public String toString() {
        return "Publish{" +
                "publishId=" + publishId +
                ", taskId=" + taskId +
                ", publisherId=" + publisherId +
                ", callbackUrl='" + callbackUrl + '\'' +
                ", publishTime=" + publishTime +
                ", simpleTask=" + simpleTask.toString() +
                '}';
    }

    public SimpleTask getSimpleTask() {
        return simpleTask;
    }

    public void setSimpleTask(SimpleTask simpleTask) {
        this.simpleTask = simpleTask;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public int getTaskId() {
        return taskId;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public int getPublishId() {
        return publishId;
    }

    public void setPublishId(int publishId) {
        this.publishId = publishId;
    }
}
