DECLARE
    CURSOR c_all_loans IS
        SELECT LoanID, InterestRate
        FROM Loans;

    v_loan_id Loans.LoanID%TYPE;
    v_interest_rate Loans.InterestRate%TYPE;
    v_new_interest_rate Loans.InterestRate%TYPE; -- Adjust as per new policy

    FUNCTION CalculateNewInterestRate(old_rate NUMBER) RETURN NUMBER IS
    BEGIN
        RETURN old_rate + 0.5;
    END;
BEGIN
    OPEN c_all_loans;
    LOOP
        FETCH c_all_loans INTO v_loan_id, v_interest_rate;
        EXIT WHEN c_all_loans%NOTFOUND;
        v_new_interest_rate := CalculateNewInterestRate(v_interest_rate);
        UPDATE Loans
        SET InterestRate = v_new_interest_rate
        WHERE LoanID = v_loan_id;
        DBMS_OUTPUT.PUT_LINE('Updated Loan ID: ' || v_loan_id || ' with new interest rate: ' || v_new_interest_rate);
    END LOOP;
    CLOSE c_all_loans;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: An unexpected error occurred while updating the loan interest rates.');
END;
