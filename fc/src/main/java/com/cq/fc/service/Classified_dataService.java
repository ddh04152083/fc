package com.cq.fc.service;

import com.cq.fc.domain.Classified_data;
import org.springframework.data.domain.Page;

import java.util.List;

public interface Classified_dataService {
      Page<Classified_data> getAll(Integer page, Integer size);

      void saveAll(List<Classified_data> list);
}
