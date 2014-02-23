CREATE TABLE offers (
    id bigint NOT NULL,
    offerType character varying(255),
    offerCity character varying(255),
    offerZone character varying(255),
    status character varying(255)
    
);

ALTER TABLE public.offers OWNER TO postgres;


ALTER TABLE ONLY offers
    ADD CONSTRAINT offers_pkey PRIMARY KEY (id);

INSERT INTO offers(id, offerType, offerCity, offerZone, status) VALUES (1, 'apartament', 'Timisoara', 'Soarelui', 'liber');
INSERT INTO offers(id, offerType, offerCity, offerZone, status) VALUES (2, 'garsoniera', 'Baia Mare', 'Garii', 'liber');
INSERT INTO offers(id, offerType, offerCity, offerZone, status) VALUES (3, 'casa', 'Arad', 'Micalaca', 'vandut');
INSERT INTO offers(id, offerType, offerCity, offerZone, status) VALUES (4, 'vila', 'Oradea', 'Puiului', 'liber');