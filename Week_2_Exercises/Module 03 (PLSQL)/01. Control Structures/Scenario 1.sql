DECLARE
    CURSOR c_customers IS
        SELECT customer_id, age, loan_interest_rate
        FROM customers
        WHERE age > 60;
    
    v_customer_id customers.customer_id%TYPE;
    v_age customers.age%TYPE;
    v_loan_interest_rate customers.loan_interest_rate%TYPE;
BEGIN
    OPEN c_customers;
    
    LOOP
        FETCH c_customers INTO v_customer_id, v_age, v_loan_interest_rate;
        EXIT WHEN c_customers%NOTFOUND;
        UPDATE customers
        SET loan_interest_rate = v_loan_interest_rate * 0.99
        WHERE customer_id = v_customer_id;
    END LOOP;
    
    CLOSE c_customers;
    COMMIT;
END;
