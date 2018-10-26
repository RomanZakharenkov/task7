CREATE SCHEMA game;

CREATE TABLE game.hero (
  id            BIGSERIAL PRIMARY KEY,
  name          CHARACTER VARYING(128) UNIQUE NOT NULL,
  gender        CHARACTER VARYING(128)        NOT NULL,
  first_melee   CHARACTER VARYING(128)        NOT NULL,
  first_ranged  CHARACTER VARYING(128)        NOT NULL,
  second_melee  CHARACTER VARYING(128)        NOT NULL,
  second_ranged CHARACTER VARYING(128)        NOT NULL
);

DROP TABLE game.hero;