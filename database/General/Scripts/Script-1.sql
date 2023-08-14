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
    mf_id NUMBER,
    business_date DATE,
    nav NUMBER(10, 2) NOT NULL,
    CONSTRAINT fk_nav_history_mf FOREIGN KEY (mf_id) REFERENCES Mutual_Fund(mf_id),
    CONSTRAINT pk_nav_history PRIMARY KEY (mf_id, business_date)
);

CREATE TABLE Stock_Price (
    stock_id NUMBER,
    business_date DATE,
    opening_price NUMBER(10, 2) NOT NULL,
    closing_price NUMBER(10, 2) NOT NULL,
    CONSTRAINT fk_stock_price_stock FOREIGN KEY (stock_id) REFERENCES Stock(stock_id),
    CONSTRAINT pk_stock_price PRIMARY KEY (stock_id, business_date)
);






