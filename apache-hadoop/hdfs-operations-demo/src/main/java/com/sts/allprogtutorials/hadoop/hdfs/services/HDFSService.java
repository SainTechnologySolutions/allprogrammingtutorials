/**
 * 
 */
package com.sts.allprogtutorials.hadoop.hdfs.services;

import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * @author Sain Technology Solutions
 *
 */
public class HDFSService {
	
	private static HDFSService hdfsService;
	
	private final FileSystem fileSystem;
	
	private HDFSService(final String hdfsURL) throws IOException {
		
		final URI hdfsURI = URI.create(hdfsURL);
		fileSystem = FileSystem.get(hdfsURI, new Configuration());
	}
	
	public static synchronized HDFSService getInstance(final String hdfsURL) throws IOException{
		if(hdfsService == null) {
			synchronized(HDFSService.class) {
				if(hdfsService == null) {
					hdfsService = new HDFSService(hdfsURL);
				}
			}
		}
		
		return hdfsService;
	}
	
	public void saveFile(String fileName) {
		fileSystem.create(new Path(fileName), (short)1).;
	}
	
	public void saveDataToFile(String fileName) {
		fileSystem.create(new Path(fileName), (short)1).;
	}
	
	public void readFile() {
		
	}
	
	public void deleteFile() {
		
	}
	
	public void updateFile() {
		
	}
	
	public void createFile() {
		
	}
	
	public void createDir() {
		
	}
	
	public void listDir() {
		
	}
}
