create table ADDRESS
(
    ID bigint not null
        primary key,
    STREETNAME
)

create table USER
(
    ID                              integer unique not null,
    FIRSTNAME                       varchar(52)    not null,
    LASTNAME                        varchar(52)    not null,
    EMAIL                           varchar(52)    not null,
    MOBILE_PHONE_COUNTRY_CODE       varchar(52)    not null,
    MOBILE_PHONE_LOCAL_PHONE_NUMBER varchar(52)    not null,
    FK_ADDRESS_ID                   bigint
        constraint FK_ADDRESS_ID
            references ADDRESS,
    ROLE                            varchar(52)    not null
);