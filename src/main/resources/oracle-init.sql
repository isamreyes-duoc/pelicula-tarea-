-- ============================================================
-- SCRIPT DE INICIALIZACION - BASE DE DATOS ORACLE
-- Ejecutar este script UNA SOLA VEZ en Oracle antes de
-- iniciar el microservicio.
-- ============================================================

-- 1. Crear la secuencia para el ID autoincrementable
CREATE SEQUENCE PELICULA_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

-- 2. Crear la tabla PELICULAS
CREATE TABLE PELICULAS (
    ID       NUMBER(19)    NOT NULL,
    TITULO   VARCHAR2(200) NOT NULL,
    ANIO     NUMBER(4),
    DIRECTOR VARCHAR2(100),
    GENERO   VARCHAR2(50),
    SINOPSIS VARCHAR2(1000),
    CONSTRAINT PK_PELICULAS PRIMARY KEY (ID)
);

-- 3. Insertar al menos 5 peliculas de ejemplo
INSERT INTO PELICULAS (ID, TITULO, ANIO, DIRECTOR, GENERO, SINOPSIS)
VALUES (PELICULA_SEQ.NEXTVAL, 'El Viaje de Chihiro', 2001, 'Hayao Miyazaki', 'Animacion',
        'Una nina de 10 anos se adentra en un mundo magico poblado por espiritus donde debe trabajar para liberar a sus padres de una maldicion.');

INSERT INTO PELICULAS (ID, TITULO, ANIO, DIRECTOR, GENERO, SINOPSIS)
VALUES (PELICULA_SEQ.NEXTVAL, 'Mi Vecino Totoro', 1988, 'Hayao Miyazaki', 'Animacion',
        'Dos hermanas se mudan al campo con su padre y descubren criaturas magicas del bosque, incluido el amigable Totoro.');

INSERT INTO PELICULAS (ID, TITULO, ANIO, DIRECTOR, GENERO, SINOPSIS)
VALUES (PELICULA_SEQ.NEXTVAL, 'La Princesa Mononoke', 1997, 'Hayao Miyazaki', 'Animacion',
        'Un joven guerrero busca la cura para una maldicion y se ve envuelto en la guerra entre humanos y dioses del bosque.');

INSERT INTO PELICULAS (ID, TITULO, ANIO, DIRECTOR, GENERO, SINOPSIS)
VALUES (PELICULA_SEQ.NEXTVAL, 'El Chico y la Garza', 2023, 'Hayao Miyazaki', 'Animacion',
        'Un joven encuentra un mundo fantastico a traves de una antigua torre despues de la muerte de su madre durante la Segunda Guerra Mundial.');

INSERT INTO PELICULAS (ID, TITULO, ANIO, DIRECTOR, GENERO, SINOPSIS)
VALUES (PELICULA_SEQ.NEXTVAL, 'Kiki: Entregas a Domicilio', 1989, 'Hayao Miyazaki', 'Animacion',
        'Una joven bruja de 13 anos se muda a una nueva ciudad para completar su entrenamiento como bruja usando su escoba voladora.');

INSERT INTO PELICULAS (ID, TITULO, ANIO, DIRECTOR, GENERO, SINOPSIS)
VALUES (PELICULA_SEQ.NEXTVAL, 'El Castillo Ambulante', 2004, 'Hayao Miyazaki', 'Animacion',
        'Una joven convertida en anciana por una maldicion busca ayuda del misterioso mago Howl y su castillo ambulante.');

-- 4. Confirmar los cambios
COMMIT;

-- Verificar que los datos se insertaron correctamente
SELECT * FROM PELICULAS;
