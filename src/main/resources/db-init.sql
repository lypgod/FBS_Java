drop table if exists hibernate_sequence;
drop table if exists User;
create table hibernate_sequence (
  next_val bigint
) ENGINE=InnoDB;
insert into hibernate_sequence values ( 1 );
create table User (
  id integer not null,
  password varchar(255),
  userName varchar(255) not null,
  primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table User
  add constraint UK_hl8fftx66p59oqgkkcfit3eay unique (userName);