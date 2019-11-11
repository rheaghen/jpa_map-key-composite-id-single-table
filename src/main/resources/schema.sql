drop VIEW IF EXISTS key_value_categories;

drop TABLE IF EXISTS key_value;

CREATE TABLE key_value 
(
	id               INT             NOT NULL,
	category_id      INT             NOT NULL,
	sub_category_id  INT             NOT NULL,
   	key              VARCHAR(50)     NOT NULL, 
    value            VARCHAR(255)    NULL
);

 CREATE VIEW key_value_categories AS SELECT DISTINCT category_id,  sub_category_id FROM  KEY_VALUE;
 
 ALTER TABLE key_value ADD PRIMARY KEY (id,category_id, sub_category_id);

 