--
-- PostgreSQL database dump
--

-- Dumped from database version 14.18 (Homebrew)
-- Dumped by pg_dump version 14.18 (Homebrew)

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: cart; Type: TABLE; Schema: public; Owner: raghavprasad
--

CREATE TABLE public.cart (
    cart_name character varying(255) NOT NULL,
    description character varying(255),
    admin_user character varying(255) NOT NULL
);


ALTER TABLE public.cart OWNER TO raghavprasad;

--
-- Name: cart_items; Type: TABLE; Schema: public; Owner: raghavprasad
--

CREATE TABLE public.cart_items (
    id integer NOT NULL,
    created_at timestamp(6) without time zone,
    quantity integer,
    cart_name character varying(255) NOT NULL,
    item_name character varying(255) NOT NULL,
    user_name character varying(255) NOT NULL
);


ALTER TABLE public.cart_items OWNER TO raghavprasad;

--
-- Name: cart_seq; Type: SEQUENCE; Schema: public; Owner: raghavprasad
--

CREATE SEQUENCE public.cart_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cart_seq OWNER TO raghavprasad;

--
-- Name: items; Type: TABLE; Schema: public; Owner: raghavprasad
--

CREATE TABLE public.items (
    item_name character varying(255) NOT NULL,
    category character varying(255),
    full_name character varying(255),
    created_at timestamp(6) without time zone
);


ALTER TABLE public.items OWNER TO raghavprasad;

--
-- Name: items_seq; Type: SEQUENCE; Schema: public; Owner: raghavprasad
--

CREATE SEQUENCE public.items_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.items_seq OWNER TO raghavprasad;

--
-- Name: user_seq; Type: SEQUENCE; Schema: public; Owner: raghavprasad
--

CREATE SEQUENCE public.user_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_seq OWNER TO raghavprasad;

--
-- Name: users; Type: TABLE; Schema: public; Owner: raghavprasad
--

CREATE TABLE public.users (
    user_name character varying(255) NOT NULL,
    created_at timestamp(6) without time zone,
    full_name character varying(255),
    type character varying(255) DEFAULT 'Admin'::character varying
);


ALTER TABLE public.users OWNER TO raghavprasad;

--
-- Data for Name: cart; Type: TABLE DATA; Schema: public; Owner: raghavprasad
--

COPY public.cart (cart_name, description, admin_user) FROM stdin;
cart1	Description 1	user1
cart2	Description 2	user2
cart3	Description 3	user3
cart4	Description 4	user4
cart5	Description 5	user5
cart6	Description 6	user6
cart7	Description 7	user7
cart8	Description 8	user8
cart9	Description 9	user9
cart10	Description 10	user10
\.


--
-- Data for Name: cart_items; Type: TABLE DATA; Schema: public; Owner: raghavprasad
--

COPY public.cart_items (id, created_at, quantity, cart_name, item_name, user_name) FROM stdin;
1	2025-06-05 13:36:30.014713	1	cart2	item3	user1
2	2025-06-05 13:36:30.014713	1	cart7	item8	user2
3	2025-06-05 13:36:30.014713	1	cart6	item8	user5
4	2025-06-05 13:36:30.014713	2	cart9	item7	user3
5	2025-06-05 13:36:30.014713	3	cart5	item9	user7
6	2025-06-05 13:36:30.014713	4	cart7	item10	user4
7	2025-06-05 13:36:30.014713	5	cart1	item4	user6
8	2025-06-05 13:36:30.014713	5	cart7	item9	user9
9	2025-06-05 13:36:30.014713	1	cart4	item5	user6
10	2025-06-05 13:36:30.014713	1	cart8	item7	user4
\.


--
-- Data for Name: items; Type: TABLE DATA; Schema: public; Owner: raghavprasad
--

COPY public.items (item_name, category, full_name, created_at) FROM stdin;
item1	Category C	Item Full Name 1	2025-06-05 13:36:04.432491
item2	Category C	Item Full Name 2	2025-06-05 13:36:04.432491
item3	Category A	Item Full Name 3	2025-06-05 13:36:04.432491
item4	Category B	Item Full Name 4	2025-06-05 13:36:04.432491
item5	Category C	Item Full Name 5	2025-06-05 13:36:04.432491
item6	Category B	Item Full Name 6	2025-06-05 13:36:04.432491
item7	Category A	Item Full Name 7	2025-06-05 13:36:04.432491
item8	Category C	Item Full Name 8	2025-06-05 13:36:04.432491
item9	Category A	Item Full Name 9	2025-06-05 13:36:04.432491
item10	Category B	Item Full Name 10	2025-06-05 13:36:04.432491
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: raghavprasad
--

COPY public.users (user_name, created_at, full_name, type) FROM stdin;
user1	2025-06-05 13:34:24.844585	Full Name 1	\N
user2	2025-06-05 13:34:24.844585	Full Name 2	\N
user3	2025-06-05 13:34:24.844585	Full Name 3	\N
user4	2025-06-05 13:34:24.844585	Full Name 4	\N
user5	2025-06-05 13:34:24.844585	Full Name 5	\N
user6	2025-06-05 13:34:24.844585	Full Name 6	\N
user7	2025-06-05 13:34:24.844585	Full Name 7	\N
user8	2025-06-05 13:34:24.844585	Full Name 8	\N
user9	2025-06-05 13:34:24.844585	Full Name 9	\N
user10	2025-06-05 13:34:24.844585	Full Name 10	\N
john_doe	2025-06-10 18:21:12.921076	John Doe	Admin
existing_user1	2025-06-10 19:45:46.650949	Existing User23	Admin
existing_user	2025-06-10 18:59:52.385599	Existing User23	Admin
\.


--
-- Name: cart_seq; Type: SEQUENCE SET; Schema: public; Owner: raghavprasad
--

SELECT pg_catalog.setval('public.cart_seq', 1, false);


--
-- Name: items_seq; Type: SEQUENCE SET; Schema: public; Owner: raghavprasad
--

SELECT pg_catalog.setval('public.items_seq', 1, false);


--
-- Name: user_seq; Type: SEQUENCE SET; Schema: public; Owner: raghavprasad
--

SELECT pg_catalog.setval('public.user_seq', 1, false);


--
-- Name: cart_items cart_items_pkey; Type: CONSTRAINT; Schema: public; Owner: raghavprasad
--

ALTER TABLE ONLY public.cart_items
    ADD CONSTRAINT cart_items_pkey PRIMARY KEY (id);


--
-- Name: cart cart_pkey; Type: CONSTRAINT; Schema: public; Owner: raghavprasad
--

ALTER TABLE ONLY public.cart
    ADD CONSTRAINT cart_pkey PRIMARY KEY (cart_name);


--
-- Name: items items_pkey; Type: CONSTRAINT; Schema: public; Owner: raghavprasad
--

ALTER TABLE ONLY public.items
    ADD CONSTRAINT items_pkey PRIMARY KEY (item_name);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: raghavprasad
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_name);


--
-- Name: idx_user_user_name; Type: INDEX; Schema: public; Owner: raghavprasad
--

CREATE INDEX idx_user_user_name ON public.users USING btree (user_name);


--
-- Name: cart_items fk4no1ciwmqr1wqn8oxewfw7p2e; Type: FK CONSTRAINT; Schema: public; Owner: raghavprasad
--

ALTER TABLE ONLY public.cart_items
    ADD CONSTRAINT fk4no1ciwmqr1wqn8oxewfw7p2e FOREIGN KEY (cart_name) REFERENCES public.cart(cart_name);


--
-- Name: cart_items fkeodjepeikjaa4ua9rdx7jx372; Type: FK CONSTRAINT; Schema: public; Owner: raghavprasad
--

ALTER TABLE ONLY public.cart_items
    ADD CONSTRAINT fkeodjepeikjaa4ua9rdx7jx372 FOREIGN KEY (item_name) REFERENCES public.items(item_name);


--
-- Name: cart fkl6h3e6ry6l72kyqlkud5o5i42; Type: FK CONSTRAINT; Schema: public; Owner: raghavprasad
--

ALTER TABLE ONLY public.cart
    ADD CONSTRAINT fkl6h3e6ry6l72kyqlkud5o5i42 FOREIGN KEY (admin_user) REFERENCES public.users(user_name);


--
-- Name: cart_items fkrlkkiu77o6jirqg39jf4ighpn; Type: FK CONSTRAINT; Schema: public; Owner: raghavprasad
--

ALTER TABLE ONLY public.cart_items
    ADD CONSTRAINT fkrlkkiu77o6jirqg39jf4ighpn FOREIGN KEY (user_name) REFERENCES public.users(user_name);


--
-- PostgreSQL database dump complete
--

