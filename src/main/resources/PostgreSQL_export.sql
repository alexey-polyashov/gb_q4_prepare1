--
-- PostgreSQL database dump
--

-- Dumped from database version 10.17
-- Dumped by pg_dump version 14.1

-- Started on 2021-11-28 23:11:51

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2836 (class 1262 OID 12938)
-- Name: postgres; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'ru';


ALTER DATABASE postgres OWNER TO postgres;

\connect postgres

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2837 (class 0 OID 0)
-- Dependencies: 2836
-- Name: DATABASE postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 10 (class 2615 OID 16384)
-- Name: lesson_4; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA lesson_4;


ALTER SCHEMA lesson_4 OWNER TO postgres;

--
-- TOC entry 603 (class 1247 OID 16406)
-- Name: duration; Type: TYPE; Schema: lesson_4; Owner: postgres
--

CREATE TYPE lesson_4.duration AS ENUM (
    '60',
    '90',
    '120'
);


ALTER TYPE lesson_4.duration OWNER TO postgres;

--
-- TOC entry 2838 (class 0 OID 0)
-- Dependencies: 603
-- Name: TYPE duration; Type: COMMENT; Schema: lesson_4; Owner: postgres
--

COMMENT ON TYPE lesson_4.duration IS 'длительность фильма';


SET default_tablespace = '';

--
-- TOC entry 203 (class 1259 OID 16385)
-- Name: films; Type: TABLE; Schema: lesson_4; Owner: postgres
--

CREATE TABLE lesson_4.films (
    filmid bigint NOT NULL,
    duration lesson_4.duration NOT NULL,
    name text NOT NULL,
    describe text
);


ALTER TABLE lesson_4.films OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16435)
-- Name: films_filmid_seq; Type: SEQUENCE; Schema: lesson_4; Owner: postgres
--

ALTER TABLE lesson_4.films ALTER COLUMN filmid ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME lesson_4.films_filmid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 204 (class 1259 OID 16393)
-- Name: sessions; Type: TABLE; Schema: lesson_4; Owner: postgres
--

CREATE TABLE lesson_4.sessions (
    sessionid bigint NOT NULL,
    film bigint NOT NULL,
    date date NOT NULL,
    starttime time without time zone NOT NULL,
    price money
);


ALTER TABLE lesson_4.sessions OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16437)
-- Name: sessions_sessionid_seq; Type: SEQUENCE; Schema: lesson_4; Owner: postgres
--

ALTER TABLE lesson_4.sessions ALTER COLUMN sessionid ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME lesson_4.sessions_sessionid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 205 (class 1259 OID 16415)
-- Name: tickets; Type: TABLE; Schema: lesson_4; Owner: postgres
--

CREATE TABLE lesson_4.tickets (
    ticketid bigint NOT NULL,
    session bigint NOT NULL,
    price money NOT NULL,
    clientname text
);


ALTER TABLE lesson_4.tickets OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16439)
-- Name: tickets_ticketid_seq; Type: SEQUENCE; Schema: lesson_4; Owner: postgres
--

ALTER TABLE lesson_4.tickets ALTER COLUMN ticketid ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME lesson_4.tickets_ticketid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2825 (class 0 OID 16385)
-- Dependencies: 203
-- Data for Name: films; Type: TABLE DATA; Schema: lesson_4; Owner: postgres
--

INSERT INTO lesson_4.films (filmid, duration, name, describe) OVERRIDING SYSTEM VALUE VALUES (1, '120', 'Прометей', 'фантастика');
INSERT INTO lesson_4.films (filmid, duration, name, describe) OVERRIDING SYSTEM VALUE VALUES (2, '120', 'Шерлок Холмс', 'детектив');
INSERT INTO lesson_4.films (filmid, duration, name, describe) OVERRIDING SYSTEM VALUE VALUES (3, '90', 'Интерстеллар', 'фантастика');
INSERT INTO lesson_4.films (filmid, duration, name, describe) OVERRIDING SYSTEM VALUE VALUES (4, '90', 'Зеленая миля', 'мелодрама');


--
-- TOC entry 2826 (class 0 OID 16393)
-- Dependencies: 204
-- Data for Name: sessions; Type: TABLE DATA; Schema: lesson_4; Owner: postgres
--

INSERT INTO lesson_4.sessions (sessionid, film, date, starttime, price) OVERRIDING SYSTEM VALUE VALUES (1, 1, '2021-11-27', '08:00:00', '$200.00');
INSERT INTO lesson_4.sessions (sessionid, film, date, starttime, price) OVERRIDING SYSTEM VALUE VALUES (3, 3, '2021-11-27', '11:00:00', '$500.00');
INSERT INTO lesson_4.sessions (sessionid, film, date, starttime, price) OVERRIDING SYSTEM VALUE VALUES (4, 4, '2021-11-27', '13:00:00', '$400.00');
INSERT INTO lesson_4.sessions (sessionid, film, date, starttime, price) OVERRIDING SYSTEM VALUE VALUES (5, 1, '2021-11-27', '16:00:00', '$500.00');
INSERT INTO lesson_4.sessions (sessionid, film, date, starttime, price) OVERRIDING SYSTEM VALUE VALUES (6, 2, '2021-11-27', '18:00:00', '$600.00');
INSERT INTO lesson_4.sessions (sessionid, film, date, starttime, price) OVERRIDING SYSTEM VALUE VALUES (7, 1, '2021-11-27', '20:00:00', '$300.00');
INSERT INTO lesson_4.sessions (sessionid, film, date, starttime, price) OVERRIDING SYSTEM VALUE VALUES (2, 2, '2021-11-27', '10:20:00', '$300.00');


--
-- TOC entry 2827 (class 0 OID 16415)
-- Dependencies: 205
-- Data for Name: tickets; Type: TABLE DATA; Schema: lesson_4; Owner: postgres
--

INSERT INTO lesson_4.tickets (ticketid, session, price, clientname) OVERRIDING SYSTEM VALUE VALUES (1, 1, '$200.00', 'Петя');
INSERT INTO lesson_4.tickets (ticketid, session, price, clientname) OVERRIDING SYSTEM VALUE VALUES (2, 1, '$200.00', 'Вася');
INSERT INTO lesson_4.tickets (ticketid, session, price, clientname) OVERRIDING SYSTEM VALUE VALUES (3, 2, '$300.00', 'Федя');


--
-- TOC entry 2839 (class 0 OID 0)
-- Dependencies: 206
-- Name: films_filmid_seq; Type: SEQUENCE SET; Schema: lesson_4; Owner: postgres
--

SELECT pg_catalog.setval('lesson_4.films_filmid_seq', 4, true);


--
-- TOC entry 2840 (class 0 OID 0)
-- Dependencies: 207
-- Name: sessions_sessionid_seq; Type: SEQUENCE SET; Schema: lesson_4; Owner: postgres
--

SELECT pg_catalog.setval('lesson_4.sessions_sessionid_seq', 7, true);


--
-- TOC entry 2841 (class 0 OID 0)
-- Dependencies: 208
-- Name: tickets_ticketid_seq; Type: SEQUENCE SET; Schema: lesson_4; Owner: postgres
--

SELECT pg_catalog.setval('lesson_4.tickets_ticketid_seq', 3, true);


--
-- TOC entry 2695 (class 2606 OID 16392)
-- Name: films films_pkey; Type: CONSTRAINT; Schema: lesson_4; Owner: postgres
--

ALTER TABLE ONLY lesson_4.films
    ADD CONSTRAINT films_pkey PRIMARY KEY (filmid);


--
-- TOC entry 2698 (class 2606 OID 16397)
-- Name: sessions sessions_pkey; Type: CONSTRAINT; Schema: lesson_4; Owner: postgres
--

ALTER TABLE ONLY lesson_4.sessions
    ADD CONSTRAINT sessions_pkey PRIMARY KEY (sessionid);


--
-- TOC entry 2701 (class 2606 OID 16422)
-- Name: tickets tickets_pkey; Type: CONSTRAINT; Schema: lesson_4; Owner: postgres
--

ALTER TABLE ONLY lesson_4.tickets
    ADD CONSTRAINT tickets_pkey PRIMARY KEY (ticketid);


--
-- TOC entry 2696 (class 1259 OID 16428)
-- Name: fki_film_id; Type: INDEX; Schema: lesson_4; Owner: postgres
--

CREATE INDEX fki_film_id ON lesson_4.sessions USING btree (film);


--
-- TOC entry 2699 (class 1259 OID 16434)
-- Name: fki_session_id; Type: INDEX; Schema: lesson_4; Owner: postgres
--

CREATE INDEX fki_session_id ON lesson_4.tickets USING btree (session);


--
-- TOC entry 2702 (class 2606 OID 16423)
-- Name: sessions film_id; Type: FK CONSTRAINT; Schema: lesson_4; Owner: postgres
--

ALTER TABLE ONLY lesson_4.sessions
    ADD CONSTRAINT film_id FOREIGN KEY (film) REFERENCES lesson_4.films(filmid) NOT VALID;


--
-- TOC entry 2703 (class 2606 OID 16429)
-- Name: tickets session_id; Type: FK CONSTRAINT; Schema: lesson_4; Owner: postgres
--

ALTER TABLE ONLY lesson_4.tickets
    ADD CONSTRAINT session_id FOREIGN KEY (session) REFERENCES lesson_4.sessions(sessionid) NOT VALID;


-- Completed on 2021-11-28 23:11:51

--
-- PostgreSQL database dump complete
--

