INSERT INTO product_categories(category_id, name, description) VALUES
    (1, 'продукты', NULL),
    (2, 'бытовая химия', NULL),
    (3, 'одежда/обувь', NULL),
    (4, 'бытовая электроника', NULL);

INSERT INTO products(product_id, name, description, category_id, unit, oversized) VALUES
    (1, 'Potatoes', NULL, 1, 'Killogram', FALSE),
    (2, 'Lemon juice (1 liter)', NULL, 1, 'Item', FALSE),
    (3, 'Soap', NULL, 2, 'Item', FALSE),
    (4, 'T-Short', NULL, 3, 'Item', FALSE),
    (5, 'Electric teapot', NULL, 4, 'Item', FALSE),
    (6, 'Refrigerator', NULL, 4, 'Box', TRUE);

INSERT INTO providers(provider_id, name, description, address, tel, email) VALUES
    (1, 'Food source', 'Test description for food provider', '{}', '{"1(111)111-11-11"}', '{"food@source.com"}'),
    (2, 'Chemicals source', 'Test description for chemicals source', '{}', '{"2(222)222-22-22"}', '{"contact@chemicals123.com"}'),
    (3, 'Electronics provider', 'Test description for electronics provider', '{}', '{"3(333)333-33-33"}', '{"mail@allelectronics.net"}');

INSERT INTO consumers(consumer_id, name, description, address, tel, email) VALUES
    (1, 'A potato consumer', NULL, '{}', '{"4(444)444-44-44"}', '{"ilove@potates.com"}');

INSERT INTO supplies(supply_id, provider_id, product_id, amount, time, completed) VALUES
    (1, 1, 1, 20, '2020-12-21', TRUE),
    (2, 1, 1, 10, '2020-11-21', TRUE),
    (3, 1, 2, 10, '2021-01-13', TRUE),
    (4, 2, 3, 10, '2021-02-12', TRUE),
    (5, 2, 4, 10, '2021-01-29', FALSE),
    (6, 3, 5, 10, '2020-11-21', TRUE),
    (7, 3, 6, 10, '2021-01-28', TRUE);

INSERT INTO orders(order_id, consumer_id, product_id, amount, time, completed) VALUES
    (1, 1, 1, 30, '2020-01-20', TRUE),
    (2, 1, 1, 30, '2020-05-20', FALSE),
    (3, 1, 1, 40, '2020-05-21', FALSE),
    (4, 1, 6, 1, '2020-07-01', FALSE);

INSERT INTO product_instance(instance_id, product_id, amount, arrival, expires, room_no, shelf_no, source, destination) VALUES
    (1, 1, 10, '2020-12-21', '2021-06-03', 1, 1, 1, 2),
    (2, 1, 10, '2020-12-21', '2021-06-03', 1, 1, 1, 2),
    (3, 1, 10, '2020-12-21', '2021-06-03', 1, 2, 1, 2),
    (4, 1, 10, '2020-12-21', '2021-06-03', 1, 2, 1, 3),
    (5, 1, 15, '2020-11-17', '2021-04-03', 1, 3, 2, 3),
    (6, 1, 15, '2020-11-17', '2021-04-03', 1, 3, 2, 3),
    (7, 1, 15, '2020-11-17', '2021-04-03', 1, 3, 2, NULL),
    (8, 2, 6, '2021-01-13', '2021-03-13', 1, 5, 3, NULL),
    (9, 2, 6, '2021-01-13', '2021-03-13', 1, 6, 3, NULL),
    (10, 3, 30, '2020-11-01', '2030-11-01', 2, 1, 4, NULL),
    (11, 3, 30, '2020-11-01', '2030-11-01', 2, 2, 4, NULL),
    (12, 4, 20, '2021-02-12', NULL, 2, 3, 5, NULL),
    (13, 4, 20, '2021-02-12', NULL, 2, 4, 5, NULL),
    (14, 4, 20, '2021-04-15', NULL, 2, 5, 5, NULL),
    (15, 4, 20, '2021-04-15', NULL, 2, 6, 5, NULL),
    (16, 5, 3, '2021-01-29', NULL, 2, 7, 6, NULL),
    (17, 5, 3, '2021-01-29', NULL, 2, 8, 6, NULL),
    (18, 5, 3, '2021-01-29', NULL, 2, 9, 6, NULL),
    (19, 6, 1, '2021-01-28', NULL, 3, 1, 7, 4);


