DROP TABLE IF EXISTS CONTENT;
CREATE TABLE IF NOT EXISTS CONTENT (
    id INTEGER AUTO_INCREMENT,
    title varchar(255) not null,
    desc text,
    status varchar(20) not null,
    content_type varchar(20) not null,
    date_created TIMESTAMP Not NULL,
    date_updated TIMESTAMP,
    url varchar(255),
    primary key (id)
);

--INSERT INTO Content(title, desc, status,content_type,date_created, date_updated)
--VALUES ('first post', 'this is a post', 'IDEA', 'Article', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)