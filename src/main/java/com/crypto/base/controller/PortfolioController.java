package com.crypto.base.controller;

import com.crypto.base.dto.PortfolioDtoRes;
import com.crypto.base.dto.RestResponse;
import com.crypto.base.services.Impl.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/portfolio/v1")
public class PortfolioController {
    private final PortfolioService portfolioService;
    @GetMapping("/getAllPortfolio")
    public ResponseEntity<RestResponse<List<PortfolioDtoRes>>> getAllPortfolio() {
        List<PortfolioDtoRes> allPortfolio = portfolioService.getAllPortfolio();
        return new ResponseEntity<>(RestResponse.of(allPortfolio), HttpStatus.OK);
    }
}
