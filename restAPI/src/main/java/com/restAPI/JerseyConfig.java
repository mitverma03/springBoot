package com.restAPI;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.restAPI.resources.UserResource;

@Component
@ApplicationPath("/restAPI")
public class JerseyConfig extends ResourceConfig{

	public JerseyConfig() {
		register(UserResource.class);
	}
}
