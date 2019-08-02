package com.revature.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("v1")
public class RestApp extends ResourceConfig {
	public RestApp() {
		packages("com.revature.resources");
	}
}