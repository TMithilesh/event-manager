package dxl.springboot.resources;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Event
{
	
	@Id
	private String id;
	private String name;
	private String eventOwner;
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getId() 
	{
		return id;
	}
	public void setId(String id) 
	{
		this.id = id;
	}
	public String getEventOwner() 
	{
		return eventOwner;
	}
	public void setEventOwner(String eventOwner) 
	{
		this.eventOwner = eventOwner;
	}
}
