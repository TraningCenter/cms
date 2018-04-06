CREATE SEQUENCE userposts_id_seq;

CREATE TABLE userposts (
  id INTEGER NOT NULL DEFAULT nextval('userposts_id_seq'),
  user_id INTEGER,
  post_id INTEGER,
  CONSTRAINT userposts_id PRIMARY KEY (id)
);

ALTER SEQUENCE userposts_id_seq OWNED BY userposts.id;