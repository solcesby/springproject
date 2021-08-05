CREATE TABLE public.users
(
    id         uuid                NOT NULL
        CONSTRAINT users_pkey
            PRIMARY KEY,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    phone      VARCHAR(255),
    email      VARCHAR(255) UNIQUE NOT NULL,
    password   VARCHAR(255)        NOT NULL,
    created_at TIMESTAMP           NOT NULL,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP
);

ALTER TABLE public.users
    OWNER TO postgres;

CREATE TABLE user_roles
(
    id      BIGINT GENERATED BY DEFAULT AS IDENTITY
        CONSTRAINT user_roles_pkey
            PRIMARY KEY,
    role    VARCHAR(255),
    user_id uuid
        CONSTRAINT fk5prxsdxrxjmldl8u51kc11y3e
            REFERENCES users
);

ALTER TABLE user_roles
    OWNER TO postgres;

CREATE TABLE public.email
(
    id            uuid                NOT NULL
        CONSTRAINT email_pkey
            PRIMARY KEY,
    last_sent_at  TIMESTAMP,
    email_address VARCHAR(255) UNIQUE NOT NULL
);

ALTER TABLE public.email
    OWNER TO postgres;