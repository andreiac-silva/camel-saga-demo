-- inserting a hotel BR1234
INSERT INTO hotel (id, code) VALUES (null, 'BR1234');     

-- inserting rooms to hotel BR1234
INSERT INTO room (id, fk_hotel, status, type) VALUES (null, 1, 'UNAVAILABLE', 'SINGLE');
INSERT INTO room (id, fk_hotel, status, type) VALUES (null, 1, 'AVAILABLE', 'DOUBLE');
INSERT INTO room (id, fk_hotel, status, type) VALUES (null, 1, 'AVAILABLE', 'DOUBLE');
INSERT INTO room (id, fk_hotel, status, type) VALUES (null, 1, 'UNAVAILABLE', 'DOUBLE');
INSERT INTO room (id, fk_hotel, status, type) VALUES (null, 1, 'UNAVAILABLE', 'QUAD');