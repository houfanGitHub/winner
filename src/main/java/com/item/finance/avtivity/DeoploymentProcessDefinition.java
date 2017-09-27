package com.item.finance.avtivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Component;

@Component
public class DeoploymentProcessDefinition {

	/**
	 * 部署流程定义
	 * 
	 * @param processEngine
	 * @return
	 */
	public void getDeployment(ProcessEngine processEngine) {
		// 因为类和Bpmn文件在同一个目录下，所以不用getClassLoader方法
		Deployment deployment = processEngine.getRepositoryService() // 与流程定义和部署对象相关的service
				.createDeployment()// 创建一个部署对象
				.name("个人提款申请")// 添加部署的名称
				.addClasspathResource("diagrams/drawMoneyApplyFor.bpmn")// 从classpath的资源中加载，一次只能加载一个文件
				.addClasspathResource("diagrams/drawMoneyApplyFor.png")// 从classpath的资源中加载，一次只能加载一个文件
				.deploy();// 完成部署
		System.out.println("部署ID：" + deployment.getId());
		System.out.println("部署名称:" + deployment.getName());
	}

	/**
	 * 启动流程实例
	 */
	public ProcessInstance startProcessInstance(ProcessEngine processEngine,
			String memberName) {
		// 流程定义的key
		String processDefinitionKey = "drawMoney";
		// 启动流程实例的同时，设置流程变量，使用流程便令用来指定任务的办理人,对应.bpmn文件中的#{userID}
		HashMap<String, Object> variables = new HashMap<String, Object>();
		variables.put("memberID", memberName);
		ProcessInstance pi = processEngine.getRuntimeService()// 与正在执行的流程实例和执行对象相关的Service
				.startProcessInstanceByKey(processDefinitionKey, variables);// 使用流程定义的key启动流程实例，key对应HelloWorld.bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动
		System.out.println("流程实例ID:" + pi.getId());
		System.out.println("流程定义ID:" + pi.getProcessDefinitionId());
		System.out.println("流程实例ID" + pi.getProcessInstanceId());
		return pi;
	}

	/**
	 * 查询任务通过流程实例id
	 * 
	 * @return
	 */
	public String findHistoryTask(ProcessEngine processEngine, String id) {
		String processInstanceId = id;
		List<HistoricTaskInstance> list = processEngine.getHistoryService()// 与历史数据（历史表）相关的Service
				.createHistoricTaskInstanceQuery()// 创建历史任务实例查询
				.processInstanceId(processInstanceId)//
				.orderByHistoricTaskInstanceStartTime().asc().list();
		if (list != null && list.size() > 0) {
			for (HistoricTaskInstance hti : list) {
				System.out.println(hti.getId() + "    " + hti.getName()
						+ "    " + hti.getProcessInstanceId() + "   "
						+ hti.getStartTime() + "   " + hti.getEndTime() + "   "
						+ hti.getDurationInMillis());
				System.out.println("################################");
				return hti.getId();
			}
		}
		return null;
	}

	/** 设置流程变量 */
	public void setProcessVariables(ProcessEngine processEngine, String id,
			String memberName, String withdrawAmount, String bankCard) {
		String taskId = id;// 流程实例ID
		TaskService taskService = processEngine.getTaskService();// 获取任务的Service，设置和获取流程变量

		System.out.println("taskId >>>" + taskId);
		// 设置流程变量【基本类型】
		taskService.setVariable(taskId, "bankCard", bankCard);
		taskService.setVariable(taskId, "withdrawAmount", withdrawAmount);
		System.out.println("设置流程变量成功！");
		// 完成我任务
		processEngine.getTaskService().complete(taskId);
		System.out.println("申请完成！");
	}

	/**
	 * 获取流程变量
	 * 
	 * @return
	 */
	public List<Map<String, String>> getProcessVariables(
			ProcessEngine processEngine, List<String> listId) {

		List<Map<String, String>> listString = new ArrayList<>();

		for (int i = 0; i < listId.size(); i++) { // 流程实例ID
			String processInstanceId = listId.get(i);
			System.out.println("获取流程变量：processInstanceId = "
					+ processInstanceId);
			List<HistoricVariableInstance> list = processEngine
					.getHistoryService().createHistoricVariableInstanceQuery()
					.processInstanceId(processInstanceId).list();
			if (list != null && list.size() > 0) {
				Map<String, String> map = new HashMap<>();
				for (HistoricVariableInstance hvi : list) {
					System.out.println("获取流程变量");
					// System.out.println(hvi.getId()+"    "+hvi.getVariableName()+"   "+hvi.getValue());
					map.put(hvi.getVariableName(), (String) hvi.getValue());
				}
				map.put("processInstanceId", processInstanceId);
				listString.add(map);
			}

		}
		return listString;
	}

	/**
	 * 获取流程定义的文件资源 查看流程图
	 */
	public ProcessDefinition viewPic(ProcessEngine processEngine, String taskId)
			throws IOException {
		// 1、根据流程实例id查询流程实例对象
		ProcessInstance processInstance = processEngine.getRuntimeService()
				.createProcessInstanceQuery().processInstanceId(taskId)
				.singleResult();
		// 2、根据流程实例对象查询流程定义id
		String processDefinitionId = processInstance.getProcessDefinitionId();
		// 3、根据流程定义id查询流程定义对象
		ProcessDefinition processDefinition = processEngine
				.getRepositoryService().createProcessDefinitionQuery()
				.processDefinitionId(processDefinitionId).singleResult();

		return processDefinition;
	}
	
	/**
	 * 二：查看当前活动，获取当期活动对应的坐标x,y,width,height，将4个值存放到Map<String,Object>中
		 map集合的key：表示坐标x,y,width,height
		 map集合的value：表示坐标对应的值
	 */
	public Map<String, Object> findCoordingByTask(ProcessEngine processEngine, String processInstanceId) {
		//存放坐标
		Map<String, Object> map = new HashMap<String,Object>();
		//使用流程实例ID，查询正在执行的执行对象表，获取当前活动对应的流程实例对象
		ProcessInstance pi = processEngine.getRuntimeService().createProcessInstanceQuery()//创建流程实例查询
					.processInstanceId(processInstanceId)//使用流程实例ID查询
					.singleResult();
		//获取当前活动的ID
		String activityId = pi.getActivityId();
		//获取当前活动对象
		String processDefinitionId = processEngine.getHistoryService()  
		            .createHistoricProcessInstanceQuery()  
		            .processInstanceId(processInstanceId)  
		            .singleResult().getProcessDefinitionId();
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity)processEngine
														.getRepositoryService()
														.getProcessDefinition(processDefinitionId);
		ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId);//活动ID
		//获取坐标
		map.put("x", activityImpl.getX());
		map.put("y", activityImpl.getY());
		map.put("width", activityImpl.getWidth());
		map.put("height", activityImpl.getHeight());
		return map;
	}

	/**
	 * 历史任务查询 (已完成的)
	 * 
	 * @return
	 */
	public List<String> historyTaskList(ProcessEngine processEngine,
			String memberName) {
		List<HistoricTaskInstance> list = processEngine.getHistoryService() // 历史任务Service
				.createHistoricTaskInstanceQuery() // 创建历史任务实例查询
				.taskAssignee(memberName) // 指定办理人
				.finished() // 查询已完成的任务
				.list();
		List<String> list2 = new ArrayList<>();
		for (HistoricTaskInstance hti : list) {
			System.out.println("任务ID:hti.getId()" + hti.getId());
			System.out.println("流程实例ID:hti.getProcessInstanceId()"
					+ hti.getProcessInstanceId());
			list2.add(hti.getProcessInstanceId());
			System.out.println("班里人：hti.getAssignee()" + hti.getAssignee());
			System.out
					.println("创建时间：hti.getCreateTime()" + hti.getCreateTime());
			System.out.println("结束时间：hti.getEndTime()" + hti.getEndTime());
			System.out.println("===========================");
		}
		System.out.println("历史任务查询 (已完成的)List<ProcessInstanceId>.size() = "
				+ list2.size());
		return list2;
	}
	
	/**
	 * 历史任务查询 (未完成的)
	 * 
	 * @return
	 */
	public List<String> historyTaskListUnfinished(ProcessEngine processEngine,
			String memberName) {
		List<HistoricTaskInstance> list = processEngine.getHistoryService() // 历史任务Service
				.createHistoricTaskInstanceQuery() // 创建历史任务实例查询
				.taskAssignee(memberName) // 指定办理人
				.unfinished() // 查询已完成的任务
				.list();
		List<String> list2 = new ArrayList<>();
		for (HistoricTaskInstance hti : list) {
			System.out.println("任务ID:hti.getId()" + hti.getId());
			System.out.println("流程实例ID:hti.getProcessInstanceId()"
					+ hti.getProcessInstanceId());
			list2.add(hti.getProcessInstanceId());
			System.out.println("班里人：hti.getAssignee()" + hti.getAssignee());
			System.out
					.println("创建时间：hti.getCreateTime()" + hti.getCreateTime());
			System.out.println("结束时间：hti.getEndTime()" + hti.getEndTime());
			System.out.println("===========================");
		}
		System.out.println("历史任务查询 (未完成的)List<ProcessInstanceId>.size() = "
				+ list2.size());
		return list2;
	}

	/**
	 * 查询当前的个人任务
	 */
	public List<Task> findMyPersonTask(ProcessEngine processEngine, String name) {
//	public static void main(String[] args) {
//		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		String assignee = name; // TODO
		List<Task> list = processEngine.getTaskService()// 与正在执行的任务管理相关的service
				.createTaskQuery()// 创建任务查询对象
				// 查询条件
				.taskAssignee(assignee)// 指定个人任务查询，指定办理人
				// .taskCandidateGroup("")//组任务的办理人查询
				// .processDefinitionId("")//使用流程定义ID查询
				// .processInstanceId("")//使用流程实例ID查询
				// .executionId(executionId)//使用执行对象ID查询
				/** 排序 */
				.orderByTaskCreateTime().asc()// 使用创建时间的升序排列
				// 返回结果集
				// .singleResult() //返回唯一的结果集
				// .count()//返回结果集的数量
				// .listPage(firstResult, maxResults)//分页查询
				.list();// 返回列表
		System.out.println("List<Task>.size = " + list.size());
		if (list != null && list.size() > 0) {
			for (Task task : list) {
				System.out.println("任务ID：" + task.getId());
				System.out.println("任务名称:" + task.getName());
				System.out.println("任务的创建时间:" + task.getCreateTime());
				System.out.println("任务的办理人:" + task.getAssignee());
				System.out.println("流程实例ID:" + task.getProcessInstanceId());
				System.out.println("执行对象ID:" + task.getExecutionId());
				System.out.println("流程定义ID:" + task.getProcessDefinitionId());
				System.out.println("##################################################");
			}
		}
		return list;
	}
	
	/**
	 * 完成我的任务
	 */
	

	/**
	 * 查询流程状态（判断流程正在执行，还是结束）
	 */
	public void isProcessEnd(ProcessEngine processEngine, String id) {
		String processInstanceId = id;
		ProcessInstance pi = processEngine.getRuntimeService()// 表示正在执行的流程实例和执行对象
				.createProcessInstanceQuery()// 创建流程实例查询
				.processInstanceId(processInstanceId)// 使用流程实例ID查询
				.singleResult();

		if (pi == null) {
			System.out.println("流程已经结束");
		} else {
			System.out.println("流程没有结束");
		}

	}

}
