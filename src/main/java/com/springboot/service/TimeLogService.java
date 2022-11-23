package com.springboot.service;

import com.springboot.model.LogEntry;
import com.springboot.repo.TimeLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeLogService {

    @Autowired
    TimeLogRepository repo;

    public Iterable<LogEntry> getAllTimeLogs(){

        Iterable<LogEntry> logList = repo.findAll();

        return logList;
    }
}
