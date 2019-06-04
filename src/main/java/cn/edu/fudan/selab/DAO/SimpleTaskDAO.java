package cn.edu.fudan.selab.DAO;


import cn.edu.fudan.selab.pojo.SimpleTask;
import org.apache.ibatis.annotations.Param;

public interface SimpleTaskDAO {

    /**
     * add a new task in the table simpletask, then publish, accept and complete use this task's reference
     * @param taskDesc
     * @param locationDesc
     * @param bonus
     * @param duration
     * @return int
     * @create 2019-03-15 09:28
     **/
//    int addSimpleTask(@Param("taskDesc")String taskDesc, @Param("locationDesc")String locationDesc,
//                          @Param("bonus")int bonus, @Param("duration")int duration);


    /**
     * add a new task in the table simpletask, then publish, accept and complete use this task's reference
     * @param simpleTask
     * @return int
     * @create 2019-03-18 15:36
     **/

//    用对象变量作为参数的时候不能加@Param注解，不然会得不到对象里面的property作为真正的sql执行参数
    int addSimpleTask(SimpleTask simpleTask);

    /**
     * delete a task by taskId, be cautious when deleting, pay attention to the other three tables
     * @param taskId
     * @return int
     * @create 2019-03-15 09:38
     **/
    int deleteSimpleTask(@Param("taskId")int taskId);

    /**
     * when the task is accepted or completed, update this task's state
     * @param taskId
     * @param state
     * @return int
     * @create 2019-03-15 10:01
     **/
    int updateSimpleTaskState(@Param("taskId")int taskId, @Param("state")int state);

    /**
     * query
     * @param taskId
     * @return com.selab.simplecrowd.pojo.SimpleTask
     * @create 2019-03-19 14:59
     **/
    SimpleTask querySimpleTaskByTaskId(@Param("taskId")int taskId);

}
