package com.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.model.Entry;

public interface SaveEntry extends JpaRepository<Entry, String>{

}
