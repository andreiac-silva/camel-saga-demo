-- inserting two flights: AA1234 and BB1234
INSERT INTO flight (id, code) VALUES (null, 'AA1234');
INSERT INTO flight (id, code) VALUES (null, 'BB1234');     

-- inserting seats to the flight AA1234
INSERT INTO seat (id, code, fk_flight, status) VALUES (null, 'AA1234-A1', 1, 'AVAILABLE');
INSERT INTO seat (id, code, fk_flight, status) VALUES (null, 'AA1234-A2', 1, 'AVAILABLE');
INSERT INTO seat (id, code, fk_flight, status) VALUES (null, 'AA1234-B1', 1, 'UNAVAILABLE');
INSERT INTO seat (id, code, fk_flight, status) VALUES (null, 'AA1234-B2', 1, 'UNAVAILABLE');
INSERT INTO seat (id, code, fk_flight, status) VALUES (null, 'AA1234-C1', 1, 'AVAILABLE');
INSERT INTO seat (id, code, fk_flight, status) VALUES (null, 'AA1234-C2', 1, 'AVAILABLE');

-- inserting seats to the flight BB1234
INSERT INTO seat (id, code, fk_flight, status) VALUES (null, 'BB1234-A1', 2, 'UNAVAILABLE');
INSERT INTO seat (id, code, fk_flight, status) VALUES (null, 'BB1234-A2', 2, 'UNAVAILABLE');
INSERT INTO seat (id, code, fk_flight, status) VALUES (null, 'BB1234-B1', 2, 'UNAVAILABLE');
INSERT INTO seat (id, code, fk_flight, status) VALUES (null, 'BB1234-B2', 2, 'UNAVAILABLE');
INSERT INTO seat (id, code, fk_flight, status) VALUES (null, 'BB1234-C1', 2, 'UNAVAILABLE');
INSERT INTO seat (id, code, fk_flight, status) VALUES (null, 'BB1234-C2', 2, 'UNAVAILABLE');