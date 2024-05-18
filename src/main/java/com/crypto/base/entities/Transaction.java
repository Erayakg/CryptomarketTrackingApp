package com.crypto.base.entities;

import com.crypto.base.entities.enumtype.IsActiveEnum;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
public class Transaction extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", nullable = false)
    private Long id;
    @Enumerated(EnumType.STRING)
    private IsActiveEnum isActiveEnum;
    private Long salePrice;
    private Long purchasePrice;
    private Long amount;
    private Long tokenId;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "notification_id")
    private Notification notification;

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
