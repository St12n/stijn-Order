create table orders
(
    order_id bigint not null
        primary key,
    price_amount double precision not null,
    price_currency varchar(52) not null
);

create table itemgroups
(
    itemgroup_id    bigint not null
        primary key,
    fk_order_id     bigint
        constraint fk_order_id
            references orders,
    ordered_item_id bigint not null,
    order_amount    double precision,
    order_unit      varchar(52),
    shipping_date date,
    price_amount double precision not null,
    price_currency varchar(52) not null
);

CREATE SEQUENCE order_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 10000
    cycle;

CREATE SEQUENCE item_group_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 10000
    cycle;

