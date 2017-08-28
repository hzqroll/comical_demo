package com.roll.comical.console.business.rabbitmq;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

/**
 * Date: 2017/8/27
 *
 * @author zongqiang.hao
 */
@Service
public class AsyncExecutorService {
	private ThreadPoolExecutor executorService;
	private RejectedExecutionHandler rejectionHandler;
	private BlockingQueue<Runnable> blockingQueue;
	private int defaultCoreSize;
	private int defaultMaxSize;
	private long defaultKeepAliveTime;

	public RejectedExecutionHandler getRejectionHandler() {
		return rejectionHandler;
	}

	public void setRejectionHandler(RejectedExecutionHandler rejectionHandler) {
		this.rejectionHandler = rejectionHandler;
		executorService.setRejectedExecutionHandler(rejectionHandler);
	}

	public BlockingQueue<Runnable> getBlockingQueue() {
		return blockingQueue;
	}

	public void setBlockingQueue(BlockingQueue<Runnable> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	public ThreadPoolExecutor getExecutorService() {
		return executorService;
	}

	public void setExecutorService(ThreadPoolExecutor executorService) {
		this.executorService = executorService;
		this.defaultCoreSize = this.executorService.getCorePoolSize();
		this.defaultMaxSize = this.executorService.getMaximumPoolSize();
		this.defaultKeepAliveTime = this.executorService.getKeepAliveTime(TimeUnit.SECONDS);
	}


	public void execute(Runnable runner) {
		executorService.execute(runner);
	}

	public void resizePoolMaxSize(int maxSize) {
		this.executorService.setMaximumPoolSize(maxSize);
	}

	public void resizePoolCoreSize(int coreSize) {
		this.executorService.setMaximumPoolSize(coreSize);
	}

	public void resetPoolAliveTime(long aliveTime) {
		this.executorService.setKeepAliveTime(aliveTime, TimeUnit.SECONDS);
	}

	public void resetDefault() {
		this.executorService.setCorePoolSize(this.defaultCoreSize);
		this.executorService.setMaximumPoolSize(this.defaultMaxSize);
		this.executorService.setKeepAliveTime(this.defaultKeepAliveTime, TimeUnit.SECONDS);
	}

	@PostConstruct
	public void init() {
		//asyncExecutorService will be init !!!
	}

	@PreDestroy
	public void destroy() {
		//asyncExecutorService will be destroyed !!!
		executorService.shutdown();
	}

	public Integer getPoolMaxSize() {
		return executorService.getMaximumPoolSize();
	}
}