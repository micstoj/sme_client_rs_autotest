package stepDefinitions.base;

import com.opencsv.bean.CsvBindByPosition;

public class ParseCSVPayments {



    @CsvBindByPosition(position = 0)
    private String paymentType;

    @CsvBindByPosition(position = 1)
    private String validationType;

    @CsvBindByPosition(position = 2)
    private String expectedBehavior;

    @CsvBindByPosition(position = 3)
    private String payToAccount;
    @CsvBindByPosition(position = 4)
    private String name;
    @CsvBindByPosition(position = 5)
    private String address;
    @CsvBindByPosition(position = 6)
    private String city;
    @CsvBindByPosition(position = 7)
    private String country;
    @CsvBindByPosition(position = 8)
    private String amount;
    @CsvBindByPosition(position = 9)
    private String creditorReference1;
    @CsvBindByPosition(position = 10)
    private String creditorReference2;

    @CsvBindByPosition(position = 11)
    private String creditorReference3;

    @CsvBindByPosition(position = 12)
    private String valueDate;

    @CsvBindByPosition(position = 13)
    private String urgent;

    @CsvBindByPosition(position = 14)
    private String purposeCode;

    @CsvBindByPosition(position = 15)
    private String paymentDetails;

    @CsvBindByPosition(position = 16)
    private String debtorReference1;

    @CsvBindByPosition(position = 17)
    private String debtorReference2;

    @CsvBindByPosition(position = 18)
    private String debtorReference3;
    @CsvBindByPosition(position = 19)
    private String purposeCategoryCode;
    @CsvBindByPosition(position = 20)
    private String ultimateDebtorName;
    @CsvBindByPosition(position = 21)
    private String ultimateCreditorName;
    @CsvBindByPosition(position = 22)
    private String debtorTypeIdentity;
    @CsvBindByPosition(position = 23)
    private String creditorTypeIdentity;
    @CsvBindByPosition(position = 24)
    private String ultimateDebtorTypeOfIdentity;
    @CsvBindByPosition(position = 25)
    private String ultimateCreditorTypeOfIdentity;

    //  getters, setters, toString


    public String getPaymentType() {
        return paymentType;
    }

    public String getValidationType() {
        return validationType;
    }

    public String getExpectedBehavior() {
        return expectedBehavior;
    }

    public String getPayToAccount() {
        return payToAccount;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getAmount() {
        return amount;
    }

    public String getCreditorReference1() {
        return creditorReference1;
    }

    public String getCreditorReference2() {
        return creditorReference2;
    }

    public String getCreditorReference3() {
        return creditorReference3;
    }

    public String getValueDate() {
        return valueDate;
    }

    public String getUrgent() {
        return urgent;
    }

    public String getPurposeCode() {
        return purposeCode;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public String getDebtorReference1() {
        return debtorReference1;
    }

    public String getDebtorReference2() {
        return debtorReference2;
    }

    public String getDebtorReference3() {
        return debtorReference3;
    }

    public String getPurposeCategoryCode() {
        return purposeCategoryCode;
    }

    public String getUltimateDebtorName() {
        return ultimateDebtorName;
    }

    public String getUltimateCreditorName() {
        return ultimateCreditorName;
    }

    public String getDebtorTypeIdentity() {
        return debtorTypeIdentity;
    }

    public String getCreditorTypeIdentity() {
        return creditorTypeIdentity;
    }

    public String getUltimateDebtorTypeOfIdentity() {
        return ultimateDebtorTypeOfIdentity;
    }

    public String getUltimateCreditorTypeOfIdentity() {
        return ultimateCreditorTypeOfIdentity;
    }
}
