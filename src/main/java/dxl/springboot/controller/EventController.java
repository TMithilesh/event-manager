package dxl.springboot.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dxl.springboot.exception.EventException;
import dxl.springboot.exception.ExceptionResponse;
import dxl.springboot.resources.Event;
import dxl.springboot.service.EventService;
@CrossOrigin("*")
@RestController
public class EventController 
{

	@Autowired
	private EventService service;
	
	
	@RequestMapping("/events")
	public List<Event> getEvents()
	{
		return service.getAllEvent();
	}
	
	@RequestMapping("/event/{id}")
	public Object getEventById(@PathVariable String id) throws EventException
	{
		
		if(!StringUtils.isNumeric(id) )
		{
			throw new EventException("event id should be in numeric");
		}
		else if(Integer.parseInt(id) < 1)
		{
			throw new EventException("event id should be greater that 0");
		}
		else
		{
			return service.getEvnetById(id);
		}
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public void addEvent(@RequestBody Event event) 
	{
		service.add(event);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
	public void deleteEvent(@PathVariable String id) 
	{
		service.delete(id);
	}
	
	

	@ExceptionHandler(EventException.class)
	public ExceptionResponse exceptionHandler (Exception exp)
	{
		ExceptionResponse exception = new ExceptionResponse();
		
		exception.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		exception.setErrorMessage(exp.getMessage());
		
		return exception;
	}
	
}
