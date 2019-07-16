-- inserting miles to customers 123456 and 654321
INSERT INTO customer_miles (id, customer_id, amount_of_miles) VALUES (null, 123456, 20000);
INSERT INTO customer_miles (id, customer_id, amount_of_miles) VALUES (null, 654321, 100);

-- inserting price to flight AA1234
INSERT INTO flight_miles_cost (id, code, cost_in_miles) VALUES (null, 'AA1234', 5000);

-- inserting price to hotel BR1234
INSERT INTO hotel_room_miles_cost (id, code, cost_in_miles, type) VALUES (null, 'BR1234', 5000, 'SINGLE');
INSERT INTO hotel_room_miles_cost (id, code, cost_in_miles, type) VALUES (null, 'BR1234', 10000, 'DOUBLE');
INSERT INTO hotel_room_miles_cost (id, code, cost_in_miles, type) VALUES (null, 'BR1234', 15000, 'TRIPLE');
INSERT INTO hotel_room_miles_cost (id, code, cost_in_miles, type) VALUES (null, 'BR1234', 18000, 'QUAD');
