package dxl.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dxl.springboot.resources.Event;

@Service
public class EventService 
{
	
	@Autowired
	private EvnetRepository eventRepository;
	
	public List<Event> getAllEvent()
	{
		List<Event>  events= new ArrayList<Event>();
		
		eventRepository.findAll().forEach(events::add);
		return events;
	}
	
	public void add(Event event)
	{
		eventRepository.save(event);
	}
	
	public void delete (String id)
	{
		eventRepository.delete(id);
	}
	
	public Event getEvnetById (String id)
	{
		System.out.println("herrreee");
		return eventRepository.findOne(id);
	}
	
}
