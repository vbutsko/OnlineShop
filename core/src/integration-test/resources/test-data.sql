INSERT INTO MOBILEPHONES (NAME, COST, PRODUCER_ID) VALUES ('iphone 5s', 30, 1);
INSERT INTO MOBILEPHONES (NAME, COST, PRODUCER_ID) VALUES ('iphone se', 35, 1);
INSERT INTO MOBILEPHONES (NAME, COST, PRODUCER_ID) VALUES ('galaxy S7', 20, 2);


INSERT INTO PRODUCERS (PRODUCER_NAME) VALUES ('Apple');
INSERT INTO PRODUCERS (PRODUCER_NAME) VALUES ('Sumsung');


INSERT INTO ORDERS (order_id, delivered_status, delivery_price, total_cost,  first_name, last_name, phone_number)
      VALUES ('2WHK24I250', 0, 5, 40, 'wladislaw', 'butko', '1234567');


INSERT INTO ORDER_ITEMS (order_id, product_id, amount, price_for_one)
        VALUES ('2WHK24I250', 3, 2, 20);