CREATE DATABASE onlineshoop;

CREATE TABLE MOBILEPHONES(
    mobile_id INT (50) NOT NULL AUTO_INCREMENT PRIMARY KEY(mobile_id),
    name VARCHAR (100),
    cost DECIMAL (10, 0),
    producer_id INT(50)
);

CREATE TABLE PRODUCERS(
    producer_id INT(50) NOT NULL AUTO_INCREMENT PRIMARY KEY(producer_id),
    producer_name VARCHAR (50)
);

CREATE TABLE ORDERS(
    id  INT (50) NOT NULL AUTO_INCREMENT PRIMARY KEY(id),
    order_id VARCHAR (16) UNIQUE,
    delevered_status TINYINT(1),
    delivery_price DECIMAL (10,0),
    total_cost DECIMAL (10,0),
    first_name VARCHAR (50),
    last_name VARCHAR (50),
    phone_number VARCHAR (50)
);

CREATE TABLE ORDER_ITEMS(
    id INT (50) NOT NULL AUTO_INCREMENT PRIMARY  KEY (id),
    order_id VARCHAR (16),
    product_id INT (50),
    amount INT (11),
    price_for_one DECIMAL (10,0),

    FOREIGN KEY (order_id) REFERENCES ORDERS(order_id),
    FOREIGN KEY (product_id) REFERENCES MOBILEPHONES(product_id)
);