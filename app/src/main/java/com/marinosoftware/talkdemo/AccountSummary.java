package com.marinosoftware.talkdemo;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import java.util.Date;


/**
 * Provides account Summary returned from the Accounts API. Any balances or amounts are provided as formatted strings.
 */
public class AccountSummary {

    /**
     * Account Currency Types
     * <p/>
     * - Euro
     * - Foreign
     */
    public enum CurrencyType {
        EURO(0),
        FOREIGN(1);

        final int value;

        CurrencyType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static CurrencyType fromInt(int i) {
            for (CurrencyType currencyType : CurrencyType.values()) {
                if (currencyType.getValue() == i) {
                    return currencyType;
                }
            }
            return null;
        }
    }

    /**
     * Account Types
     * <p/>
     * - Active
     * - Inactive
     * - Visa
     * - HoganMortgage
     * - DisMortgage
     * - Dormant
     * - Loan
     */
    public enum AccountType {
        ACTIVE(0),
        INACTIVE(1),
        VISA(2),
        HOGAN_MORTGAGE(3),
        DIS_MORTGAGE(4),
        DORMANT(5),
        LOAN(6);

        final int value;

        AccountType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static AccountType fromInt(int i) {
            for (AccountType accountType : AccountType.values()) {
                if (accountType.getValue() == i) {
                    return accountType;
                }
            }
            return null;
        }
    }

    /**
     * Visa Statuses
     * <p/>
     * - BillTransfer
     * - OtherTransfer
     * - InvalidTransfer
     * - InvalidAccount
     */
    public enum VisaStatus {
        BILL_TRANSFER(0),
        OTHER_TRANSFER(1),
        INVALID_TRANSFER(2),
        INVALID_ACCOUNT(3);

        final int value;

        VisaStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static VisaStatus fromInt(int i) {
            for (VisaStatus visaStatus : VisaStatus.values()) {
                if (visaStatus.getValue() == i) {
                    return visaStatus;
                }
            }
            return null;
        }
    }

    // TODO : check these strings are correct
    public static final String VISA_STATUS_BILL_TRANSFER = "BillTransfer";
    public static final String VISA_STATUS_OTHER_TRANSFER = "OtherTransfer (3rd party)";


    private final String accountNumber;
    private final String name;
    private final String id;
    private final String availableBalance;
    private final String balance;
    private final String last4Digits;
    private final CurrencyType currencyType;
    private final AccountType accountType;
    private final boolean depositOnly;
    private final boolean deduct;
    private final boolean internetTransactionsAllowed;
    private final boolean allowTextAlerts;
    private final String regularRepayment;
    private final String interest;
    private final Date nextPaymentDue;
    private final String visaStatus;
    private final String creditLimit;
    private final String currentBalance;
    private final String minimumPaymentDue;
    private final String lastStatementBalance;
    private final String visaStatusErrorMessage;
    private final String toAccount;

    /**
     * Constructor
     *
     * @param accountNumber               The encrypted account number
     * @param name                        The account name or nickname as it should be displayed to the user
     * @param id                          Designated unique key for the account
     * @param availableBalance            The amount available to the customer from the account
     * @param balance                     The current balance of the account
     * @param last4Digits                 The last 4 digits of the account number
     * @param currencyType                Represents the type of currency handled by the account, see `CurrencyType` enum for possible values
     * @param accountType                 The type of account, see `AccountType` enum for possible values
     * @param depositOnly                 Determines whether or not this account is deposit only
     * @param deduct                      Ignore, always set to false
     * @param internetTransactionsAllowed Determines whether or not this account is enabled for internet banking
     * @param allowTextAlerts             Determines whether or not SMS alerts are enabled on this account
     * @param regularRepayment            Amount of regular payment
     * @param interest                    Interest of mortgage or loan
     * @param nextPaymentDue              Date of next payment due
     * @param visaStatus                  Visa Status. Set if the account is of type VISA.
     * @param creditLimit                 Credit Limit
     * @param currentBalance              Current Balance
     * @param minimumPaymentDue           Minimum Payment Due
     * @param lastStatementBalance        Last Statement Balance
     * @param visaStatusErrorMessage      If VisaStatus has value of 2 or 3 then this field will be populated with an error message.
     * @param toAccount                   Base64 encoded object to send for transfer funds
     */
    public AccountSummary(String accountNumber, String name, String id, String availableBalance, String balance, String last4Digits,
                          CurrencyType currencyType, AccountType accountType, boolean depositOnly, boolean deduct,
                          boolean internetTransactionsAllowed, boolean allowTextAlerts, String regularRepayment,
                          String interest, Date nextPaymentDue, @Nullable String visaStatus, String creditLimit, String currentBalance,
                          String minimumPaymentDue, String lastStatementBalance, String visaStatusErrorMessage,
                          String toAccount) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.id = id;
        this.availableBalance = availableBalance;
        this.balance = balance;
        this.last4Digits = last4Digits;
        this.currencyType = currencyType;
        this.accountType = accountType;
        this.depositOnly = depositOnly;
        this.deduct = deduct;
        this.internetTransactionsAllowed = internetTransactionsAllowed;
        this.allowTextAlerts = allowTextAlerts;
        this.regularRepayment = regularRepayment;
        this.interest = interest;
        this.nextPaymentDue = nextPaymentDue;
        this.visaStatus = visaStatus;
        this.creditLimit = creditLimit;
        this.currentBalance = currentBalance;
        this.minimumPaymentDue = minimumPaymentDue;
        this.lastStatementBalance = lastStatementBalance;
        this.visaStatusErrorMessage = visaStatusErrorMessage;
        this.toAccount = toAccount;
    }

    /**
     * @return The encrypted account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @return The account name or nickname as it should be displayed to the user
     */
    public String getName() {
        return name;
    }

    /**
     * @return Designated unique key for the account
     */
    public String getId() {
        return id;
    }

    /**
     * @return The amount available to the customer from the account
     */
    public String getAvailableBalance() {
        return availableBalance;
    }

    /**
     * @return The current balance of the account
     */
    public String getBalance() {
        return balance;
    }

    /**
     * @return The last 4 digits of the account number
     */
    public String getLast4Digits() {
        return last4Digits;
    }

    /**
     * @return Represents the type of currency handled by the account, see `CurrencyType` enum for possible values
     */
    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    /**
     * @return The type of account, see `AccountType` enum for possible values
     */
    public AccountType getAccountType() {
        return accountType;
    }

    /**
     * @return Determines whether or not this account is deposit only
     */
    public boolean isDepositOnly() {
        return depositOnly;
    }

    /**
     * @return Ignore, always set to false
     */
    public boolean isDeduct() {
        return deduct;
    }

    /**
     * @return Determines whether or not this account is enabled for internet banking
     */
    public boolean isInternetTransactionsAllowed() {
        return internetTransactionsAllowed;
    }

    /**
     * @return Determines whether or not SMS alerts are enabled on this account
     */
    public boolean isAllowTextAlerts() {
        return allowTextAlerts;
    }

    /**
     * @return Amount of regular payment
     */
    public String getRegularRepayment() {
        return regularRepayment;
    }

    /**
     * @return Interest of mortgage or loan
     */
    public String getInterest() {
        return interest;
    }

    /**
     * @return Date of next payment due
     */
    public Date getNextPaymentDue() {
        return nextPaymentDue;
    }

    /**
     * @return Visa Status. Set if the account is of type VISA.
     */
    public String getVisaStatus() {
        return visaStatus;
    }

    /**
     * @return Credit Limit
     */
    public String getCreditLimit() {
        return creditLimit;
    }

    /**
     * @return Current Balance
     */
    public String getCurrentBalance() {
        return currentBalance;
    }

    /**
     * @return Minimum Payment Due
     */
    public String getMinimumPaymentDue() {
        return minimumPaymentDue;
    }

    /**
     * @return Last Statement Balance
     */
    public String getLastStatementBalance() {
        return lastStatementBalance;
    }

    /**
     * @return If VisaStatus has value of 2 or 3 then this field will be populated with an error message.
     */
    public String getVisaStatusErrorMessage() {
        return visaStatusErrorMessage;
    }

    /**
     * @return Base64 encoded object to send for transfer funds
     */
    public String getToAccount() {
        return toAccount;
    }

    @Override
    public String toString() {
        return "AccountSummary{" +
                "accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", availableBalance='" + availableBalance + '\'' +
                ", balance='" + balance + '\'' +
                ", last4Digits='" + last4Digits + '\'' +
                ", currencyType=" + currencyType +
                ", accountType=" + accountType +
                ", depositOnly=" + depositOnly +
                ", deduct=" + deduct +
                ", internetTransactionsAllowed=" + internetTransactionsAllowed +
                ", allowTextAlerts=" + allowTextAlerts +
                ", regularRepayment='" + regularRepayment + '\'' +
                ", interest='" + interest + '\'' +
                ", nextPaymentDue='" + nextPaymentDue + '\'' +
                ", visaStatus='" + visaStatus + '\'' +
                ", creditLimit='" + creditLimit + '\'' +
                ", currentBalance='" + currentBalance + '\'' +
                ", minimumPaymentDue='" + minimumPaymentDue + '\'' +
                ", lastStatementBalance='" + lastStatementBalance + '\'' +
                ", visaStatusErrorMessage='" + visaStatusErrorMessage + '\'' +
                ", toAccount='" + toAccount + '\'' +
                '}';
    }


}
