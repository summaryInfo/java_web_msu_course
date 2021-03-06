CREATE TABLE product_categories(
    categoryId serial PRIMARY KEY,
    name text NOT NULL,
    description text
);

CREATE TABLE products(
    productId serial PRIMARY KEY,
    name text NOT NULL,
    description text,
    categoryId integer REFERENCES product_categories(categoryId) NOT NULL,
    unit text NOT NULL,
    oversized boolean NOT NULL
);

CREATE TABLE providers(
    providerId serial PRIMARY KEY,
    name text NOT NULL,
    description text,
    address text,
    phone text,
    email text
);

CREATE TABLE consumers(
    consumerId serial PRIMARY KEY,
    name text NOT NULL,
    description text,
    address text,
    phone text,
    email text
);

CREATE TABLE supplies(
    supplyId serial PRIMARY KEY,
	providerId integer REFERENCES providers(providerId) NOT NULL,
    productId integer REFERENCES products(productId) NOT NULL,
    amount real NOT NULL CONSTRAINT amountNonNeg CHECK(amount > 0),
    time timestamp NOT NULL,
    completed boolean NOT NULL
);

CREATE TABLE orders(
    orderId serial PRIMARY KEY,
	consumerId integer REFERENCES consumers(consumerId) NOT NULL,
    productId integer REFERENCES products(productId) NOT NULL,
    amount real NOT NULL CONSTRAINT amountNonNeg CHECK(amount > 0),
    time timestamp NOT NULL,
    completed boolean NOT NULL
);

CREATE TABLE product_instances(
    instanceId serial PRIMARY KEY,
    productId integer REFERENCES products(productId) NOT NULL,
    amount real NOT NULL,
    arrival timestamp NOT NULL,
    expires timestamp,
    roomNo integer NOT NULL,
    shelfNo integer NOT NULL,
    source integer REFERENCES supplies(supplyId) NOT NULL,
    destination integer REFERENCES orders(orderId)
);

