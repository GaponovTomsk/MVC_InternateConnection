INSERT INTO CITY (NAME) VALUES
                            ('Rostov'),
                            ('Voronej'),
                            ('Anapa');


INSERT INTO STREET (NAME) VALUES
                              ('Lenina'),
                              ('Marx'),
                              ('Pobeda');

INSERT INTO city_street(CITY_ID, STREET_ID)values
                                               (1,1),
                                               (1,3),
                                               (2,1),
                                               (3,1),
                                               (3,2),
                                               (3,3);