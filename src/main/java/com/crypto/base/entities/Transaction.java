package com.crypto.base.entities;

import com.crypto.base.entities.enumtype.IsActiveEnum;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Transaction extends BaseEntity {


    @Enumerated(EnumType.STRING)
    private IsActiveEnum isActiveEnum;

    private Long salePrice;
    private Long purchasePrice;
    private Long amount;
    private Long tokenId;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    public Transaction() {
    }

    public Transaction(Long id, IsActiveEnum isActiveEnum, Long salePrice, Long purchasePrice, Long amount, Long tokenId, Portfolio portfolio) {
        this.id = id;
        this.isActiveEnum = isActiveEnum;
        this.salePrice = salePrice;
        this.purchasePrice = purchasePrice;
        this.amount = amount;
        this.tokenId = tokenId;
        this.portfolio = portfolio;
    }



    public IsActiveEnum getIsActiveEnum() {
        return isActiveEnum;
    }

    public void setIsActiveEnum(IsActiveEnum isActiveEnum) {
        this.isActiveEnum = isActiveEnum;
    }

    public Long getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Long salePrice) {
        this.salePrice = salePrice;
    }

    public Long getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Long purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) && isActiveEnum == that.isActiveEnum && Objects.equals(salePrice, that.salePrice) && Objects.equals(purchasePrice, that.purchasePrice) && Objects.equals(amount, that.amount) && Objects.equals(tokenId, that.tokenId) && Objects.equals(portfolio, that.portfolio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isActiveEnum, salePrice, purchasePrice, amount, tokenId, portfolio);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", isActiveEnum=" + isActiveEnum +
                ", salePrice=" + salePrice +
                ", purchasePrice=" + purchasePrice +
                ", amount=" + amount +
                ", tokenId=" + tokenId +
                ", portfolio=" + portfolio +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}