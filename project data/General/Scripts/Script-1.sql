CREATE TABLE Portfolio_Manager (
    pm_id NUMBER CONSTRAINT pk_pm_id PRIMARY KEY,
    username VARCHAR2(50) NOT NULL,
    password VARCHAR2(50) NOT NULL
);

CREATE TABLE Mutual_Fund (
    mf_id NUMBER CONSTRAINT pk_mf_id PRIMARY KEY,
    mf_name VARCHAR2(100) NOT NULL,
    cash_balance NUMBER(20, 2) NOT NULL,
    entry_load NUMBER(4, 2) NOT NULL,
    exit_load NUMBER(4, 2) NOT NULL,
    expense_ratio NUMBER(4, 2) NOT NULL,
    latest_nav NUMBER(10, 2),
    CONSTRAINT check_entry_load CHECK (entry_load >= 0),
    CONSTRAINT check_exit_load CHECK (exit_load >= 0),
    CONSTRAINT check_expense_ratio CHECK (expense_ratio >= 0)
);

CREATE TABLE Investor (
    investor_id NUMBER CONSTRAINT pk_investor_id PRIMARY KEY,
    password VARCHAR2(50) NOT NULL,
    name VARCHAR2(100) NOT NULL,
    email VARCHAR2(100) NOT NULL,
    phone_number VARCHAR2(20) NOT NULL
);

CREATE TABLE Stock (
    stock_id NUMBER CONSTRAINT pk_stock_id PRIMARY KEY,
    stock_name VARCHAR2(100) NOT NULL
);

CREATE TABLE Portfolio (
    portfolio_id NUMBER CONSTRAINT pk_portfolio_id PRIMARY KEY,
    mf_id NUMBER,
    stock_id NUMBER,
    weightage NUMBER(4, 2) NOT NULL,
    CONSTRAINT fk_portfolio_mf FOREIGN KEY (mf_id) REFERENCES Mutual_Fund(mf_id),
    CONSTRAINT fk_portfolio_stock FOREIGN KEY (stock_id) REFERENCES Stock(stock_id),
    CONSTRAINT check_weightage CHECK (weightage >= 0)
);

CREATE TABLE Investor_Transaction (
    transaction_id NUMBER CONSTRAINT pk_transaction_id PRIMARY KEY,
    investor_id NUMBER,
    mf_id NUMBER,
    transaction_type VARCHAR2(20) NOT NULL,
    units NUMBER(15, 6) NOT NULL,
    transaction_amount NUMBER(20, 2) NOT NULL,
    business_date DATE NOT NULL,
    CONSTRAINT fk_investor_trans_investor FOREIGN KEY (investor_id) REFERENCES Investor(investor_id),
    CONSTRAINT fk_investor_trans_mf FOREIGN KEY (mf_id) REFERENCES Mutual_Fund(mf_id),
    CONSTRAINT check_units CHECK (units > 0),
    CONSTRAINT check_transaction_amount CHECK (transaction_amount > 0)
);

CREATE TABLE NAV_History (
   	mutual_fund_id NUMBER,
    business_date DATE DEFAULT SYSDATE,
    nav NUMBER(10, 2) NOT NULL,
    CONSTRAINT fk_nav_history_mf FOREIGN KEY (mutual_fund_id) REFERENCES Mutual_Fund(mutual_fund_id)
);

CREATE TABLE Stock_Price (
    stock_id NUMBER,
    business_date DATE,
    opening_price NUMBER(10, 2) NOT NULL,
    closing_price NUMBER(10, 2) NOT NULL,
    CONSTRAINT fk_stock_price_stock FOREIGN KEY (stock_id) REFERENCES Stock(stock_id),
    CONSTRAINT pk_stock_price PRIMARY KEY (stock_id, business_date)
);

-- Inserting data into Stock table
INSERT INTO Stock (stock_id, stock_name) VALUES (1, 'Apple Inc.');
INSERT INTO Stock (stock_id, stock_name) VALUES (2, 'Microsoft Corporation');
INSERT INTO Stock (stock_id, stock_name) VALUES (3, 'Amazon.com Inc.');
INSERT INTO Stock (stock_id, stock_name) VALUES (4, 'Alphabet Inc. (Google)');
INSERT INTO Stock (stock_id, stock_name) VALUES (5, 'Facebook Inc.');
INSERT INTO Stock (stock_id, stock_name) VALUES (6, 'Tesla Inc.');
INSERT INTO Stock (stock_id, stock_name) VALUES (7, 'Berkshire Hathaway Inc.');
INSERT INTO Stock (stock_id, stock_name) VALUES (8, 'JPMorgan Chase & Co.');
INSERT INTO Stock (stock_id, stock_name) VALUES (9, 'Johnson & Johnson');
INSERT INTO Stock (stock_id, stock_name) VALUES (10, 'Walmart Inc.');
INSERT INTO Stock (stock_id, stock_name) VALUES (11, 'Visa Inc.');
INSERT INTO Stock (stock_id, stock_name) VALUES (12, 'Procter & Gamble Co.');
INSERT INTO Stock (stock_id, stock_name) VALUES (13, 'Mastercard Incorporated');
INSERT INTO Stock (stock_id, stock_name) VALUES (14, 'Verizon Communications Inc.');
INSERT INTO Stock (stock_id, stock_name) VALUES (15, 'Coca-Cola Company');
INSERT INTO Stock (stock_id, stock_name) VALUES (16, 'Intel Corporation');
INSERT INTO Stock (stock_id, stock_name) VALUES (17, 'McDonalds Corporation');
INSERT INTO Stock (stock_id, stock_name) VALUES (18, 'Netflix Inc.');
INSERT INTO Stock (stock_id, stock_name) VALUES (19, 'Adobe Inc.');
INSERT INTO Stock (stock_id, stock_name) VALUES (20, 'Salesforce.com Inc.');
INSERT INTO Stock (stock_id, stock_name) VALUES (21, 'NVIDIA Corporation');
INSERT INTO Stock (stock_id, stock_name) VALUES (22, 'PayPal Holdings Inc.');
INSERT INTO Stock (stock_id, stock_name) VALUES (23, 'IBM (International Business Machines)');
INSERT INTO Stock (stock_id, stock_name) VALUES (24, 'Oracle Corporation');
INSERT INTO Stock (stock_id, stock_name) VALUES (25, 'Home Depot Inc.');
-- You can continue adding more rows with real stock names


SELECT * FROM STOCK;

SELECT * FROM STOCK_PRICE sp;

CREATE SEQUENCE investor_id_seq_new
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCYCLE;

CREATE SEQUENCE mutual_fund_id_seq
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCYCLE;

CREATE SEQUENCE portfolio_id_seq
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCYCLE;

TRUNCATE TABLE INVESTOR;
SELECT * FROM INVESTOR i;

SELECT FROM INVESTOR i setval('investor_id_seq', 0, false);

ALTER TABLE MUTUAL_FUND  RENAME COLUMN MF_ID TO MUTUAL_FUND_ID;

ALTER TABLE NAV_HISTORY 

ALTER TABLE MUTUAL_FUND ADD Total_Investment NUMBER;
ALTER TABLE MUTUAL_FUND ADD Total_Units_Outstanding NUMBER;

SELECT * FROM PORTFOLIO p;
SELECT * FROM MUTUAL_FUND mf ;


SELECT SYSDATE FROM DUAL;

TRUNCATE TABLE MUTUAL_FUND ;
TRUNCATE TABLE PORTFOLIO  ;
SELECT * FROM STOCK_PRICE WHERE TO_CHAR(BUSINESS_DATE, 'yyyy-MM-dd') = TO_CHAR(SYSDATE, 'yyyy-MM-dd') ;


CREATE TABLE ExampleTable (
    value NUMBER
);

INSERT INTO EXAMPLETABLE VALUES(242342342.34242);

SELECT * FROM EXAMPLETABLE ;


SELECT * FROM INVESTOR i;
SELECT * FROM INVESTOR_TRANSACTION it;

ALTER TABLE INVESTOR_TRANSACTION RENAME COLUMN MF_ID TO MUTUAL_FUND_ID;

CREATE TABLE INVESTOR_PORTFOLIO (
	investor_portfolio_id NUMBER CONSTRAINT pk_investor_portfolio PRIMARY KEY,
	investor_id NUMBER,
	mutual_fund_id NUMBER,
	units NUMBER,
	total_investment NUMBER,
	CONSTRAINT fk_investor_portfolio_investor FOREIGN KEY (investor_id) REFERENCES Investor(investor_id),
	CONSTRAINT fk_investor_portfolio_mf FOREIGN KEY (mutual_fund_id) REFERENCES Mutual_Fund(mutual_fund_id)
);


CREATE SEQUENCE test_investor_portfolio_id_seq
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCYCLE;

CREATE SEQUENCE test_transaction_id_seq
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCYCLE;


DROP TABLE INVESTOR_PORTFOLIO;

TRUNCATE TABLE INVESTOR_PORTFOLIO ;
TRUNCATE TABLE PORTFOLIO  ;
TRUNCATE TABLE MUTUAL_FUND ;
TRUNCATE TABLE INVESTOR_TRANSACTION  ;

ALTER TABLE MUTUAL_FUND ADD PREV_NAV NUMBER;
ALTER TABLE MUTUAL_FUND MODIFY PREV_NAV DEFAULT 0.00;

DROP TABLE NAV_HISTORY;
ALTER TABLE NAV_HISTORY MODIFY BUSINESS_DATE DATE DEFAULT SYSDATE;
ALTER TABLE NAV_HISTORY RENAME COLUMN MF_ID TO MUTUAL_FUND_ID;
ALTER TABLE PORTFOLIO ADD STOCK_UNITS NUMBER;

SELECT * FROM PORTFOLIO p;
SELECT * FROM INVESTOR_PORTFOLIO;
SELECT * FROM INVESTOR i;
SELECT * FROM INVESTOR_TRANSACTION it;
SELECT * FROM STOCK_PRICE sp;
SELECT * FROM MUTUAL_FUND mf;

TRUNCATE TABLE NAV_HISTORY;

ALTER TABLE INVESTOR_TRANSACTION MODIFY business_date DATE DEFAULT SYSDATE;



SELECT sp.OPENING_PRICE FROM STOCK_PRICE sp  WHERE sp.STOCK_ID = 1 AND sp.BUSINESS_DATE = (SELECT MAX(sp2.BUSINESS_DATE) 
       FROM STOCK_PRICE sp2 WHERE sp2.STOCK_ID = 1
       AND sp2.BUSINESS_DATE  < CURRENT_DATE);











