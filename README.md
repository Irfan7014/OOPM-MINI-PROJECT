# Society-Management-System

THE SQL QUERIES USED FOR MAKING THE DATABASE:------------
Database for Society Records::

CREATE DATABASE SOCIETY;

USE SOCIETY;

CREATE TABLE ADMINLOGIN(USERNAME VARCHAR(25), PASSWORD VARCHAR(25), KEYID VARCHAR(10));

CREATE TABLE MEMBERS(NAME VARCHAR(75), DESIGNATION VARCHAR(30));

INSERT INTO MEMBERS VALUES ('Mr. Akbar Khan', 'CHAIRMAN');

INSERT INTO MEMBERS VALUES ('Mr. Iyer', 'SECRETARY');

INSERT INTO MEMBERS VALUES ('Mr. Agnelo Ferrao', 'TREASURER');

INSERT INTO MEMBERS VALUES ('Mrs. Sumita Mhatre', 'MEMBER 1');

INSERT INTO MEMBERS VALUES ('Mr. Javed Ahmed', 'MEMBER 2');

INSERT INTO MEMBERS VALUES ('Mrs. Fatima John Dias', 'MEMBER 3');

INSERT INTO MEMBERS VALUES ('Mr. Vijay Patil', 'MEMBER 4');

INSERT INTO MEMBERS VALUES ('Mr. Aman Singh', 'MEMBER 5');

INSERT INTO MEMBERS VALUES ('Mr. Shahid Kapoor', 'MEMBER 6');

INSERT INTO MEMBERS VALUES ('Mrs. Anita Sethi', 'MEMBER 7');

INSERT INTO MEMBERS VALUES ('Mr. Sachin Bhande', 'MEMBER 8');

CREATE TABLE SERVICES (SERVICE VARCHAR(50), NAME VARCHAR(50), CONTACT VARCHAR(15));

INSERT INTO SERVICES VALUES ('ELECTRICIAN', 'AJAY', '+911122334455');

INSERT INTO SERVICES VALUES ('PLUMBER', 'ANIL', '+911234567890');

INSERT INTO SERVICES VALUES ('PAINTER', 'KUNAL', '+919876543210');

INSERT INTO SERVICES VALUES ('BABY SITTER', 'SUSHMA', '+91147258369');

INSERT INTO SERVICES VALUES ('LAUNDARY', 'SALMAN', '+91963852741');

INSERT INTO SERVICES VALUES ('TUTOR', 'VIJAY', '+91741852963');

INSERT INTO SERVICES VALUES ('CARPENTER', 'AMIR', '+91987456321');

INSERT INTO SERVICES VALUES ('MAID', 'LUBNA', '+91456321789');


CREATE TABLE GATE_LOGIN (username varchar(50), password varchar(50), keyid varchar(50));

CREATE TABLE ENTRIES (NAME VARCHAR(50), PURPOSE VARCHAR(20), PHONE VARCHAR(20), FLAT VARCHAR(20), DATE VARCHAR(20), ENTRY_TIME VARCHAR(20), EXIT_TIME VARCHAR(20), WATCHMAN_PRESENT VARCHAR(30), GATE INT(3), VEHICLE_NUM VARCHAR(20));

CREATE TABLE PARKING (NAME VARCHAR(50), FLAT VARCHAR(20), VEHICLE_NUMBER VARCHAR(20), VEHICLE_TYPE VARCHAR(20),  PARKING_SPOT INTEGER(5));

CREATE TABLE RESIDENTS (NAME VARCHAR(50), BUILDING_NUMBER VARCHAR(50), FLAT_NUMBER VARCHAR(50), DOB VARCHAR(20), OCCUPATION VARCHAR(50), ARRIVAL_YEAR INTEGER(7), TOTAL_FAMILY_MEMBERS INTEGER(7), MARITAL_STATUS VARCHAR(30), RENT_OWNER VARCHAR(30)); 

CREATE TABLE NOTICES (NAME VARCHAR(100), PATH VARCHAR(300));

ResultSet rs1 = c.s.executeQuery("select * from members where DESIGNATION='CHAIRMAN';");
            chairman_name=rs1.next(rs1.getString("NAME"));
            
            ResultSet rs2 = c.s.executeQuery("select * from members where DESIGNATION='SECRETARY';");
            sec_name=rs2.getString("NAME");
            
            ResultSet rs3 = c.s.executeQuery("select * from members where DESIGNATION='TREASURER';");
            treasurer_name=rs3.getString("NAME");
            
            ResultSet rs4 = c.s.executeQuery("select * from members where DESIGNATION='MEMBER 1';");
            mem1_name=rs4.getString("NAME");
            
            ResultSet rs5 = c.s.executeQuery("select * from members where DESIGNATION='MEMBER 2';");
            mem2_name=rs5.getString("NAME");
            
            ResultSet rs6 = c.s.executeQuery("select * from members where DESIGNATION='MEMBER 3';");
            mem3_name=rs6.getString("NAME");
            
            ResultSet rs7 = c.s.executeQuery("select * from members where DESIGNATION='MEMBER 4';");
            mem4_name=rs7.getString("NAME");
            
            ResultSet rs8 = c.s.executeQuery("select * from members where DESIGNATION='MEMBER 5';");
            mem5_name=rs8.getString("NAME");
            
            ResultSet rs9 = c.s.executeQuery("select * from members where DESIGNATION='MEMBER 6';");
            mem6_name=rs9.getString("NAME");
            
            ResultSet rs10 = c.s.executeQuery("select * from members where DESIGNATION='MEMBER 7';");
            mem7_name=rs10.getString("NAME");
            
            ResultSet rs11 = c.s.executeQuery("select * from members where DESIGNATION='MEMBER 8';");
            mem8_name=rs11.getString("NAME");
