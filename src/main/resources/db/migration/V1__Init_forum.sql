create sequence hibernate_sequence start 1 increment 1;

create table message (
      id_message_pk int8 not null,
      date varchar(255),
      filename varchar(255),
      tag varchar(255),
      text varchar(4096) not null,
      user_id_fk int8,
      topic_id_fk int8,
      primary key (id_message_pk)
);

create table topic (
      id_topic_pk int8 not null,
      name varchar(255),
      primary key (id_topic_pk)
);

create table user_role (
      user_id int8 not null,
      roles varchar(255)
);

create table usr (
      id int8 not null,
      active boolean not null,
      password varchar(255) not null,
      username varchar(255) not null,
      primary key (id)
);

alter table if exists message
add constraint FKp462oh5kd4bdqxji3tldqwv0c
foreign key (user_id_fk) references usr;

alter table if exists message
add constraint FKmh65bf501ojpedc1pfxsl4hlo
foreign key (topic_id_fk) references topic;

alter table if exists user_role
add constraint FKfpm8swft53ulq2hl11yplpr5
foreign key (user_id) references usr;