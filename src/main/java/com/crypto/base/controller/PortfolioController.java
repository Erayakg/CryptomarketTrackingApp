package com.crypto.base.controller;

import com.crypto.base.dto.CreatePortfolioDto;
import com.crypto.base.dto.PortfolioDtoRes;
import com.crypto.base.dto.RestResponse;
import com.crypto.base.services.Impl.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/portfolio")
public class PortfolioController {
    private final PortfolioService portfolioService;
    @GetMapping("/getAll")
    public ResponseEntity<RestResponse<List<PortfolioDtoRes>>> getAllPortfolio() {
        List<PortfolioDtoRes> allPortfolio = portfolioService.getAllPortfolio();
        return new ResponseEntity<>(RestResponse.of(allPortfolio), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<RestResponse<PortfolioDtoRes>> createPortfolio(@RequestBody CreatePortfolioDto portfolioDto) {

        PortfolioDtoRes portfolio = portfolioService.createPortfolio(portfolioDto);

        return new ResponseEntity<>(RestResponse.of(portfolio), HttpStatus.CREATED);
    }
}
