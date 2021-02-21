DROP DATABASE IF EXISTS storage;
CREATE DATABASE storage;
\connect storage

CREATE TABLE product_cats(
    type_id serial PRIMARY KEY,
    name text NOT NULL,
    description text,
);

CREATE TABLE products(
    product_id serial PRIMARY KEY,
    name text NOT NULL,
    description text,
    category insteger REFERENCES product_cats NOT NULL,
    unit text NOT NULL,
    oversized boolean NOT NULL,
);

CREATE TABLE product_instance(
    instance_id serial PRIMARY KEY,
    product_id integer REFERENCES products(product_id) NOT NULL,
    units real NOT NULL,
    arrival timestamp NOT NULL,
    expires timestamp,
    root_no integer NOT NULL,
    shelf_no integer NOT NULL
);

CREATE TABLE providers(
    provider_id serial PRIMARY KEY,
    name text NOT NULL,
    description text,
    address text[] NOT NULL,
    tel text[] NOT NULL,
    email text[] NOT NULL
);

CREATE TABLE consumers(
    provider_id serial PRIMARY KEY,
    name text NOT NULL,
    description text,
    address text[] NOT NULL,
    tel text[] NOT NULL,
    email text[] NOT NULL
);

CREATE TABLE supplies(
	provider_id insteger REFERENCES providers(provider_id) NOT NULL,
    product_id integer REFERENCES products(product_id) NOT NULL,
    count integer NOT NULL CONSTRAINT count_non_neg CHECK(count > 0),
    time timestamp NOT NULL,
    completed boolean NOT NULL
);


CREATE TABLE orders(
	consumer_id insteger REFERENCES consumers(provider_id) NOT NULL,
    product_id integer REFERENCES products(product_id) NOT NULL,
    count integer NOT NULL CONSTRAINT count_non_neg CHECK(count > 0),
    time timestamp NOT NULL,
    completed boolean NOT NULL
);
