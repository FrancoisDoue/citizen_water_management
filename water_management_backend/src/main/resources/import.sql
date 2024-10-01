INSERT INTO `role` (authority) VALUES ('SUPER_ADMIN'), ('USER');
INSERT INTO `account` (email, password, firstname, lastname, role) VALUES ('admin', '$2a$10$cbT6eWEDWdkuks9Dlx0crOOPmLEzLg5N9REm9PpHhqr7LDk9F7nT.', NULL, NULL, 1);
INSERT INTO `account` (email, password, firstname, lastname, role) VALUES ('user', '$2a$10$F98Oxnu8SS7JmCgm4rzJUO4ugWyxpnCppklIzP9PUKfSkp5.Z6j/e', 'Georges', 'Abitbol', 2);
INSERT INTO `water_supply`(consumption_water, water_pressure, reference) VALUES (1.5, 5.5, 'je suis une référence')
