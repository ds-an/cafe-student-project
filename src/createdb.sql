drop table if exists clients;
drop table if exists coffeeshop;
drop table if exists baristas;
drop table if exists managers;
drop table if exists access;
drop table if exists drinkscoffee;
drop table if exists drinkstea;
drop table if exists drinksother;
drop table if exists food;
drop table if exists storage;
drop table if exists orders;
drop table if exists payment;
drop table if exists storage;
drop view if exists full_menu;
drop view if exists full_login_info;

CREATE TABLE coffeeshop (
                            ShopName NVARCHAR(40) NOT NULL,
                            Phonenumber NVARCHAR(24),
                            OwnerId INTEGER NOT NULL,
                            Email NVARCHAR(60),
                            Address NVARCHAR(100)
);

CREATE TABLE clients (
                         ClientId INTEGER PRIMARY KEY,
                         FirstName NVARCHAR(40) NOT NULL,
                         LastName NVARCHAR(40),
                         PhoneNumber NVARCHAR(24),
                         Email NVARCHAR(60),
                         CoffeeOrders INTEGER NOT NULL
);

CREATE TABLE baristas (
                          BaristaId INTEGER PRIMARY KEY,
                          FirstName NVARCHAR(40) NOT NULL,
                          LastName NVARCHAR(40) NOT NULL,
                          Shift NVARCHAR(60) NOT NULL,
                          PhoneNumber NVARCHAR(24),
                          Email NVARCHAR(60)
                              CHECK ( Shift IN ('Morning',
                                                'Evening') )
);

CREATE TABLE managers (
                          ManagerId INTEGER PRIMARY KEY,
                          FirstName NVARCHAR(40),
                          LastName NVARCHAR(40),
                          PhoneNumber NVARCHAR(24),
                          Email NVARCHAR(60)
);

CREATE TABLE access (
                        Accessid INTEGER PRIMARY KEY,
                        Login NVARCHAR(80) NOT NULL,
                        Password NVARCHAR(80) NOT NULL
);

CREATE TABLE drinkscoffee (
                              DrinkId INTEGER PRIMARY KEY,
                              DrinkName NVARCHAR(60),
                              CoffeeType NVARCHAR(60),
                              MilkType NVARCHAR(40),
                              Temperature NVARCHAR(40),
                              PriceInside INTEGER NOT NULL,
                              PriceOutside INTEGER NOT NULL,
                              TotalLeft INTEGER NOT NULL,
                              Description NVARCHAR(240)
                                  CHECK ( Temperature IN ('Hot',
                                                          'Cold') )
);

CREATE TABLE drinkstea (
                           DrinkId INTEGER PRIMARY KEY,
                           DrinkName NVARCHAR(60),
                           TeaType NVARCHAR(60),
                           MilkType NVARCHAR(40),
                           Temperature NVARCHAR(40),
                           PriceInside INTEGER NOT NULL,
                           PriceOutside INTEGER NOT NULL,
                           TotalLeft INTEGER NOT NULL,
                           Description NVARCHAR(240)
                               CHECK ( Temperature IN ('Hot',
                                                       'Cold') )
                               CHECK ( TeaType IN ('Black',
                                                   'Green',
                                                   'Herbal') )
);

CREATE TABLE drinksother (
                             DrinkId INTEGER PRIMARY KEY,
                             DrinkName NVARCHAR(60),
                             PriceInside INTEGER NOT NULL,
                             PriceOutside INTEGER NOT NULL,
                             TotalLeft INTEGER NOT NULL,
                             Description NVARCHAR(240)
);

CREATE TABLE food (
                      FoodId INTEGER PRIMARY KEY,
                      FoodName NVARCHAR(60),
                      FoodType NVARCHAR(40),
                      PriceInside INTEGER NOT NULL,
                      PriceOutside INTEGER NOT NULL,
                      TotalLeft INTEGER NOT NULL,
                      Description NVARCHAR(240)
                          CHECK ( FoodType IN ('Sandwich',
                                               'Salad',
                                               'Pastry') )
);

CREATE TABLE orders (
                        OrderId INTEGER PRIMARY KEY,
                        ClientId INTEGER,
                        BaristaId INTEGER NOT NULL,
                        OrderType NVARCHAR(20) NOT NULL,
                        Timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
                        Total INTEGER NOT NULL,
                        PaymentStatus NVARCHAR(20) NOT NULL,
                        OrderDetails NVARCHAR(300)
                            CHECK ( PaymentStatus IN ('Payed', 'Unpayed') )
                            CHECK ( OrderType IN ('Inside',
                                                  'To Go') )
);

CREATE TABLE payment (
                         PaymentId INTEGER PRIMARY KEY,
                         OrderID INTEGER UNIQUE NOT NULL,
                         PaymentType NVARCHAR(40),
                         Timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
                         CHECK ( PaymentType IN ('Credit card',
                                                 'PayPal',
                                                 'Cash') )
);

INSERT INTO coffeeshop VALUES ('Star Coffee', '050-000-00-00', 1,
                               'starcoffee@somemail.com',
                               'Some Town, turn right after the second rock, door №9');
INSERT INTO baristas VALUES (10, 'Jerry', 'Seinfeld', 'Morning',
                             '057-555-55-50', 'jerry@somemail.com');
INSERT INTO baristas (FirstName, LastName, Shift, PhoneNumber, Email) VALUES ('Barry', 'Avraham', 'Morning',
                                                                              '057-555-55-51', 'barry@somemail.com');
INSERT INTO baristas (FirstName, LastName, Shift, PhoneNumber, Email) VALUES ('Sally', 'Landon', 'Evening',
                                                                              '057-555-55-52', 'sally@somemail.com');
INSERT INTO baristas (FirstName, LastName, Shift, PhoneNumber, Email) VALUES ('Tracy', 'Chapman', 'Evening',
                                                                              '057-555-55-53', 'tracy@somemail.com');
INSERT INTO managers VALUES (1, 'Stanley', 'Robinson', '059-999-99-99', 'stanley@somemail.com');
INSERT INTO managers (FirstName, LastName, PhoneNumber, Email) VALUES ('John', 'Levinson', '058-888-88-88', 'johnl@somemail.com');
INSERT INTO managers (FirstName, LastName, PhoneNumber, Email) VALUES ('Mary', 'Richardson', '050-234-43-83', 'maryrich@somemail.com');
-- INSERT INTO clients VALUES (100, 'Jerry', null, null, 'jerrbo@somemail.com', 1);
insert into access (Accessid, Login, Password) values (1, 'StanleyTheOwner', 'qwerty');
insert into access (Accessid, Login, Password) values (2, 'Johnny', '987654321');
insert into access (Accessid, Login, Password) values (3, 'MaryRich', 'mary');
insert into access (Accessid, Login, Password) values (10, 'Sweetcoffee', '12345');
insert into access (Accessid, Login, Password) values (11, 'barrythemerry', '54321');
insert into access (Accessid, Login, Password) values (12, 'SL', 'qwertyuiop');
insert into access (Accessid, Login, Password) values (13, 'Andrey', '12345');
insert into access (Accessid, Login, Password) values (101, 'Mary', 'password');
insert into access (Accessid, Login, Password) values (102, 'Gary', '54321');
insert into access (Accessid, Login, Password) values (103, 'Brunster', '12345');


INSERT INTO drinkscoffee
VALUES (100, 'Espresso', 'Arabica', NULL, 'Hot', 5.5, 10.5, 90,
        'Кофейный напиток, отличающийся небольшим объемом, крепкий и приготовленный из зерен мелкого помола под высоким давлением воды.');
INSERT INTO drinkscoffee (DrinkName, CoffeeType, MilkType, Temperature, PriceInside, PriceOutside, TotalLeft,
                          Description)
VALUES ('Americano', 'Robusta', NULL, 'Hot', 6.2, 10, 88, 'Классический эспрессо с добавлением воды');
INSERT INTO drinkscoffee (DrinkName, CoffeeType, MilkType, Temperature, PriceInside, PriceOutside, TotalLeft,
                          Description)
VALUES ('Cappuccino', 'Excelsa', 'Coconut milk', 'Hot', 7.5, 12, 77,
        'Кофейный напиток на основе эспрессо с добавлением в него подогретого вспененного молока.');
INSERT INTO drinkscoffee (DrinkName, CoffeeType, MilkType, Temperature, PriceInside, PriceOutside, TotalLeft,
                          Description)
VALUES ('Latte', 'Liberica', 'Almond milk', 'Hot', 8.5, 12.8, 98,
        'Кофейный напиток, на основе молока, представляющий собой трёхслойную смесь из пены, молока и кофе эспрессо.');
INSERT INTO drinkscoffee (DrinkName, CoffeeType, MilkType, Temperature, PriceInside, PriceOutside, TotalLeft,
                          Description)
VALUES ('Vienna Coffee', 'Arabica', 'Soy milk', 'Hot', 9, 19, 77,
        'Кофейный напиток, приготовленный на основе эспрессо, со взбитыми сливками, посыпанный корицей.');
INSERT INTO drinkscoffee (DrinkName, CoffeeType, MilkType, Temperature, PriceInside, PriceOutside, TotalLeft,
                          Description)
VALUES ('Mead Raf', 'Robusta', 'Milk', 'Cold', 8, 18, 20, 'Кофейный напиток со сливками, ванильным сахаром и мёдом.');
INSERT INTO drinkscoffee (DrinkName, CoffeeType, MilkType, Temperature, PriceInside, PriceOutside, TotalLeft,
                          Description)
VALUES ('Mocha', 'Excelsa', 'Almond Milk', 'Cold', 9, 19, 22,
        'Кофейный напиток, на основе капучино с добавление шоколада.');


INSERT INTO drinksother
VALUES (300, 'Lemonade', 10, 15, 100,
        'Прохладительный безалкогольный напиток, приготовленный на основе газированной воды с добавлением фруктов');
INSERT INTO drinksother (DrinkName, PriceInside, PriceOutside, TotalLeft, Description)
VALUES ('Fruit juice', 12, 17, 80, 'Свежевыжитый апельсиновый сок.');
INSERT INTO drinksother (DrinkName, PriceInside, PriceOutside, TotalLeft, Description)
VALUES ('Mineral water', 11, 16, 90, 'Вода газированная, с содержанием минералов.');
INSERT INTO drinksother (DrinkName, PriceInside, PriceOutside, TotalLeft, Description)
VALUES ('Kvass', 10, 15, 100, 'Классический квас на основе ржаных сухарей и солода');
INSERT INTO drinksother (DrinkName, PriceInside, PriceOutside, TotalLeft, Description)
VALUES ('Coke', 13, 19, 90, 'Ванильная Кока-кола');

INSERT INTO drinkstea
VALUES (200, 'Boba tea', 'Black', 'Coconut milk', 'Hot', 10, 15, 99, 'Классический цейлонский чай');
INSERT INTO drinkstea (DrinkName, TeaType, MilkType, Temperature, PriceInside, PriceOutside, TotalLeft,
                       Description)
VALUES ('Indian green tea', 'Green', 'Soy milk', 'Hot', 10, 15, 98, 'Индийский зеленный чай с ромашкой');
INSERT INTO drinkstea (DrinkName, TeaType, MilkType, Temperature, PriceInside, PriceOutside, TotalLeft,
                       Description)
VALUES ('Jasmine tea', 'Herbal', 'Skimmed milk', 'Hot', 10, 15, 80, 'Цветочный чай на основе жасмина, лаванды и липы.');
INSERT INTO drinkstea (DrinkName, TeaType, MilkType, Temperature, PriceInside, PriceOutside, TotalLeft,
                       Description)
VALUES ('Chamomile tea', 'Herbal', 'Almond milk', 'Hot', 10, 15, 60, 'Цветочный чай на основе ромашки, мяты и розы. ');
INSERT INTO drinkstea (DrinkName, TeaType, MilkType, Temperature, PriceInside, PriceOutside, TotalLeft,
                       Description)
VALUES ('Prince tea', 'Black', NULL, 'Cold', 10, 15, 70, 'Крепкий холодный чай.');

INSERT INTO food
VALUES (400, 'Green salad', 'Salad', 40, 50, 34,
        'Салат из помидоров, сладкого перца, огурцов, феты, шалота и маслин, заправленный оливковым маслом с солью.');
INSERT INTO food (FoodName, FoodType, PriceInside, PriceOutside, TotalLeft, Description)
VALUES ('Vegetable salad', 'Salad', 37, 47, 20,
        'Салат из помидоров, козьего сыра, карамелизированного лука, листьев салата и укропа.');
INSERT INTO food (FoodName, FoodType, PriceInside, PriceOutside, TotalLeft, Description)
VALUES ('Pasta salad', 'Salad', 45, 55, 19,
        'Салат с ветчиной, укропом, помидорами черри, пастой Пенне, заправленной майонезом.');
INSERT INTO food (FoodName, FoodType, PriceInside, PriceOutside, TotalLeft, Description)
VALUES ('Fruit salad', 'Salad', 33, 43, 26, 'Фруктовый салат из яблок, апельсина, банана и груши.');
INSERT INTO food (FoodName, FoodType, PriceInside, PriceOutside, TotalLeft, Description)
VALUES ('Chicken Sandwich', 'Sandwich', 45, 55, 33,
        'Хрустящий сэндвич с копченой курочкой, сыром, помидорами и соусом Цезарь.');
INSERT INTO food (FoodName, FoodType, PriceInside, PriceOutside, TotalLeft, Description)
VALUES ('Egg Sandwich', 'Sandwich', 39, 49, 16, 'Сэндвич с зеленным луком и яйцом.');
INSERT INTO food (FoodName, FoodType, PriceInside, PriceOutside, TotalLeft, Description)
VALUES ('Grilled Cheese', 'Sandwich', 43, 53, 18, 'Сэндвич с 4 разными видами сыра.');
INSERT INTO food (FoodName, FoodType, PriceInside, PriceOutside, TotalLeft, Description)
VALUES ('Ham Sandwich', 'Sandwich', 50, 60, 29, 'Сенвич с кусками ветчины, лука, мариновынных огурцов и салата.');
INSERT INTO food (FoodName, FoodType, PriceInside, PriceOutside, TotalLeft, Description)
VALUES ('Nutella Sandwich', 'Sandwich', 25, 35, 30, 'Фруктовый сэндвич с добавлением нутеллы.');
INSERT INTO food (FoodName, FoodType, PriceInside, PriceOutside, TotalLeft, Description)
VALUES ('Shortcrust', 'Pastry', 5, 7, 90, 'Медовые песочные печенья.');
INSERT INTO food (FoodName, FoodType, PriceInside, PriceOutside, TotalLeft, Description)
VALUES ('Flaky', 'Pastry', 10, 12, 29, 'Выпечка из слоенного теста с добавлением корицы.');
INSERT INTO food (FoodName, FoodType, PriceInside, PriceOutside, TotalLeft, Description)
VALUES ('Puff', 'Pastry', 9, 11, 33, 'Выпечка из слоенного теста с добавлением фруктового джема.');
INSERT INTO food (FoodName, FoodType, PriceInside, PriceOutside, TotalLeft, Description)
VALUES ('Filo', 'Pastry', 7, 9, 44, 'Медовая выпечка из слоенного теста.');
INSERT INTO food (FoodName, FoodType, PriceInside, PriceOutside, TotalLeft, Description)
VALUES ('Choux', 'Pastry', 6, 8, 45, 'Торт Наполеон.');
INSERT INTO food (FoodName, FoodType, PriceInside, PriceOutside, TotalLeft, Description)
VALUES ('Blueberry pie', 'Pastry', 12.5, 13.5, 30, 'Пирог из черники.');

insert into clients (ClientId, FirstName, LastName, PhoneNumber, Email, CoffeeOrders) values (100, 'NULLCLIENT', null, null, 'NULL', 0);
insert into clients (ClientId, FirstName, LastName, PhoneNumber, Email, CoffeeOrders) values (101, 'Mary', '', '', 'mary@somemail.com', 1);
insert into clients (ClientId, FirstName, LastName, PhoneNumber, Email, CoffeeOrders) values (102, 'Gary', 'Brecher', '', 'a@somemail.com', 5);
insert into clients (ClientId, FirstName, LastName, PhoneNumber, Email, CoffeeOrders) values (103, 'Bruni', 'Toratto', '059-771-11-11', 'bt@somemail.com', 3);



insert into orders (OrderId, ClientId, BaristaId, OrderType, Timestamp, Total, PaymentStatus, OrderDetails) values (1421, 101, 11, 'Inside', '2023-01-11 11:21:31', 12.5, 'Payed', 'The order is: Blueberry pie x1.');
INSERT INTO payment (PaymentId, OrderID, PaymentType, Timestamp) VALUES (877, 1421, 'Cash', '2023-01-14 13:30:28');
insert into orders (OrderId, ClientId, BaristaId, OrderType, Timestamp, Total, PaymentStatus, OrderDetails) values (1422, null, 10, 'Inside', '2023-01-12 11:22:41', 20, 'Payed', 'The order is: Mocha x3.');
insert into orders (OrderId, ClientId, BaristaId, OrderType, Timestamp, Total, PaymentStatus, OrderDetails) values (1423, 102, 10, 'Inside', '2023-01-12 11:35:21', 15.3, 'Payed', 'The order is: Espresso x1.');
insert into orders (OrderId, ClientId, BaristaId, OrderType, Timestamp, Total, PaymentStatus, OrderDetails) values (1424, 103, 10, 'Inside', '2023-01-12 12:01:37', 18, 'Payed', 'The order is: Espresso x1.');
insert into orders (OrderId, ClientId, BaristaId, OrderType, Timestamp, Total, PaymentStatus, OrderDetails) values (1425, null, 10, 'Inside', '2023-01-12 12:35:36', 25, 'Payed', 'The order is: Espresso x1.');
insert into orders (OrderId, ClientId, BaristaId, OrderType, Timestamp, Total, PaymentStatus, OrderDetails) values (1426, null, 10, 'Inside', '2023-01-12 12:38:06', 28, 'Payed', 'The order is: Americano x1.');
insert into orders (OrderId, ClientId, BaristaId, OrderType, Timestamp, Total, PaymentStatus, OrderDetails) values (1427, null, 10, 'Inside', '2023-01-12 12:59:13', 27.3, 'Payed', 'The order is: Americano x1.');
insert into orders (OrderId, ClientId, BaristaId, OrderType, Timestamp, Total, PaymentStatus, OrderDetails) values (1428, null, 10, 'Inside', '2023-01-12 13:06:11', 12, 'Payed', 'The order is: Americano x1, Cappuccino x1.');
insert into orders (OrderId, ClientId, BaristaId, OrderType, Timestamp, Total, PaymentStatus, OrderDetails) values (1429, null, 10, 'Inside', '2023-01-12 13:06:42', 12.5, 'Payed', 'The order is: Espresso x1.');
insert into orders (OrderId, ClientId, BaristaId, OrderType, Timestamp, Total, PaymentStatus, OrderDetails) values (1430, null, 10, 'Inside', '2023-01-12 13:12:22', 18, 'Payed', 'The order is: Americano x1.');
insert into orders (OrderId, ClientId, BaristaId, OrderType, Timestamp, Total, PaymentStatus, OrderDetails) values (1431, null, 10, 'Inside', '2023-01-12 13:15:48', 19.4, 'Payed', 'The order is: Espresso x1.');
insert into orders (OrderId, ClientId, BaristaId, OrderType, Timestamp, Total, PaymentStatus, OrderDetails) values (1432, 103, 10, 'To Go', '2023-01-12 13:24:25', 13.5, 'Payed', 'The order is: Americano x1, Cappuccino x1. ');
insert into orders (OrderId, ClientId, BaristaId, OrderType, Timestamp, Total, PaymentStatus, OrderDetails) values (1433, null, 10, 'Inside', '2023-01-12 13:30:45', 15, 'Payed', 'The order is: Americano x1.');
insert into orders (OrderId, ClientId, BaristaId, OrderType, Timestamp, Total, PaymentStatus, OrderDetails) values (1434, null, 10, 'To Go', '2023-01-12 13:31:03', 16, 'Payed', 'The order is: Mineral water x1.');
insert into orders (OrderId, ClientId, BaristaId, OrderType, Timestamp, Total, PaymentStatus, OrderDetails) values (1435, 103, 10, 'To Go', '2023-01-12 13:31:23', 16, 'Payed', 'The order is: Americano x1.');
insert into orders (OrderId, ClientId, BaristaId, OrderType, Timestamp, Total, PaymentStatus, OrderDetails) values (1436, 102, 10, 'Inside', '2023-01-13 14:58:22', 86, 'Payed', 'The order is: Espresso x5, Americano x12.');
insert into orders (OrderId, ClientId, BaristaId, OrderType, Timestamp, Total, PaymentStatus, OrderDetails) values (1437, null, 10, 'To Go', '2023-01-13 16:45:45', 10.3, 'Payed', 'The order is: Espresso x1.');
insert into orders (OrderId, ClientId, BaristaId, OrderType, Timestamp, Total, PaymentStatus, OrderDetails) values (1438, null, 10, 'To Go', '2023-01-14 13:25:30', 10.6, 'Payed', 'The order is: Espresso x1.');
insert into orders (OrderId, ClientId, BaristaId, OrderType, Timestamp, Total, PaymentStatus, OrderDetails) values (1439, 101, 10, 'To Go', '2023-01-14 13:30:28', 19, 'Payed', 'The order is: Mocha x1.');
insert into orders (OrderId, ClientId, BaristaId, OrderType, Timestamp, Total, PaymentStatus, OrderDetails) values (1440, null, 13, 'Inside', '2023-01-15 08:46:06', 12, 'Payed', 'The order is:.');
insert into orders (OrderId, ClientId, BaristaId, OrderType, Timestamp, Total, PaymentStatus, OrderDetails) values (1441, null, 13, 'Inside', '2023-01-15 08:46:07', 11, 'Payed', 'The order is:.');
insert into orders (OrderId, ClientId, BaristaId, OrderType, Timestamp, Total, PaymentStatus, OrderDetails) values (1442, null, 13, 'Inside', '2023-01-15 08:46:08', 15.6, 'Payed', 'The order is:.');


CREATE VIEW full_login_info as
SELECT Accessid, Login, Password, Email
FROM access, managers
WHERE Accessid = ManagerId
UNION
SELECT Accessid, Login, Password, Email
FROM access, baristas
WHERE Accessid = BaristaId
UNION
SELECT  Accessid, Login, Password, Email
FROM access, clients
WHERE Accessid = ClientId;

CREATE VIEW full_menu as
SELECT drinkid ItemId, drinkname ItemName, coffeetype ItemType, milktype, temperature, priceinside, priceoutside, totalleft, description
FROM drinkscoffee
UNION
SELECT *
FROM drinkstea
UNION
SELECT drinksother.DrinkId, drinksother.DrinkName, null, null, null, drinksother.PriceInside, drinksother.PriceOutside, drinksother.TotalLeft, drinksother.Description
FROM drinksother
UNION
SELECT food.foodid, food.foodname, food.foodtype, null, null, food.priceinside, food.priceoutside, food.totalleft, food.description
FROM food;