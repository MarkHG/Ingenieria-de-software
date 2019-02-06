--
-- PostgreSQL database dump
--

-- Dumped from database version 10.6 (Ubuntu 10.6-0ubuntu0.18.04.1)
-- Dumped by pg_dump version 10.6 (Ubuntu 10.6-0ubuntu0.18.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: marcador; Type: TABLE; Schema: public; Owner: marco
--

CREATE TABLE public.marcador (
    idmarcador integer NOT NULL,
    descripcion text,
    longitud double precision,
    latitud double precision,
    usuarioid integer
);


ALTER TABLE public.marcador OWNER TO marco;

--
-- Name: marcador_idmarcador_seq; Type: SEQUENCE; Schema: public; Owner: marco
--

CREATE SEQUENCE public.marcador_idmarcador_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.marcador_idmarcador_seq OWNER TO marco;

--
-- Name: marcador_idmarcador_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: marco
--

ALTER SEQUENCE public.marcador_idmarcador_seq OWNED BY public.marcador.idmarcador;


--
-- Name: usuario; Type: TABLE; Schema: public; Owner: marco
--

CREATE TABLE public.usuario (
    idusuario integer NOT NULL,
    nombre text NOT NULL,
    correo text NOT NULL,
    contresenia text NOT NULL,
    fechanacimiento date NOT NULL
);


ALTER TABLE public.usuario OWNER TO marco;

--
-- Name: usuario_idusuario_seq; Type: SEQUENCE; Schema: public; Owner: marco
--

CREATE SEQUENCE public.usuario_idusuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_idusuario_seq OWNER TO marco;

--
-- Name: usuario_idusuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: marco
--

ALTER SEQUENCE public.usuario_idusuario_seq OWNED BY public.usuario.idusuario;


--
-- Name: marcador idmarcador; Type: DEFAULT; Schema: public; Owner: marco
--

ALTER TABLE ONLY public.marcador ALTER COLUMN idmarcador SET DEFAULT nextval('public.marcador_idmarcador_seq'::regclass);


--
-- Name: usuario idusuario; Type: DEFAULT; Schema: public; Owner: marco
--

ALTER TABLE ONLY public.usuario ALTER COLUMN idusuario SET DEFAULT nextval('public.usuario_idusuario_seq'::regclass);


--
-- Data for Name: marcador; Type: TABLE DATA; Schema: public; Owner: marco
--

COPY public.marcador (idmarcador, descripcion, longitud, latitud, usuarioid) FROM stdin;
\.


--
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: marco
--

COPY public.usuario (idusuario, nombre, correo, contresenia, fechanacimiento) FROM stdin;
1	marco	hola.hotmail	kk	1995-03-16
\.


--
-- Name: marcador_idmarcador_seq; Type: SEQUENCE SET; Schema: public; Owner: marco
--

SELECT pg_catalog.setval('public.marcador_idmarcador_seq', 1, false);


--
-- Name: usuario_idusuario_seq; Type: SEQUENCE SET; Schema: public; Owner: marco
--

SELECT pg_catalog.setval('public.usuario_idusuario_seq', 1, true);


--
-- Name: marcador marcador_pkey; Type: CONSTRAINT; Schema: public; Owner: marco
--

ALTER TABLE ONLY public.marcador
    ADD CONSTRAINT marcador_pkey PRIMARY KEY (idmarcador);


--
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: marco
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (idusuario);


--
-- Name: marcador marcador_usuarioid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: marco
--

ALTER TABLE ONLY public.marcador
    ADD CONSTRAINT marcador_usuarioid_fkey FOREIGN KEY (usuarioid) REFERENCES public.usuario(idusuario);


--
-- PostgreSQL database dump complete
--

