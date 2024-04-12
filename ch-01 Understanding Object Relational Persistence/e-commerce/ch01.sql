CREATE TABLE USERS (
    USERNAME VARCHAR(15) NOT NULL PRIMARY KEY,
    ADDRESS VARCHAR(255) NOT NULL
);

CREATE TABLE BILLINGDETAILS (
    ACCOUNT VARCHAR(15) NOT NULL PRIMARY KEY,
    BANKNAME VARCHAR(255) NOT NULL,
    USERNAME VARCHAR(15) NOT NULL,
    FOREIGN KEY(USERNAME) REFERENCES USERS(USERNAME)
);

CREATE TABLE USERS(
    ID BIGINT NOT NULL PRIMARY KEY,
    USERNAME VARCHAR(15) NOT NULL PRIMARY KEY,
    ADDRESS_STREET VARCHAR(255) NOT NULL,
    ADDRESS_ZIPCODE VARCHAR(5) NOT NULL,
    ADDRESS_CITY VARCHAR(255) NOT NULL
);

CREATE TABLE BILLINGDETAILS(
    ID BIGINT NOT NULL PRIMARY KEY,
    ACCOUNT VARCHAR(15) NOT NULL,
    BANKNAME VARCHAR(255) NOT NULL,
    USER_ID BIGINT NOT NULL,
    FOREIGN KEY(USER_ID) REFERENCES USERS(ID)
);

CREATE TABLE USER_BILLINGDETAILS(
    USER_ID BIGINT,
    BILLINGDETAILS_ID BIGINT,
    PRIMARY KEY(USER_ID, BILLINGDETAILS_ID),
    FOREIGN KEY(USER_ID) REFERENCES USERS(ID),
    FOREIGN KEY(BILLINGDETAILS_ID) REFERENCES BILLINGDETAILS(ID)
);
