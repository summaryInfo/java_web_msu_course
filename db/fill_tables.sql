INSERT INTO product_categories(categoryId, name, description) VALUES
    (101, 'Food', NULL),
    (102, 'Household chemicals', NULL),
    (103, 'Clothes', NULL),
    (104, 'Consumer electronics', NULL);

INSERT INTO products(productId, name, description, categoryId, unit, oversized) VALUES
    (101, 'Potatoes', NULL, 101, 'Killogram', FALSE),
    (102, 'Lemon juice (1 liter)', NULL, 101, 'Item', FALSE),
    (103, 'Soap', NULL, 102, 'Item', FALSE),
    (104, 'T-Short', NULL, 103, 'Item', FALSE),
    (105, 'Electric teapot', NULL, 104, 'Item', FALSE),
    (106, 'Refrigerator', NULL, 104, 'Box', TRUE);

INSERT INTO providers(providerId, name, description, address, phone, email) VALUES
    (101, 'Food source', 'Test description for food provider', NULL, '1(111)111-11-11', 'food@source.com'),
    (102, 'Chemicals source', 'Test description for chemicals source', NULL, '2(222)222-22-22', 'contact@chemicals123.com'),
    (103, 'Electronics provider', 'Test description for electronics provider', NULL, '3(333)333-33-33', 'mail@allelectronics.net');

INSERT INTO consumers(consumerId, name, description, address, phone, email) VALUES
    (101, 'A potato consumer', NULL, NULL, '4(444)444-44-44', 'ilove@potates.com');

INSERT INTO supplies(supplyId, providerId, productId, amount, time, completed) VALUES
    (101, 101, 101, 20, '2020-12-21', TRUE),
    (102, 101, 101, 10, '2020-11-21', TRUE),
    (103, 101, 102, 10, '2021-01-13', TRUE),
    (104, 102, 103, 10, '2021-02-12', TRUE),
    (105, 102, 104, 10, '2021-01-29', FALSE),
    (106, 103, 105, 10, '2020-11-21', TRUE),
    (107, 103, 106, 10, '2021-01-28', TRUE);

INSERT INTO orders(orderId, consumerId, productId, amount, time, completed) VALUES
    (101, 101, 101, 30, '2020-01-20', TRUE),
    (102, 101, 101, 30, '2020-05-20', FALSE),
    (103, 101, 101, 40, '2020-05-21', FALSE),
    (104, 101, 106, 1, '2020-07-01', FALSE);

INSERT INTO product_instances(instanceId, productId, amount, arrival, expires, roomNo, shelfNo, source, destination) VALUES
    (101, 101, 10, '2020-12-21', '2021-06-03', 1, 1, 101, 102),
    (102, 101, 10, '2020-12-21', '2021-06-03', 1, 1, 101, 102),
    (103, 101, 10, '2020-12-21', '2021-06-03', 1, 2, 101, 102),
    (104, 101, 10, '2020-12-21', '2021-06-03', 1, 2, 101, 103),
    (105, 101, 15, '2020-11-17', '2021-04-03', 1, 3, 102, 103),
    (106, 101, 15, '2020-11-17', '2021-04-03', 1, 3, 102, 103),
    (107, 101, 15, '2020-11-17', '2021-04-03', 1, 3, 102, NULL),
    (108, 102, 6, '2021-01-13', '2021-03-13', 1, 5, 103, NULL),
    (109, 102, 6, '2021-01-13', '2021-03-13', 1, 6, 103, NULL),
    (110, 103, 30, '2020-11-01', '2030-11-01', 2, 1, 104, NULL),
    (111, 103, 30, '2020-11-01', '2030-11-01', 2, 2, 104, NULL),
    (112, 104, 20, '2021-02-12', NULL, 2, 3, 105, NULL),
    (113, 104, 20, '2021-02-12', NULL, 2, 4, 105, NULL),
    (114, 104, 20, '2021-04-15', NULL, 2, 5, 105, NULL),
    (115, 104, 20, '2021-04-15', NULL, 2, 6, 105, NULL),
    (116, 105, 3, '2021-01-29', NULL, 2, 7, 106, NULL),
    (117, 105, 3, '2021-01-29', NULL, 2, 8, 106, NULL),
    (118, 105, 3, '2021-01-29', NULL, 2, 9, 106, NULL),
    (119, 106, 1, '2021-01-28', NULL, 3, 1, 107, 104);


