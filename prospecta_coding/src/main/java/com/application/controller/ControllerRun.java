package com.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.application.dto.ResultDataDTO;
import com.application.model.Entry;
import com.application.model.ResultData;
import com.application.service.EntryService;

@RestController
public class ControllerRun {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	EntryService entryService;

	@GetMapping("/entries/{category}")
	public List<ResultDataDTO> getEntriesData(@PathVariable("category") String category){
		
		ResultData rd =  restTemplate.getForObject("https://api.publicapis.org/entries", ResultData.class);
		
		List<Entry> allEntries= rd.getEntries();
		
		List<ResultDataDTO> resultList = new ArrayList<>();
		
		for(Entry entry:allEntries) {
			String[] cat =entry.getCategory().split(" ");
			
			if(cat[0].equals(category)) {
				resultList.add(new ResultDataDTO(entry.getApi(), entry.getDescription()));
			}
			
		}
		return resultList;
	}
	
	@PostMapping("/entries")
	public Entry saveEntry(@RequestBody Entry entry) {
		
		ResultData rd =  restTemplate.getForObject("https://api.publicapis.org/entries", ResultData.class);
		
		List<Entry> allEntries= rd.getEntries();
		
		allEntries.add(entry);
		
		for(Entry en:allEntries) {
			
			entryService.addEntry(en);
		}
		
		return entry;
			
	}
}
