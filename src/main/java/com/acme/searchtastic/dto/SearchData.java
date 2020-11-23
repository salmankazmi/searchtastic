package com.acme.searchtastic.dto;
/*
id INT,
company_name VARCHAR(50),
domain VARCHAR(50),
location VARCHAR(50),
date DATE,
ip_address VARCHAR(20),
email_address VARCHAR(50),
mime_type VARCHAR(50),
image_url VARCHAR(50),
url VARCHAR(1000)*/

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= SearchData.TABLE_NAME)
public class SearchData {
    public static final String TABLE_NAME= "MOCK_SEARCH_DATA";
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String companyName;
    private String domain;
    private String location;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String ipAddress;
    private String emailAddress;
    private String mimeType;
    private String imageUrl;
    private String url;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "SearchData{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", domain='" + domain + '\'' +
                ", location='" + location + '\'' +
                ", date=" + date +
                ", ipAddress='" + ipAddress + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
