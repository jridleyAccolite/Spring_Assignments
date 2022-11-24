package com.springboot.controller;

import com.springboot.model.LogEntry;
import com.springboot.service.TimeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeLogController {

    @Autowired
    TimeLogService service;

    @GetMapping("/timelogs")
    public ResponseEntity<List<LogEntry>> getAllLogs(){
        Iterable<LogEntry> entries = service.getAllTimeLogs();

        return new ResponseEntity(entries, HttpStatus.OK);
    }
}
