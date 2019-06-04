package cn.edu.fudan.selab.pojo;

public class Process {

    private int processInstanceId;
    private int workerId;
    private String firstStep;

    @Override
    public String toString() {
        return "Process{" +
                "processInstanceId=" + processInstanceId +
                ", workerId=" + workerId +
                ", firstStep='" + firstStep + '\'' +
                '}';
    }

    public void setProcessInstanceId(int processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public void setFirstStep(String firstStep) {
        this.firstStep = firstStep;
    }

    public int getProcessInstanceId() {
        return processInstanceId;
    }

    public int getWorkerId() {
        return workerId;
    }

    public String getFirstStep() {
        return firstStep;
    }
}
