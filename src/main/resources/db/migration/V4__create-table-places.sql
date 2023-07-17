CREATE TABLE places (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name TEXT NOT NULL,
    address TEXT NOT NULL,
    cities_id TEXT REFERENCES cities(id) ON DELETE RESTRICT ON UPDATE CASCADE NOT NULL,
    categories_id TEXT REFERENCES categories(id) ON DELETE RESTRICT ON UPDATE CASCADE NOT NULL,
    value_in_cents INT NOT NULL
)