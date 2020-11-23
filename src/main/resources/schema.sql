drop table IF EXISTS MOCK_SEARCH_DATA;

create table MOCK_SEARCH_DATA (
	id INT,
	company_name VARCHAR(50),
	domain VARCHAR(50),
	location VARCHAR(50),
	date DATE,
	ip_address VARCHAR(20),
	email_address VARCHAR(50),
	mime_type VARCHAR(50),
	image_url VARCHAR(50),
	url VARCHAR(1000)
);
