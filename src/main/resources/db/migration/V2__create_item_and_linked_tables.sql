create table ITEM
(
    ITEM_ID          bigint           not null
        primary key,
    ITEM_NAME        varchar(52)      not null,
    ITEM_DESCRIPTION varchar(52)      not null,
    PRICE_AMOUNT     double precision not null,
    PRICE_CURRENCY   varchar(52)      not null,
    AMOUNT_IN_STOCK  double precision not null,
    STOCK_UNIT       varchar(52)      not null
);

CREATE SEQUENCE item_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 10000
    cycle;