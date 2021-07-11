package com.estock.cloudconfigserver;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class CloudConfigServerApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(CloudConfigServerApplication.class, args);
		 // Local address
		try {
			System.out.println("Loacal Address 1: "+InetAddress.getLocalHost().getHostAddress());
			System.out.println("Loacal Address 1:"+InetAddress.getLocalHost().getHostName());
		    
		    // Remote address
			System.out.println("Remote Address 1:"+InetAddress.getLoopbackAddress().getHostAddress());
			System.out.println("Remote Address 2:"+InetAddress.getLoopbackAddress().getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
