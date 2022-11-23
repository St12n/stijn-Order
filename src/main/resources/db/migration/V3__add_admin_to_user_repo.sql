insert into address (id, streetname, housenumber, boxnumber, city, postalcode)
values (nextval('address_seq'), null, null, null, 'ADMIN', null);

insert into users (id, firstname, lastname, email, mobile_phone_country_code, mobile_phone_local_phone_number,
                   fk_address_id, role, password)
values (nextval('user_seq'), 'Stijn', 'The Admin', 'admin@order.be', '0032', '495121314', 1, 'ADMIN', 'password');