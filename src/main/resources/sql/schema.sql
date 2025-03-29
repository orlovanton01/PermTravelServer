drop table if exists public.places;

create table if not exists public.places(
     id UUID PRIMARY KEY,
     name VARCHAR(100) NOT NULL,
     description TEXT NOT NULL,
     photoPath VARCHAR(100) NOT NULL,
     latitude REAL NOT NULL,
     longitude REAL NOT NULL
 );