package com.acme.searchtastic.service;

import com.acme.searchtastic.dto.SearchData;
import com.acme.searchtastic.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    private SearchRepository searchRepository;

    @Autowired
    public SearchService(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    public List<Object> searchNames(String query) {
        return searchRepository.findCompanies(query);
    }

    public Page<SearchData> getAllSearchResults(String query, Pageable pageable) {
        return searchRepository.findByCompanyNameContainingIgnoreCase(query, pageable);
    }
}
