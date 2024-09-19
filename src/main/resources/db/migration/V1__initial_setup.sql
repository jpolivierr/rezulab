CREATE TABLE IF NOT EXISTS users(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    password VARCHAR(60) NOT NULL,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS experiences(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    company VARCHAR(250) NOT NULL,
    job_title VARCHAR(250) NOT NULL,
    job_description TEXT NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_experiences_userId FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS resume_template(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    name VARCHAR(250) NOT NULL,
    description TEXT NOT NULL,
    sample_resume TEXT,
    job_description TEXT,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_resumeTemplate_userId FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS prompt(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    name VARCHAR(250) NOT NULL,
    context TEXT NOT NULL,
    instructions TEXT NULL,
    constraints TEXT NULL,
    scope TEXT NULL,
    audience TEXT NULL,
    examples TEXT NULL,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_prompt_userId FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS job_listings(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    job_title VARCHAR(250) NOT NULL,
    job_description TEXT NOT NULL,
    job_type VARCHAR(250) NOT NULL DEFAULT "full-time",
    date_posted TIMESTAMP NULL,
    work_setting varchar(250) DEFAULT "office",
    status VARCHAR(250) NULL,
    source VARCHAR(250) NULL,
    is_urgent boolean DEFAULT false,
	date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_jobListings_users FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
);

CREATE TABLE IF NOT EXISTS company (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    job_listing_id BIGINT NOT NULL,
    name VARCHAR(256) NOT NULL,
    about TEXT NULL,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_company_jobListing FOREIGN KEY (job_listing_id) REFERENCES job_listings(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS address(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    company_id BIGINT NULL,
    street VARCHAR(250) NULL,
    city VARCHAR(250) NOT NULL,
    state VARCHAR(50) NOT NULL,
    zip_code VARCHAR(250) NOT NULL,
	date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_address_company FOREIGN KEY (company_id) REFERENCES company(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS pay_range (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    job_listing_id BIGINT NOT NULL,
    min INT DEFAULT 0,
    max INT DEFAULT 0,
    period VARCHAR(20) NULL,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_payRange_jobListing FOREIGN KEY (job_listing_id) REFERENCES job_listings(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS contact_number(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    company_id BIGINT NULL,
    type VARCHAR(40) NULL DEFAULT "mobile",
    ext VARCHAR(40) NULL,
    number VARCHAR(20) NULL,
	date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_contactNumber_company FOREIGN KEY (company_id) REFERENCES company(id) ON DELETE CASCADE
);

