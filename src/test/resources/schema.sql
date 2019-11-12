drop VIEW IF EXISTS template_categories;

drop TABLE IF EXISTS template_entry;

CREATE TABLE template_entry 
(
	id          INT             NOT NULL,
	org_id      INT             NOT NULL,
	template_id INT             NOT NULL,
   	key         VARCHAR(50)     NOT NULL, 
    value       VARCHAR(255)    NULL
);

 CREATE VIEW template_categories AS SELECT DISTINCT org_id,  template_id FROM  template_entry;
 
 ALTER TABLE template_entry ADD PRIMARY KEY (id,org_id, template_id);

 