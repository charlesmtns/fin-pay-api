package com.charlesmtnsdev.finpay_api.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table
public class BalanceHistory {

    @Id
    @Column(name = "balance_history_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "balance_history_balance_history_id_seq")
    @SequenceGenerator(name = "balance_history_balance_history_id_seq", sequenceName = "balance_history_balance_history_id_seq", allocationSize = 1)
    private Long id;

    private Long accountId;

    private Long transactionId;

    private BigDecimal previousBalance;

    private BigDecimal newBalance;

    private BigDecimal changeAmount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getPreviousBalance() {
        return previousBalance;
    }

    public void setPreviousBalance(BigDecimal previousBalance) {
        this.previousBalance = previousBalance;
    }

    public BigDecimal getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(BigDecimal newBalance) {
        this.newBalance = newBalance;
    }

    public BigDecimal getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(BigDecimal changeAmount) {
        this.changeAmount = changeAmount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "BalanceHistory{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", transactionId=" + transactionId +
                ", previousBalance=" + previousBalance +
                ", newBalance=" + newBalance +
                ", changeAmount=" + changeAmount +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BalanceHistory that = (BalanceHistory) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getAccountId(), that.getAccountId()) && Objects.equals(getTransactionId(), that.getTransactionId()) && Objects.equals(getPreviousBalance(), that.getPreviousBalance()) && Objects.equals(getNewBalance(), that.getNewBalance()) && Objects.equals(getChangeAmount(), that.getChangeAmount()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) && Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountId(), getTransactionId(), getPreviousBalance(), getNewBalance(), getChangeAmount(), getCreatedAt(), getUpdatedAt());
    }
}
