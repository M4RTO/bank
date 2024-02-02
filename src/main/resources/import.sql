insert into MOVEMENT_TYPE (id, name) values (1, 'DEPOSIT');
insert into MOVEMENT_TYPE (id, name) values (2, 'WITHDRAW');
insert into MOVEMENT_TYPE (id, name) values (3, 'COMISSION');
insert into MOVEMENT_TYPE (id, name) values (4, 'OUTGOING_TRANSFER');
insert into MOVEMENT_TYPE (id, name) values (5, 'ICONMING_TRANSFER');

insert into MOVEMENT (AMOUNT, CREATED_ON, ACCOUNT_ID, ID, TYPE_ID, DESCRIPTION) values (35.50, TIMESTAMP '2020-06-14T00.00.00', 1, 1, 1, 'una transaccion mas');

