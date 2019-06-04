package cn.edu.fudan.selab.pojo;

import java.sql.Timestamp;

public class SimpleTask {

    private int taskId;

    private String taskDesc;

    private String locationDesc;

    private int bonus;

    private int duration;

    private int state;


    @Override
    public String toString() {
        return "SimpleTask{" +
                "taskId=" + taskId +
                ", taskDesc='" + taskDesc + '\'' +
                ", locationDesc='" + locationDesc + '\'' +
                ", bonus=" + bonus +
                ", duration=" + duration +
                ", state=" + state +
                '}';
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    public int getTaskId() {
        return taskId;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public String getLocationDesc() {
        return locationDesc;
    }

    public int getBonus() {
        return bonus;
    }

    public int getDuration() {
        return duration;
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
