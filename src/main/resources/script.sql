--alter current account table
ALTER TABLE account
    ADD password VARCHAR2(100) DEFAULT '12345' NOT NULL;