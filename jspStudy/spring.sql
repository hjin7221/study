create TABLESPACE springts
datafile '/u01/app/oracle/oradata/XE/springts.dbf'
size 100M autoextend on next 5M;

create user spring identified by oracle
default TABLESPACE springts
temporary tablespace temp;

grant connect, resource to spring;

CREATE TABLE members (
    mem_id VARCHAR2(100)
    ,mem_pw VARCHAR2(100)
    ,mem_name VARCHAR2(100)
);

INSERT INTO members (
    mem_id
    ,mem_pw
    ,mem_name
) VALUES (
    'admin'
    ,'admin'
    ,'관리자'
);

commit;

SELECT 
    mem_id
    ,mem_pw
    ,mem_name
FROM members;

SELECT 
    mem_id
    ,mem_pw
    ,mem_name
FROM members
WHERE 1=1
 AND mem_id = 'a001'
 AND mem_pw = '123a'
 ;







