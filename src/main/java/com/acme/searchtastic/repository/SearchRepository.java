package com.acme.searchtastic.repository;

import com.acme.searchtastic.dto.SearchData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface SearchRepository extends PagingAndSortingRepository<SearchData, Integer> {
    public static final String FIND_COMPANIES = "SELECT company_name FROM MOCK_SEARCH_DATA where company_name LIKE " +
            "%?1% LIMIT 10";

    @Query(value = FIND_COMPANIES, nativeQuery = true)
    public List<String> findCompanies(String query);

    Page<SearchData> findByCompanyNameContainingIgnoreCase(String query, Pageable pageable);
}
