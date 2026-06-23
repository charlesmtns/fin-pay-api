package com.charlesmtnsdev.finpay_api.controller;

import com.charlesmtnsdev.finpay_api.dto.AccountDTO;
import com.charlesmtnsdev.finpay_api.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@Validated
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDTO> create(@Valid @RequestBody AccountDTO accountDTO) {

        AccountDTO accountResponse = this.accountService.createAccount(accountDTO);

        return ResponseEntity.ok(accountResponse);
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountDTO> get(@PathVariable String accountNumber) {

        AccountDTO accountDTO = this.accountService.getByAccountNumber(accountNumber);

        return ResponseEntity.ok(accountDTO);
    }
}
