package cn.edu.fudan.selab.DAO;

import cn.edu.fudan.selab.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AcceptDAO {

    /**
     * accept a task published before
     * @param accept
     * @return int
     * @create 2019-03-18 10:54
     **/
    int addAcceptSimpleTask(Accept accept);

    /**
     * query task accepted by taskId
     * @param taskId
     * @return com.selab.simplecrowd.pojo.Accept
     * @create 2019-03-18 09:47
     **/
    Accept queryAcceptedSimpleTaskByTaskId(@Param("taskId")int taskId);

    /**
     * query tasks accepted which are published by one person
     * @param publiserId
     * @return java.util.List<com.selab.simplecrowd.pojo.Accept>
     * @create 2019-03-18 09:47
     **/
    List<Accept> listAcceptedSimpleTaskByUserId(@Param("publiserId")int publiserId);

    /**
     * query tasks accepted by one person
     * @param workerId
     * @return java.util.List<com.selab.simplecrowd.pojo.Accept>
     * @create 2019-03-18 09:47
     **/
    List<Accept> listAcceptedSimpleTaskByWorkerId(@Param("workerId")int workerId);

    /**
     * delete the accepted task
     * @param taskId
     * @return int
     * @create  20:36
     **/
    int deleteAcceptedSimpleTask(@Param("taskId")int taskId);
}
