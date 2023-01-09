package com.application.service;

import java.util.Optional;

import com.application.model.Entry;
import com.application.repository.SaveEntry;

public class EntryServiceImp implements EntryService{

	SaveEntry entryDao;
	
	@Override
	public String addEntry(Entry entry) {
		String result = "";
		Optional<Entry> opt = entryDao.findById(entry.getApi());
		
		if(opt.isPresent()) {
			result= "Same Entry already present";
		}
		else {
			entryDao.save(entry);
			result= "Entry save successfully";
		}
		return result;
	}

}
