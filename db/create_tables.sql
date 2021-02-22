CREATE TABLE product_categories(
    category_id serial PRIMARY KEY,
    name text NOT NULL,
    description text,
);

CREATE TABLE products(
    product_id serial PRIMARY KEY,
    name text NOT NULL,
    description text,
    category_id insteger REFERENCES product_categories(category_id) NOT NULL,
    unit text NOT NULL,
    oversized boolean NOT NULL,
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
    supply_id serial PRIMARY KEY,
	provider_id insteger REFERENCES providers(provider_id) NOT NULL,
    product_id integer REFERENCES products(product_id) NOT NULL,
    amount real NOT NULL CONSTRAINT amount_non_neg CHECK(amount > 0),
    time timestamp NOT NULL,
    completed boolean NOT NULL
);

CREATE TABLE orders(
    order_id serial PRIMARY KEY,
	consumer_id insteger REFERENCES consumers(provider_id) NOT NULL,
    product_id integer REFERENCES products(product_id) NOT NULL,
    count integer NOT NULL CONSTRAINT count_non_neg CHECK(count > 0),
    time timestamp NOT NULL,
    completed boolean NOT NULL
);

CREATE TABLE product_instance(
    instance_id serial PRIMARY KEY,
    product_id integer REFERENCES products(product_id) NOT NULL,
    amount real NOT NULL,
    arrival timestamp NOT NULL,
    expires timestamp,
    room_no integer NOT NULL,
    shelf_no integer NOT NULL
    source integer REFERENCES orders(order_id) NOT NULL,
    destination integer REFERENCES supplies(supply_id),
);

