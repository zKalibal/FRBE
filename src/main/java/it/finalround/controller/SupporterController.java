package it.finalround.controller;

import it.finalround.dto.SupporterDto;
import it.finalround.mapper.SupporterMapper;
import it.finalround.service.SupporterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/supporters")
@RequiredArgsConstructor
public class SupporterController {

    private final SupporterService service;
    private final SupporterMapper mapper;

    @GetMapping
    public List<SupporterDto> list(){
        return service.listAll().stream().map(mapper::toDto).toList();
    }

    @GetMapping("/top")
    public List<SupporterDto> top(){
        return service.top().stream().map(mapper::toDto).toList();
    }
}
