CREATE TABLE users (
    id TEXT PRIMARY KEY UNIQUE NOT NULL ,
    name TEXT NOT NULL,
    active INT NOT NULL,
    password TEXT NOT NULL
);