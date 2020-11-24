package com.acme.searchtastic.controller;

import com.acme.searchtastic.dto.SearchData;
import com.acme.searchtastic.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/complete")
@CrossOrigin(origins = "http://localhost:4200")
public class SearchController {

    private SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping(value="/searchNames")
    public List<String> searchNames(@RequestParam(required = true) String q) {
        if (null != q && q.length() > 0) {
            return searchService.searchNames(q);
        }
        return Collections.emptyList();
    }

    @GetMapping(value = "/search")
    public Page<SearchData> getAllSearchResults(@RequestParam(required = true) String q,
                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "size", defaultValue = "10") int size) {
        return searchService.getAllSearchResults(q, PageRequest.of(page, size));
    }
}
