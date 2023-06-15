create table account (
                         id number generated always as identity primary key,
                         name varchar(255),
                         email varchar(255),
                         mobile_number varchar(15),
                         account_number varchar(10),
                         account_type_id number,
                         address varchar(255),
                         password varchar2(100)
);

create table account_type (
                              id number generated always as identity,
                              name varchar(255),
                              primary key (id)
);

alter table account add constraint account_type_account_const
    foreign key (account_type_id) references account_type;

create table transactions (
                              id number generated always as identity,
                              account_id number,
                              transaction_date date,
                              summary varchar(255),
                              withdrawal real,
                              deposit real,
                              closing_balance real,
                              primary key (id)
);

alter table transactions add constraint account_transactions_const
    foreign key (account_id) references account;

create table loans (
                       id number generated always as identity,
                       account_id number,
                       start_date date,
                       type_loans_id number,
                       total_loan real,
                       amount_pay real,
                       outstanding_amt real,
                       primary key (id)
);

alter table loans add constraint account_loans_const
    foreign key (account_id) references account;

create table type_loans (
                            id number generated always as identity,
                            name varchar(255),
                            primary key (id)
);

alter table loans add constraint loans_type_loans_const
    foreign key (type_loans_id) references type_loans;

create table card (
                      id number generated always as identity,
                      account_id number,
                      card_number varchar(20),
                      card_expired_date date,
                      card_type_id number,
                      total_limit real,
                      amount_used real,
                      available_amt real,
                      primary key (id)
);

alter table card add constraint account_card_const
    foreign key (account_id) references account;

create table card_type (
                           id number generated always as identity,
                           name varchar(255),
                           primary key (id)
);

alter table card add constraint card_card_type_const
    foreign key (card_type_id) references card_type;

create table messages (
                          id number generated always as identity,
                          name varchar(255),
                          email varchar(255),
                          subject varchar(255),
                          message varchar2(4000),
                          sent_date date,
                          status_type_id number,
                          primary key (id)
);

create table status_type (
                             id number generated always as identity,
                             name varchar(255),
                             primary key (id)
);

alter table messages add constraint messages_status_type_const
    foreign key (status_type_id) references status_type;

create table news (
                      id number generated always as identity,
                      title varchar(255),
                      body varchar2(4000),
                      image_url varchar(255),
                      create_date date,
                      primary key (id)
);

