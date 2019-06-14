package com.cq.fc.controller;

import com.cq.fc.domain.Classified_data;
import com.cq.fc.service.Classified_dataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/data")
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@Api("Classified_dataController|Classified_dataController发布控制器")
public class Classified_dataController {
    @Autowired
    private Classified_dataService service;
    @ApiOperation(value = "获得所有数据",notes = "获得所有数据")
    @GetMapping("/listAll/{page}/{size}")
    public Page<Classified_data> getAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){


        return service.getAll(page,size);
    }
}
