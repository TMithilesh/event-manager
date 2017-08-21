package dxl.springboot.service;

import org.springframework.data.repository.CrudRepository;

import dxl.springboot.resources.Event;

interface EvnetRepository extends CrudRepository<Event, String>
{

}
