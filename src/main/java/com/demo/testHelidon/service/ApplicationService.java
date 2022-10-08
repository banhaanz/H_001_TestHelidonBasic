package com.demo.testHelidon.service;

import com.demo.testHelidon.entity.TbMApplicationType;
import com.demo.testHelidon.repository.TbMApplicationTypeRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ApplicationService {
    private final TbMApplicationTypeRepository tbMApplicationTypeRepository;

    @Inject
    public ApplicationService(TbMApplicationTypeRepository repository){
        this.tbMApplicationTypeRepository = repository;
    }

    public List<TbMApplicationType> getAllAirports() {
        return tbMApplicationTypeRepository.getAllData();
    }
}
