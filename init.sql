CREATE DATABASE deneme;

\c deneme;
CREATE TABLE example_table (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100)
);