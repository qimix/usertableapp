CREATE TABLE PERSONS(
    id Long,
    name CHARACTER VARYING(100),
    surname CHARACTER VARYING(100),
    age INTEGER, phone_number BIGINT,
    city_of_living CHARACTER VARYING(100),
    PRIMARY KEY (name, surname, age)
    );