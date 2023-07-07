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
ALTER TABLE members ADD CONSTRAINT pk_member PRIMARY KEY(mem_id);

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

-- 2번째 

CREATE TABLE boards (
    board_no NUMBER(10)
    ,board_title VARCHAR2(1000)
    ,board_content VARCHAR2(4000)
    ,mem_id VARCHAR2(100)
    ,board_date DATE
);
commit;
ALTER TABLE boards ADD CONSTRAINT fk_boards FOREIGN KEY(mem_id) REFERENCES members(mem_id);
ALTER TABLE boards ADD (del_yn VARCHAR2(1));
-- SELECT COUNT(*) + 1
-- FROM boards;

CREATE SEQUENCE seq_boards;

INSERT INTO boards (
    board_no
    , board_title
    , board_content
    , mem_id
    , board_date
    , del_yn
) VALUES (
    seq_boards.nextval
    , '세번째 게시물 제목'
    , '무야호~'
    , 'a001'
    , SYSDATE
    , 'N'
);
commit;

SELECT
    a.board_no
  , a.board_title
  , a.board_content
  , a.mem_id
  , TO_CHAR(a.board_date, 'MM/DD HH24:MI') as board_date
  , b.mem_name
FROM boards a , members b
WHERE a.mem_id = b.mem_id
  AND a.del_yn = 'N'
ORDER BY board_date DESC
;

SELECT
    a.board_no
  , a.board_title
  , a.board_content
  , a.mem_id
  , TO_CHAR(a.board_date, 'MM/DD HH24:MI') as board_date
  , b.mem_name
FROM boards a , members b
WHERE a.mem_id = b.mem_id 
    AND a.board_no = 3
    ;

UPDATE boards 
SET board_title = :1
    ,board_content = :2
WHERE board_no = :3
;

UPDATE boards
SET del_yn = 'N'
;
commit;

UPDATE boards
SET del_yn = 'Y'
WHERE board_no = ?
;

