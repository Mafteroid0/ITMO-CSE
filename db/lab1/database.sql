
CREATE TABLE Patient (
    Id SERIAL PRIMARY KEY,
    Name VARCHAR(70) NOT NULL,
    Date DATE NOT NULL
);

CREATE TABLE Child (
    Id SERIAL PRIMARY KEY,
    parent_id INTEGER REFERENCES Patient(Id),
    Gender VARCHAR(1) NOT NULL,
    Height INTEGER CHECK(Height > 0)
);

CREATE TABLE City (
    Id SERIAL PRIMARY KEY,
    Name VARCHAR(50) UNIQUE NOT NULL,
    Weather VARCHAR(20),
    Country VARCHAR(50) NOT NULL,
    Population INTEGER CHECK(Population > 0)
);

CREATE TABLE Hospital (
    Id SERIAL PRIMARY KEY,
    Roof_material VARCHAR(50) NOT NULL,
    Type VARCHAR(50) NOT NULL,
    City_id INTEGER REFERENCES City(Id)
);

CREATE TABLE Doctor (
    Id SERIAL PRIMARY KEY,
    Name VARCHAR(50),
    Profession VARCHAR(50) NOT NULL,
    Hospital_id INTEGER REFERENCES Hospital(Id)
);

CREATE TABLE Event (
    Child_id INTEGER PRIMARY KEY REFERENCES Child(Id),
    Name VARCHAR(150) NOT NULL,
    Is_good BOOLEAN NOT NULL
);

CREATE TABLE doctor_patient (
    Doctor_id INTEGER REFERENCES Doctor(Id),
    Patient_id INTEGER REFERENCES Patient(Id),
    PRIMARY KEY (Doctor_id, Patient_id)
);

END;