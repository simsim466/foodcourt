DELETE FROM RESTAURANTS;
DELETE FROM USERS;
DELETE FROM MEALS;
DELETE FROM MEALS_DISHES;
DELETE FROM DISHES;
DELETE FROM VOTES;
DELETE FROM USER_ROLES;

ALTER SEQUENCE GLOBAL_SEQ RESTART WITH 1000;

INSERT INTO users (name, password)
VALUES ('Лев', 'Толстой'),
       ('Антон', 'Чехов'),
       ('Алексей', 'Иванов'),
       ('Ernest', 'Hemingway'),
       ('Erich', 'Remark'),
       ('Федор', 'Достоевский'),
       ('Анна', 'Ахматова'),
       ('Milorad', 'Pavic'),
       ('Владимир', 'Высоцкий'),
       ('Михаил_2', 'Булгаков'),
       ('Jack', 'London'),
       ('Albert', 'Camus'),
       ('Николай', 'Гоголь'),
       ('Ivo', 'Andric'),
       ('Михаил', 'Шелохов');

INSERT INTO RESTAURANTS (NAME, CREATOR_USER_ID)
VALUES ('Astoria', 1001),
       ('MacDonalds', 1003),
       ('Тарас Бульба', 1012),
       ('Шоколадница', 1001);

INSERT INTO MEALS (DATE, RESTAURANT_ID)
VALUES
       ('2021-05-01 0:00:00', 1018),
       ('2021-05-01 0:00:00', 1016),
       ('2021-05-02 0:00:00', 1016),
       ('2021-05-02 0:00:00', 1018),
       ('2021-05-03 0:00:00', 1017),
       ('2021-05-03 0:00:00', 1016),
       ('2021-05-03 0:00:00', 1015),
       ('2021-05-03 0:00:00', 1018),
       ('2021-05-04 0:00:00', 1018),
       ('2021-05-04 0:00:00', 1016),
       ('2021-05-04 0:00:00', 1017),
       /*новые данные*/
       ('2021-05-25 0:00:00', 1015),
       ('2021-05-25 0:00:00', 1017),
       ('2021-05-25 0:00:00', 1018),
       ('2021-05-25 0:00:00', 1016);

INSERT INTO DISHES (NAME, PRICE)
VALUES ('Яичница', 50),
       ('Борщ', 100),
       ('Овсянная каша', 70),
       ('Сосиски с горошком', 80),
       ('Каша молочная рисовая', 60),
       ('Запеканка творожная', 40),
       ('Компот вишневый', 30),
       ('Сок яблочный', 45),
       ('Пиво темное', 90),
       ('Чай черный', 20),
       ('Какао', 23),
       ('Coca-cola', 29),
       ('Fanta', 29),
       ('Суп харчо', 120),
       ('Борщ украинский', 140),
       ('Уха царская', 150),
       ('Сало с чесноком', 55),
       ('Черный хлеб', 35),
       ('Гамбургер', 50),
       ('Чизбургер', 50),
       ('Картофель фри', 75);

INSERT INTO USER_ROLES (USER_ID, ROLE)
VALUES (1000, 'USER'),
       (1001, 'USER'),
       (1002, 'USER'),
       (1003, 'USER'),
       (1004, 'USER'),
       (1005, 'USER'),
       (1006, 'USER'),
       (1007, 'USER'),
       (1008, 'USER'),
       (1009, 'USER'),
       (1010, 'USER'),
       (1011, 'USER'),
       (1012, 'USER'),
       (1013, 'USER'),
       (1014, 'USER'),
       (1001, 'ADMIN'),
       (1003, 'ADMIN'),
       (1012, 'ADMIN'),
       (1001, 'SUPERADMIN');


INSERT INTO MEALS_DISHES (MEAL_ID, DISH_ID)
VALUES (1019, 1038),
       (1020, 1038),
       (1021, 1038),
       (1022, 1038),
       (1023, 1038),
       (1024, 1038),
       (1025, 1038),
       (1026, 1038),
       (1027, 1038),
       (1028, 1038),
       (1029, 1038),
       (1030, 1038),
       (1031, 1038),
       (1032, 1038),
       (1033, 1042),
       (1030, 1045),
       (1031, 1046),
       (1032, 1047),
       (1032, 1048),
       (1033, 1049);

INSERT INTO VOTES (DATE, USER_ID, MEAL_ID)
VALUES ('2021-05-01 0:00:00', 1000, 1027),
       ('2021-05-01 0:00:00', 1001, 1027),
       ('2021-05-02 0:00:00', 1002, 1028),
       ('2021-05-02 0:00:00', 1003, 1028),
       ('2021-05-03 0:00:00', 1004, 1027),
       ('2021-05-03 0:00:00', 1005, 1027),
       ('2021-05-03 0:00:00', 1006, 1029),
       ('2021-05-03 0:00:00', 1007, 1027),
       ('2021-05-04 0:00:00', 1008, 1027),
       ('2021-05-04 0:00:00', 1009, 1029),
       ('2021-05-04 0:00:00', 1010, 1027),
       ('2021-05-04 0:00:00', 1011, 1027),
       ('2021-05-04 0:00:00', 1012, 1027),
       ('2021-05-04 0:00:00', 1013, 1027),
       ('2021-05-04 0:00:00', 1014, 1029),
       /*голосование за сегодня*/
       ('2021-05-22 0:00:00', 1000, 1033),
       ('2021-05-22 0:00:00', 1001, 1033),
       ('2021-05-22 0:00:00', 1002, 1031),
       ('2021-05-22 0:00:00', 1003, 1031),
       ('2021-05-22 0:00:00', 1004, 1031),
       ('2021-05-22 0:00:00', 1005, 1030),
       ('2021-05-22 0:00:00', 1006, 1030),
       ('2021-05-22 0:00:00', 1007, 1030),
       ('2021-05-22 0:00:00', 1008, 1030),
       ('2021-05-22 0:00:00', 1009, 1033),
       ('2021-05-22 0:00:00', 1010, 1032),
       ('2021-05-22 0:00:00', 1011, 1032),
       ('2021-05-22 0:00:00', 1012, 1031),
       ('2021-05-22 0:00:00', 1013, 1031),
       ('2021-05-22 0:00:00', 1014, 1031);

