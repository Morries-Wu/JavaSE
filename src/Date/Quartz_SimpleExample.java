package Date;

import static org.quartz.DateBuilder.evenSecondDateAfterNow;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

//quartzѧϰ����
public class Quartz_SimpleExample {

	public void run() throws Exception {
		// 1.����Scheduler�Ĺ���
		SchedulerFactory sf = new StdSchedulerFactory();
		// 2.�ӹ����л�ȡ������
		Scheduler sched = sf.getScheduler();

		// 3.����JobDetail
		JobDetail job = newJob(Syn_HelloJob.class).withIdentity("job1", "group1").build();

		// ʱ��
		Date runTime = evenSecondDateAfterNow();

		// 4.������
		Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();

		// 5.ע������ʹ�������
		sched.scheduleJob(job, trigger);

		// 6.����
		sched.start();

		try {
			// 5���ֹͣ
			Thread.sleep(5L * 1000L);
		} catch (Exception e) {
		}

		// shut down the scheduler
		sched.shutdown(true);
	}

	public static void main(String[] args) throws Exception {
		Quartz_SimpleExample example = new Quartz_SimpleExample();
		example.run();
	}

}
