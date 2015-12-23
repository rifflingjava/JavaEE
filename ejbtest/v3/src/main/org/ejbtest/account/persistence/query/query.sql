DROP TABLE EJB_Query_Account;
DROP TABLE EJB_Query_Department;
DROP SEQUENCE ejb_seq_acc_id;
DROP TABLE EJB_Query_Table_Id_Generator;
CREATE TABLE EJB_Query_Table_Id_Generator(
    GEN_NAME VARCHAR2(200),
    GEN_VALUE VARCHAR2(100)
);
INSERT INTO EJB_QUERY_TABLE_ID_GENERATOR (GEN_NAME,GEN_VALUE) VALUES ('EJB_Query_Department_ID','1');
select * from (
  select row_.*, rownum rownum_ 
  from ( select dep_id, dep_name, end_date, start_date  from ejb_query_department 
  ) row_ where rownum <= 5
) where rownum_ > 2

CREATE SEQUENCE EJB_SEQ_ACC_ID INCREMENT BY 1 MAXVALUE 999999999999999999999999999 MINVALUE 1 CACHE 20 ;
CREATE TABLE EJB_QUERY_DEPARTMENT
(
  DEP_ID NUMBER(10, 0) NOT NULL,
  DEP_NAME VARCHAR2(200 CHAR),
  END_DATE DATE,
  START_DATE TIMESTAMP(6)
, PRIMARY KEY (   DEP_ID  )
);
 
CREATE TABLE EJB_QUERY_ACCOUNT
(
  ID NUMBER(10, 0) NOT NULL,
  EMAIL_ADDRESS VARCHAR2(100 CHAR),
  FIRST_NAME VARCHAR2(100 CHAR) NOT NULL,
  LAST_NAME VARCHAR2(100 CHAR),
  DEPARTMENT_ID NUMBER(10, 0)
, PRIMARY KEY  (    ID  )
, FOREIGN KEY(  DEPARTMENT_ID)
    REFERENCES EJB_QUERY_DEPARTMENT(DEP_ID) ENABLE
, UNIQUE(  FIRST_NAME) ENABLE
);
