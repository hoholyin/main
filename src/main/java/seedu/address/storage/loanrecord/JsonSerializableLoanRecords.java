package seedu.address.storage.loanrecord;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.LoanRecords;
import seedu.address.model.ReadOnlyLoanRecords;
import seedu.address.model.loan.Loan;

/**
 * An Immutable LoanRecords that is serializable to JSON format.
 */
@JsonRootName(value = "loanrecords")
class JsonSerializableLoanRecords {
    // NOT IMPORTANT
    public static final String MESSAGE_DUPLICATE_LOAN = "loans list contains duplicate loan(s).";
    
    private final List<JsonAdaptedLoan> loans = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableLoanRecords} with the given loans.
     */
    @JsonCreator
    public JsonSerializableLoanRecords(@JsonProperty("loans") List<JsonAdaptedLoan> loans) {
        this.loans.addAll(loans);
    }

    /**
     * Converts a given {@code ReadOnlyLoanRecords} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableLoanRecords}.
     */
    public JsonSerializableLoanRecords(ReadOnlyLoanRecords source) {
        loans.addAll(source.getLoanList().stream().map(JsonAdaptedLoan::new).collect(Collectors.toList()));
    }

    /**
     * Converts this loan record into the model's {@code LoanRecords} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public LoanRecords toModelType() throws IllegalValueException {
        LoanRecords LoanRecords = new LoanRecords();
        for (JsonAdaptedLoan JsonAdaptedLoan : loans) {
            Loan loan = JsonAdaptedLoan.toModelType();
            if (LoanRecords.hasLoan(loan)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_LOAN);
            }
            LoanRecords.addLoan(loan);
        }
        return LoanRecords;
    }

}
