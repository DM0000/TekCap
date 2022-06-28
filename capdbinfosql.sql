insert into store_entity (id, name) VALUES (1,'Walmart');
insert into store_entity (id, name) VALUES (2,'Frys');
insert into store_entity (id, name) VALUES (3,'ShopRite');
insert into store_entity (id, name) VALUES (4,'Costco');

insert into item_entity (id, name) VALUES (1, 'Apples');
insert into item_entity (id, name) VALUES (2, 'Tomatoes');
INSERT into item_entity (id, NAME) VALUES (3, 'Peaches');
insert into item_entity (id, name) VALUES (4, 'Oranges');
insert into item_entity (id, name) VALUES (5, 'Pears');
insert into item_entity (id, name) VALUES (6, 'Bananas');
insert into item_entity (id, name) VALUES (7, 'Grapes');

INSERT INTO store_inv_entity(id, price, item_id, store_id) VALUES(1,1.20, 1,1);
INSERT INTO store_inv_entity(id, price, item_id, store_id) VALUES(2,.75, 2,1);
INSERT INTO store_inv_entity(id, price, item_id, store_id) VALUES(3,1.00, 3,1);
INSERT INTO store_inv_entity(id, price, item_id, store_id) VALUES(4,1.50, 4,1);
INSERT INTO store_inv_entity(id, price, item_id, store_id) VALUES(5,.95, 5,1);
INSERT INTO store_inv_entity(id, price, item_id, store_id) VALUES(6,1.25, 6,1);
INSERT INTO store_inv_entity(id, price, item_id, store_id) VALUES(7,.75, 7,1);
INSERT INTO store_inv_entity(id, price, item_id, store_id) VALUES(8,1.00, 2,2);
INSERT INTO store_inv_entity(id, price, item_id, store_id) VALUES(9,2.00, 3,2);
INSERT INTO store_inv_entity(id, price, item_id, store_id) VALUES(10,2.00, 1,2);
INSERT INTO store_inv_entity(id, price, item_id, store_id) VALUES(11,.75,5,2);
INSERT INTO store_inv_entity(id, price, item_id, store_id) VALUES(12, 1.00, 1,3);
INSERT INTO store_inv_entity(id, price, item_id, store_id) VALUES(13, .75, 2,3); 
INSERT INTO store_inv_entity(id, price, item_id, store_id) VALUES(14, 1.05, 6,3);
INSERT INTO store_inv_entity(id, price, item_id, store_id) VALUES(15,.55, 4,3); 
INSERT INTO store_inv_entity(id, price, item_id, store_id) VALUES(16,1.50, 5,3);
INSERT INTO store_inv_entity(id, price, item_id, store_id) VALUES(17,1.15, 7,3);
INSERT INTO store_inv_entity(id, price, item_id, store_id) VALUES(18,1.15, 1,4);
INSERT INTO store_inv_entity(id, price, item_id, store_id) VALUES(19,.70, 2,4);
INSERT INTO store_inv_entity(id, price, item_id, store_id) VALUES(20,1.05, 3,4);
INSERT INTO store_inv_entity(id, price, item_id, store_id) VALUES(21,.57, 4,4);
INSERT INTO store_inv_entity(id, price, item_id, store_id) VALUES(22,.90, 5,4);
INSERT INTO store_inv_entity(id, price, item_id, store_id) VALUES(23,1.20, 6,4);
INSERT INTO store_inv_entity(id, price, item_id, store_id) VALUES(24,.80, 7,4);


INSERT INTO cart_entity(id) VALUES(1);
INSERT INTO user_entity(id,NAME,email , cart_id) VALUES(1,'testtest','test@test.com',1);
INSERT INTO cart_item(id, quantity, item_id) VALUES(1,1,1);
INSERT INTO cart_entity_items(cart_entity_id,items_id)VALUES(1,1);