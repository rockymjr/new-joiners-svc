create table employee
(
    id             int not null auto_increment,
    name           varchar(255),
    email          varchar(255),
    contact_number varchar(255),
    is_manager     char(1),
    is_hr_spocs    char(1),
    primary key (id)
);

create table new_joiners
(
    id                      int not null auto_increment,
    name                    varchar(255),
    email                   varchar(255),
    contact_number          varchar(255),
    joining_date            date,
    last_follow_up_date     date,
    induction_status        varchar(255),
    project_name            varchar(255),
    project_allocation_date date,
    status                  varchar(255),
    manager_id              int,
    hr_spocs_id             int,
    foreign key (hr_spocs_id) references Employee (id),
    foreign key (manager_id) references Employee (id),
    primary key (id)
);

