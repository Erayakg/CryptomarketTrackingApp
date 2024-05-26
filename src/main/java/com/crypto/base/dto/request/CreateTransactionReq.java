package com.crypto.base.dto.request;





public record CreateTransactionReq(Long salePrice, Long purchasePrice, Long amount, Long tokenId) {
}