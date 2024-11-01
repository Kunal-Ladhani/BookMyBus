package com.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.exception.BusException;
import com.flight.exception.TravelException;
import com.flight.model.Bus;
import com.flight.service.BusService;

@RestController
@CrossOrigin(origins = "*")
public class BusController {
	
	@Autowired
	private BusService bService;
	
	@GetMapping("/busesAll")
	public ResponseEntity<List<Bus>> serchTravle() throws TravelException, BusException{
		
		List<Bus> busList=bService.getAllBusFromAllAgency();
	
		return new ResponseEntity<>(busList,HttpStatus.CREATED);
	
	}
	
	@PostMapping("/busesAdd/{travelId}/{authKey}")
	public ResponseEntity<Bus> addTravle(@RequestBody Bus bus,@PathVariable("travelId") Integer travelId,@PathVariable("authKey") String authKey) throws TravelException{
		
		Bus buses=bService.addBus(bus, travelId, authKey);
	
		return new ResponseEntity<>(buses,HttpStatus.CREATED);
	
	}

}
