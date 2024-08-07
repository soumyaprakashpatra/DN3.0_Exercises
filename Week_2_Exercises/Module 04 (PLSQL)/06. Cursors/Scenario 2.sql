DECLARE
    CURSOR c_all_accounts IS
        SELECT AccountID, Balance
        FROM Accounts;

    v_account_id Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;
    v_annual_fee CONSTANT NUMBER := 50; -- Example annual fee amount
BEGIN
    OPEN c_all_accounts;
    LOOP
        FETCH c_all_accounts INTO v_account_id, v_balance;
        EXIT WHEN c_all_accounts%NOTFOUND;
        UPDATE Accounts
        SET Balance = Balance - v_annual_fee,
            LastModified = SYSDATE
        WHERE AccountID = v_account_id;
        DBMS_OUTPUT.PUT_LINE('Annual fee applied to Account ID: ' || v_account_id);
    END LOOP;
    CLOSE c_all_accounts;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: An unexpected error occurred while applying the annual fee.');
END;
