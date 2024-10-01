INSERT INTO `role` (authority) VALUES ('SUPER_ADMIN'), ('USER'), ('TECHNICIAN'), ('WATER_COMPANY_TECHNICIAN'), ('COMPANY');
INSERT INTO `account` (email, password, firstname, lastname, role) VALUES ('admin', '$2a$10$cbT6eWEDWdkuks9Dlx0crOOPmLEzLg5N9REm9PpHhqr7LDk9F7nT.', NULL, NULL, 1);
INSERT INTO `account` (email, password, firstname, lastname, role) VALUES ('user', '$2a$10$F98Oxnu8SS7JmCgm4rzJUO4ugWyxpnCppklIzP9PUKfSkp5.Z6j/e', 'Georges', 'Abitbol', 2);
INSERT INTO `account` (email, password, firstname, lastname, role) VALUES ('gcompany@mail.fr', '$2a$10$F98Oxnu8SS7JmCgm4rzJUO4ugWyxpnCppklIzP9PUKfSkp5.Z6j/e', 'Georges', 'Company', 5);
INSERT INTO `water_company` (id) VALUE ('3');
INSERT INTO `account` (email, password, firstname, lastname, role) VALUES ('technician', '$2a$10$F98Oxnu8SS7JmCgm4rzJUO4ugWyxpnCppklIzP9PUKfSkp5.Z6j/e', 'Régis', 'Teckos', 5);
INSERT INTO `technician` (id, water_company_id, job) VALUES (4, 3, 'ingénieur du son');
INSERT INTO `water_supply` (consumption_water, water_pressure, reference) VALUES (1.5, 5.5, 'je suis une référence');

