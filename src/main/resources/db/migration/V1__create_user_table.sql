
create table ADDRESS
(
    ID          integer primary key,
    STREETNAME  varchar(52),
    HOUSENUMBER varchar(52),
    BOXNUMBER   varchar(52),
    CITY        varchar(52) not null,
    POSTALCODE  varchar(52)
);

create table USERS
(
    ID                              integer primary key,
    FIRSTNAME                       varchar(52) not null,
    LASTNAME                        varchar(52) not null,
    EMAIL                           varchar(52) not null,
    MOBILE_PHONE_COUNTRY_CODE       varchar(52) not null,
    MOBILE_PHONE_LOCAL_PHONE_NUMBER varchar(52) not null,
    FK_ADDRESS_ID                   bigint
        constraint FK_ADDRESS_ID
            references ADDRESS,
    ROLE        varchar(52) not null,
    PASSWORD    varchar(52) not null
);

CREATE SEQUENCE user_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 10000
    cycle;

CREATE SEQUENCE address_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 10000
    cycle;