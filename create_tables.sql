CREATE TABLE people (
    id bigint NOT NULL,
    fullname character varying(255),
    jobtitle character varying(255)
    
);

ALTER TABLE public.people OWNER TO postgres;


ALTER TABLE ONLY people
    ADD CONSTRAINT people_pkey PRIMARY KEY (id);

INSERT INTO people(id, fullname, jobtitle) VALUES (1, 'Ami', 'Programmer');
INSERT INTO people(id, fullname, jobtitle) VALUES (2, 'Vlad', 'Programmer');