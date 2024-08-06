DECLARE
    CURSOR c_loans IS
        SELECT l.loan_id, l.customer_id, l.due_date, c.name
        FROM loans l
        JOIN customers c ON l.customer_id = c.customer_id
        WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30;
    
    v_loan_id loans.loan_id%TYPE;
    v_customer_id loans.customer_id%TYPE;
    v_due_date loans.due_date%TYPE;
    v_customer_name customers.name%TYPE;
BEGIN
    OPEN c_loans;
    
    LOOP
        FETCH c_loans INTO v_loan_id, v_customer_id, v_due_date, v_customer_name;
        EXIT WHEN c_loans%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || v_customer_name ||  ', your loan (ID: ' || v_loan_id || ') is due on ' || TO_CHAR(v_due_date, 'DD-MON-YYYY') || '.');
    END LOOP;
    
    CLOSE c_loans;
END;
