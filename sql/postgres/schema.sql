SET default_tablespace = '';
SET default_table_access_method = heap;

DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

CREATE TABLE public.key_value (
    id bigint NOT NULL,
    category_id bigint NOT NULL,
    sub_category_id bigint NOT NULL,
    key character varying(255) NOT NULL,
    value text
);

ALTER TABLE public.key_value OWNER TO postgres;

CREATE VIEW public.key_value_categories AS
 SELECT DISTINCT key_value.category_id,
    key_value.sub_category_id
   FROM public.key_value;

ALTER TABLE public.key_value_categories OWNER TO postgres;

	 