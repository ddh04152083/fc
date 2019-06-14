package com.cq.fc.service.impl;

import com.cq.fc.domain.Classified_data;
import com.cq.fc.repository.Classified_dataRepository;
import com.cq.fc.service.Classified_dataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Classified_dataServiceImpl implements Classified_dataService {
    @Autowired
    private Classified_dataRepository classified_dataclassified_dataRepository;

    @Override
    public void saveAll(List<Classified_data> list) {
        classified_dataclassified_dataRepository.saveAll(list);
    }

    @Override
    public Page<Classified_data> getAll(Integer page, Integer size) {
        Pageable pageable= PageRequest.of(page-1,size);
        return classified_dataclassified_dataRepository.findAll(pageable);
    }
}
