package org.jason.serviceImpl;

import org.jason.mapper.PeopleMapper;
import org.jason.model.People;
import org.jason.service.PeopleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {
    @Resource
    PeopleMapper peopleMapper;
    @Override
    public List<People> findAll() {
        return peopleMapper.findAll();
    }
}
