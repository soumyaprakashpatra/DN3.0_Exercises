CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    IF :NEW.TransactionType = 'Withdrawal' THEN
        SELECT Balance INTO v_balance
        FROM Accounts
        WHERE AccountID = :NEW.AccountID
        FOR UPDATE;

        IF v_balance < :NEW.Amount THEN
            RAISE_APPLICATION_ERROR(-20001, 'Error: Insufficient funds for the withdrawal.');
        END IF;
    END IF;

    IF :NEW.TransactionType = 'Deposit' THEN
        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Error: Deposit amount must be positive.');
        END IF;
    END IF;
END CheckTransactionRules;
