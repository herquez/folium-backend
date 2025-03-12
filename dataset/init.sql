SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;


-- Create ENUM types
CREATE TYPE plant_type AS ENUM (
    'LIANA', 'SUBSHRUB', 'SHRUB', 'TREE', 'PARASITE'
);

CREATE TYPE plant_cycle AS ENUM (
    'ANNUAL', 'BIENNIAL', 'PERENNIAL'
);

CREATE TYPE watering_frequency AS ENUM (
    'FREQUENT', 'AVERAGE', 'MINIMUM', 'NONE'
);

CREATE TYPE watering_unit AS ENUM (
    'HOURS', 'DAYS', 'WEEKS'
);

CREATE TYPE leaf_color AS ENUM (
    'DARK_GREEN', 'ORANGE', 'YELLOW', 'LIGHT_GREEN', 
    'PURPLE', 'RED', 'VARIEGATED'
);

CREATE TYPE season AS ENUM (
    'SPRING', 'SUMMER', 'FALL', 'WINTER'
);

CREATE TYPE harvest_method_type AS ENUM (
    'CUTTING', 'PRUNING', 'DIGGING', 'MANUAL'
);

CREATE TYPE growth_rate AS ENUM (
    'HIGH', 'MEDIUM', 'LOW'
);

CREATE TYPE maintenance_level AS ENUM (
    'HIGH', 'MEDIUM', 'LOW'
);

CREATE TYPE care_level AS ENUM (
    'HIGH', 'MEDIUM', 'LOW'
);

-- Create tables if not exists
CREATE TABLE IF NOT EXISTS plants (
    id SERIAL PRIMARY KEY,
    common_name VARCHAR(255) NOT NULL,
    other_names TEXT[],
    type plant_type NOT NULL,
    cycle plant_cycle NOT NULL,
    watering watering_frequency NOT NULL,
    watering_value_max NUMERIC(5,2),
    watering_value_min NUMERIC(5,2),
    watering_unit watering_unit,
    leaves_color leaf_color[],
    flowers BOOLEAN NOT NULL,
    flower_season season,
    fruits BOOLEAN NOT NULL,
    fruiting_season season,
    harvest_method harvest_method_type,
    growth_rate growth_rate NOT NULL,
    maintenance maintenance_level NOT NULL,
    medical BOOLEAN NOT NULL,
    poisonous_to_humans BOOLEAN NOT NULL,
    poisonous_to_pets BOOLEAN NOT NULL,
    cuisine BOOLEAN NOT NULL,
    indoor BOOLEAN NOT NULL,
    care_level care_level NOT NULL
);

CREATE TABLE IF NOT EXISTS propagation_methods (
    id SERIAL PRIMARY KEY,
    method VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS plant_propagation (
    plant_id INT NOT NULL REFERENCES plants(id) ON DELETE CASCADE,
    propagation_method_id INT NOT NULL REFERENCES propagation_methods(id) ON DELETE CASCADE,
    PRIMARY KEY (plant_id, propagation_method_id)
);

CREATE TABLE IF NOT EXISTS sunlight_requirements (
    id SERIAL PRIMARY KEY,
    requirement VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS plant_sunlight (
    plant_id INT NOT NULL REFERENCES plants(id) ON DELETE CASCADE,
    sunlight_requirement_id INT NOT NULL REFERENCES sunlight_requirements(id) ON DELETE CASCADE,
    PRIMARY KEY (plant_id, sunlight_requirement_id)
);

-- Insert initial data
INSERT INTO propagation_methods (method) VALUES
    ('SEED'),
    ('CUTTING'),
    ('GRAFTING'),
    ('DIVISION');

INSERT INTO sunlight_requirements (requirement) VALUES
    ('FULL_SUN'),
    ('PART_SHADE'),
    ('FULL_SHADE'),
    ('PARTIAL_SUN'),
    ('FILTERED_SUN');
