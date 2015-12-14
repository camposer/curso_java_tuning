CREATE TABLE persona (
        id INTEGER NOT NULL
                GENERATED ALWAYS AS IDENTITY
                (START WITH 1, INCREMENT BY 1),
        nombre VARCHAR(50) NOT NULL,
        apellido VARCHAR(50) NOT NULL,
        fecha_nacimiento DATE,
        PRIMARY KEY(id)
);

CREATE TABLE ordenador (
        id INTEGER NOT NULL
                GENERATED ALWAYS AS IDENTITY
                (START WITH 1, INCREMENT BY 1),
        persona_id INTEGER NOT NULL,
        nombre VARCHAR(50) NOT NULL,
        serial VARCHAR(50) NOT NULL,
        PRIMARY KEY(id),
        FOREIGN KEY (persona_id) REFERENCES persona(id)
);

SELECT * FROM persona;