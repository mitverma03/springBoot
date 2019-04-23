package com.restAPI.resources;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.restAPI.model.User;

@Path("/user")
public class UserResource {

	private static Map<String, User> database = new HashMap<String, User>();

	@POST
	@Consumes("application/json")
	@Path("/add")
	public Response addUser(User user){
		database.put(user.getUserId(), user);
		return Response.status(201).build();
	}
	
	@GET
	@Produces("application/json")
	@Path("/{id}")
	public Response getUser(@PathParam(value = "id") String userId){
		if(userId != null && !userId.isEmpty()){
			return Response.status(400).build();
		}
		User user = database.get(userId);
		return Response.status(200).entity(user).build();
	}
	
	@GET
	@Produces("application/json")
	public Response getAllUser(){
		return Response.status(200).entity(database).build();
	}
	
	@DELETE
	@Path("/delete/{id}")
	public Response deleteUser(@PathParam("id") String userId){
		database.remove(userId);
		return Response.status(200).build();
	}
	
	
}
