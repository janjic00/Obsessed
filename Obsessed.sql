GRANT ALL PRIVILEGES ON db_obsessed2.* TO 'springuser'@'localhost';
ALTER USER 'springuser'@'localhost' IDENTIFIED BY 'ThePassword';
use db_obsessed2;

INSERT INTO category (name, description)
VALUES ('Oversize majice', 'Naša oversize majica dolazi u različitim veličinama. Pronađite svoju idealnu udobnost');


-- Dodajte crnu Oversize majicu povezanu sa kategorijom "Oversize majice"
INSERT INTO product (name, description, price, stock, image, category_id)
VALUES ('Crna Oversize majica', 'Crne Obsessed Oversize majice', 18.80, 20, 'slika_crna.jpg', 1);

-- Dodajte belu Oversize majicu povezanu sa kategorijom "Oversize majice"
INSERT INTO product (name, description, price, stock, image, category_id)
VALUES ('Bela Oversize majica', 'Opis bele Oversize majice', 18.80, 20, 'slika_bela.jpg', 1);

-- Dodajte sivu Oversize majicu povezanu sa kategorijom "Oversize majice"
INSERT INTO product (name, description, price, stock, image, category_id)
VALUES ('Siva Oversize majica', 'Opis sive Oversize majice', 18.80, 20, 'slika_siva.jpg', 1);

INSERT INTO tag (id, name) VALUES (1, 'Oversize');
INSERT INTO tag (id, name) VALUES (2, 'Crna');
INSERT INTO tag (id, name) VALUES (3, 'Bela');
INSERT INTO tag (id, name) VALUES (4, 'Siva');

INSERT INTO product_tags (product_id, tag_id) VALUES (1, 1); -- Crna Oversize majica pripada tagu Oversize
INSERT INTO product_tags (product_id, tag_id) VALUES (1, 2); -- Crna Oversize majica pripada tagu Crna
INSERT INTO product_tags (product_id, tag_id) VALUES (2, 1); -- Bela Oversize majica pripada tagu Oversize
INSERT INTO product_tags (product_id, tag_id) VALUES (2, 3); -- Bela Oversize majica pripada tagu Bela
INSERT INTO product_tags (product_id, tag_id) VALUES (3, 1); -- Siva Oversize majica pripada tagu Oversize
INSERT INTO product_tags (product_id, tag_id) VALUES (3, 4); -- Siva Oversize majica pripada tagu Siva


SELECT * FROM product;