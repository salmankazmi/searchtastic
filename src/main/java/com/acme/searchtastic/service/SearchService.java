package com.acme.searchtastic.service;

import com.acme.searchtastic.dto.SearchData;
import com.acme.searchtastic.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class SearchService {
    private SearchRepository searchRepository;

    @Autowired
    public SearchService(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    public List<String> searchNames(String query) {
        List<String> resultList = searchRepository.findCompanies(query);
        if (!resultList.isEmpty()) {
            Collections.sort(resultList);
            return resultList;
        }
        return Collections.emptyList();
    }

    public Page<SearchData> getAllSearchResults(String query, Pageable pageable) {
        return searchRepository.findByCompanyNameContainingIgnoreCase(query, pageable);
    }
}
