CREATE TABLE t_city(
    city_id BIGSERIAL PRIMARY KEY,
    t_name VARCHAR(255)
);
CREATE TABLE t_category(
    category_id BIGSERIAL PRIMARY KEY,
    t_name VARCHAR(255)
);
CREATE TABLE t_gym(
    gym_id BIGSERIAL PRIMARY KEY,
    t_name VARCHAR(255),
    city_id BIGINT,
    CONSTRAINT fk_gym_city FOREIGN KEY(city_id) REFERENCES t_city(city_id) ON DELETE CASCADE
);
CREATE TABLE gym_category(
    gym_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    CONSTRAINT fk_gym_category_gym FOREIGN KEY(gym_id)
    REFERENCES t_gym(gym_id) ON DELETE CASCADE,
    CONSTRAINT fk_gym_category_category FOREIGN KEY(category_id)
    REFERENCES t_category(category_id) ON DELETE CASCADE,
    PRIMARY KEY(gym_id,category_id)
);
CREATE TABLE t_user(
    user_id BIGSERIAL PRIMARY KEY,
    t_username VARCHAR(255),
    t_email VARCHAR(255),
    t_password VARCHAR(255)
);
CREATE TABLE t_permission(
    permission_id BIGSERIAL PRIMARY KEY,
    t_name VARCHAR(255)
);
CREATE TABLE t_user_permissions(
    user_id BIGINT NOT NULL,
    permission_id BIGINT NOT NULL,
    CONSTRAINT t_user_permissions_user FOREIGN KEY(user_id)
    REFERENCES t_user(user_id) ON DELETE CASCADE,
    CONSTRAINT t_user_permissions_permission FOREIGN KEY(permission_id)
    REFERENCES t_permission(permission_id) ON DELETE CASCADE,
    PRIMARY KEY(user_id,permission_id)
)