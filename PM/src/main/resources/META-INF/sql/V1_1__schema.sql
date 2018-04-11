CREATE SEQUENCE users_id_seq;

CREATE TABLE users (
  id INTEGER NOT NULL DEFAULT nextval('users_id_seq'),
  username VARCHAR,
  CONSTRAINT users_id PRIMARY KEY (id)
);

ALTER SEQUENCE users_id_seq OWNED BY users.id;





CREATE SEQUENCE userposts_id_seq;

CREATE TABLE userposts (
  id INTEGER NOT NULL DEFAULT nextval('userposts_id_seq'),
  user_id INTEGER REFERENCES users(id),
  post_id INTEGER,
  CONSTRAINT userposts_id PRIMARY KEY (id),
  CONSTRAINT fkey FOREIGN KEY (user_id) REFERENCES users(id)
);

ALTER SEQUENCE userposts_id_seq OWNED BY userposts.id;