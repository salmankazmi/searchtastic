package com.acme.searchtastic.repository;

import com.acme.searchtastic.dto.SearchData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class SearchDao {
    public static final String TABLE_NAME = "MOCK_SEARCH_DATA";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true)
    public List<SearchData> findAll(String query) {
        return jdbcTemplate.query("SELECT * from " + TABLE_NAME +" WHERE company_name LIKE '%"+query+"%'",
                searchDataRowMapper);
    }

    RowMapper<SearchData> searchDataRowMapper = (rs, arg1) -> {
        SearchData searchData = new SearchData();

        searchData.setId(rs.getInt("id"));
        searchData.setCompanyName(rs.getString("company_name"));
        searchData.setDomain(rs.getString("domain"));
        searchData.setLocation(rs.getString("location"));
        searchData.setDate(rs.getDate("date"));
        searchData.setIpAddress(rs.getString("ip_address"));
        searchData.setEmailAddress(rs.getString("email_address"));
        searchData.setMimeType(rs.getString("mime_type"));
        searchData.setImageUrl(rs.getString("image_url"));
        searchData.setUrl(rs.getString("url"));
        return searchData;
    };
}
