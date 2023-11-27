CREATE TABLE district_regions
(
    id                 INT          NOT NULL,
    name               VARCHAR(255) NOT NULL,
    description        VARCHAR(255) NOT NULL,
    thumbnail_image    VARCHAR(255) NOT NULL,
    main_image         VARCHAR(255) NOT NULL,
    province_region_id INT          NOT NULL,
    CONSTRAINT pk_district_regions PRIMARY KEY (id)
);

CREATE TABLE province_regions
(
    id              INT          NOT NULL,
    name            VARCHAR(255) NOT NULL,
    description     VARCHAR(255) NOT NULL,
    thumbnail_image VARCHAR(255) NOT NULL,
    main_image      VARCHAR(255) NOT NULL,
    CONSTRAINT pk_province_regions PRIMARY KEY (id)
);

ALTER TABLE district_regions
    ADD CONSTRAINT FK_DISTRICT_REGIONS_ON_PROVINCE_REGION FOREIGN KEY (province_region_id) REFERENCES province_regions (id);