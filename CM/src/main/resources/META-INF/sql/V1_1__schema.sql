CREATE SEQUENCE postcontent_id_seq;

CREATE TABLE postcontent (
  id INTEGER NOT NULL DEFAULT nextval('postcontent_id_seq'),
  post_id INTEGER,
  post_content VARCHAR,
  CONSTRAINT postcontent_id PRIMARY KEY (id)
);

ALTER SEQUENCE postcontent_id_seq OWNED BY postcontent.id;