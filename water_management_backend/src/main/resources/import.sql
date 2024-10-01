INSERT INTO `role` (authority) VALUES ('SUPER_ADMIN'), ('USER'), ('TECHNICIAN'), ('WATER_COMPANY_TECHNICIAN');
INSERT INTO `account` (email, password, firstname, lastname, role) VALUES ('admin', '$2a$10$cbT6eWEDWdkuks9Dlx0crOOPmLEzLg5N9REm9PpHhqr7LDk9F7nT.', NULL, NULL, 1);
INSERT INTO `account` (email, password, firstname, lastname, role) VALUES ('user', '$2a$10$F98Oxnu8SS7JmCgm4rzJUO4ugWyxpnCppklIzP9PUKfSkp5.Z6j/e', 'Georges', 'Abitbol', 2);

INSERT INTO `location`(zip_code, dtype, city, street) VALUES (59, 'Home', 'st-ntm', 'impasse des youms');
INSERT INTO `location`(zip_code, dtype, city, street, name, reference) VALUES (77, 'GreenSpace', 'fontaineblaud', 'allée du parc', 'le parc', 'la moula');

INSERT INTO `water_supply`(consumption_water, water_pressure, reference, location_id) VALUES (1.5, 5.5, 'arrivé privé', 1);
INSERT INTO `water_supply`(consumption_water, water_pressure, reference, location_id) VALUES (1.5, 5.5, 'arrivé public', 2);

INSERT INTO `alert`(open, created_date, water_supply_id, message, title ) VALUES (true, '1925-05-05T05:05:05', 1, 'privé', 'privé');
INSERT INTO `alert`(open, created_date, water_supply_id, message, title ) VALUES (true, '1925-05-05T05:05:05', 2, 'public', 'public');
