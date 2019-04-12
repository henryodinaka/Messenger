package com.leo.henry.messenger.activemq.scheduler.quartz2;

import java.time.LocalDateTime;
import java.util.List;

import com.leo.henry.messenger.activemq.MessageSender;
import com.leo.henry.messenger.activemq.service.ActiveMQMonitorService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


/**
 * This class implements Quartz Job interface, anything you wish to be executed
 * by the Quartz Scheduler should be here it should invokes business class to
 * perform task.
 * 
 * @author Mary.Zheng
 *
 */
public class QuartzJob implements Job {

	private static final String LOGIN = "admin";
	private static final int MAX_PENDING_MESSAGE_SIZE_LIMIT = 10;
	private String brokerXmlUrl = "http://localhost:8161/admin/xml/queues.jsp";

	private ActiveMQMonitorService activeMqMonitorService = new ActiveMQMonitorService();

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		LocalDateTime localTime = LocalDateTime.now();
		System.out.println(Thread.currentThread().getName() + ": Run QuartzJob at " + localTime.toString());
		MessageSender.produceMessage();
		activeMqMonitorService.monitorAndNotify(brokerXmlUrl, LOGIN, LOGIN, MAX_PENDING_MESSAGE_SIZE_LIMIT);
	}
}
