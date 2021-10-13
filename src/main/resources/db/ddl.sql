--first run this before app start

CREATE SCHEMA IF NOT EXISTS carmaintain;
create role carmaintain with login password 'carmaintain_1';
grant all on schema carmaintain to carmaintain; --права на create и usage
alter default privileges in schema carmaintain
grant all on tables to carmaintain; --права на таблицы
alter default privileges in schema carmaintain
grant all on sequences to carmaintain; --права на sequence-ы
alter default privileges in schema carmaintain
grant all on functions to carmaintain; --права на функции
alter default privileges in schema carmaintain
grant all on types to carmaintain; --прав
alter role carmaintain set search_path to carmaintain;