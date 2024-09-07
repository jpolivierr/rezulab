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