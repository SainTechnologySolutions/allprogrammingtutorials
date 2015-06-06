/**
 * 
 */
package com.sts.allprogtutorials.zk.leaderelection.main;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;

import com.sts.allprogtutorials.zk.leaderelection.nodes.ProcessNode;

/**
 * @author Sain Technology Solutions
 *
 */
public class LeaderElectionLauncher {
	
	private static final Logger LOG = Logger.getLogger(LeaderElectionLauncher.class);
	
	public static void main(String[] args) throws IOException {
		
		final String zkURL = "10.127.128.56:2181";
		
		final ExecutorService service = Executors.newSingleThreadExecutor();
		
		final Future<?> status = service.submit(new ProcessNode(4, zkURL));
		
		try {
			status.get();
		} catch (InterruptedException | ExecutionException e) {
			LOG.fatal(e.getMessage(), e);
			service.shutdown();
		}
	}
}
