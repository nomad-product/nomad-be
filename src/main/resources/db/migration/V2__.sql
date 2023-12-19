CREATE TABLE region_reviews
(
    id                 BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    created_at         TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at         TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    user_name          VARCHAR(255)     NOT NULL,
    rating             DOUBLE PRECISION NOT NULL,
    content OID NOT NULL,
    province_region_id BIGINT,
    CONSTRAINT pk_region_reviews PRIMARY KEY (id)
);

CREATE UNIQUE INDEX IX_pk_district_regions ON district_regions (id);

CREATE UNIQUE INDEX IX_pk_province_regions ON province_regions (id);

ALTER TABLE region_reviews
    ADD CONSTRAINT FK_REGION_REVIEWS_ON_PROVINCE_REGION FOREIGN KEY (province_region_id) REFERENCES province_regions (id);