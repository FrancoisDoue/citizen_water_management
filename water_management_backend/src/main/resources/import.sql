INSERT INTO `role` (authority) VALUES ('SUPER_ADMIN'), ('USER'), ('TECHNICIAN'), ('WATER_COMPANY_TECHNICIAN'), ('COMPANY');

INSERT INTO `location`(zip_code, dtype, city, street) VALUES (59, 'Home', 'st-ntm', 'impasse des youms');
INSERT INTO `location`(zip_code, dtype, city, street, name, reference) VALUES (77, 'GreenSpace', 'fontaineblaud', 'allée du parc', 'le parc', 'la moula');

INSERT INTO `account` (email, password, firstname, lastname, role) VALUES ('admin', '$2a$10$cbT6eWEDWdkuks9Dlx0crOOPmLEzLg5N9REm9PpHhqr7LDk9F7nT.', NULL, NULL, 1);
INSERT INTO `account` (email, password, firstname, lastname, role, home_id) VALUES ('user', '$2a$10$F98Oxnu8SS7JmCgm4rzJUO4ugWyxpnCppklIzP9PUKfSkp5.Z6j/e', 'Georges', 'Abitbol', 2, 1);
INSERT INTO `account` (email, password, firstname, lastname, role) VALUES ('gcompany@mail.fr', '$2a$10$F98Oxnu8SS7JmCgm4rzJUO4ugWyxpnCppklIzP9PUKfSkp5.Z6j/e', 'Georges', 'Company', 5);
INSERT INTO `water_company` (id) VALUE ('3');
INSERT INTO `account` (email, password, firstname, lastname, role) VALUES ('technician', '$2a$10$F98Oxnu8SS7JmCgm4rzJUO4ugWyxpnCppklIzP9PUKfSkp5.Z6j/e', 'Régis', 'Teckos', 5);
INSERT INTO `technician` (id, water_company_id, job) VALUES (4, 3, 'ingénieur du son');

INSERT INTO `notification` (title, image_url, message, open, created_date, account_id) VALUES ('baisse conso', 'https://image-static.collegedunia.com/public/image/44def96a3e1903f38b50e9306932b637.png', 'leau cest bieng', false, '1925-05-05T05:05:05', 2);

INSERT INTO `water_supply`(consumption_water, water_pressure, reference, location_id) VALUES (1.5, 5.5, 'arrivé privé', 1);
INSERT INTO `water_supply`(consumption_water, water_pressure, reference, location_id) VALUES (1.5, 5.5, 'arrivé public', 2);

INSERT INTO `alert`(open, created_date, water_supply_id, message, title ) VALUES (true, '1925-05-05T05:05:05', 1, 'privé', 'privé');
INSERT INTO `alert`(open, created_date, water_supply_id, message, title ) VALUES (true, '1925-05-05T05:05:05', 2, 'public', 'public');

INSERT INTO `consumption_detail`(end_date, start_date, medium_pressure, water_consumption, water_supply_id) VALUES ('2024-09-01', '2024-09-30', 5.5, 5.5, 1)