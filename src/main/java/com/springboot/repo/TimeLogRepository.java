package com.springboot.repo;

import com.springboot.model.LogEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeLogRepository extends CrudRepository<LogEntry,Integer> {
    @Override
    <S extends LogEntry> S save(S entity);
}
