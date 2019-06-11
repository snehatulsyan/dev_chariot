package com.agiliztech.repository;

import org.springframework.stereotype.Repository;
import com.agiliztech.model.NewEvent;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface NewEventRepository extends MongoRepository<NewEvent, String> {
NewEvent findByDeviceid(String ts);
NewEvent findByTimestampHour(String ts);



}
