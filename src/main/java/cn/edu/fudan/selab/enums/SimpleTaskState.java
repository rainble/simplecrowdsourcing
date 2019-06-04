package cn.edu.fudan.selab.enums;

public enum SimpleTaskState {

    PUBLISH(1, "Task publish successfully"),
    ACCEPT(2, "Task accept successfully"),
    COMPLETE(3, "Task complete successfully"),
    FAIL_PUBLISH(-1, "Task publish failed"),
    FAIL_ACCEPT(-2, "Task accept failed"),
    FAIL_COMPLETE(-3, "Task complete failed");

    private int state;
    private String stateDesc;

    private SimpleTaskState(int state, String stateDesc) {
        this.state = state;
        this.stateDesc = stateDesc;
    }

    public int getState() {
        return state;
    }

    public String getStateDesc() {
        return stateDesc;
    }

    @Override
    public String toString() {
        return "state is " + state + "; and state describe is " + stateDesc;
    }
}
