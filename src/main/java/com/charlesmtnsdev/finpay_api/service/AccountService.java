package com.charlesmtnsdev.finpay_api.service;

import com.charlesmtnsdev.finpay_api.dto.AccountDTO;
import com.charlesmtnsdev.finpay_api.entity.Account;
import com.charlesmtnsdev.finpay_api.mapper.AccountMapper;
import com.charlesmtnsdev.finpay_api.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    public AccountDTO createAccount(AccountDTO accountDTO) {

        Account account = new Account();
        account.setBeneficiary(accountDTO.getBeneficiary());
        account.setAccountNumber(UUID.randomUUID().toString().replace("-", "").toUpperCase());
        account.setBalance(BigDecimal.ZERO);
        account.setCreatedAt(LocalDateTime.now());
        account.setUpdatedAt(LocalDateTime.now());

        this.accountRepository.save(account);

        return this.accountMapper.toDTO(account);
    }

    public AccountDTO getByAccountNumber(String accountNumber) {

        Account account = this.accountRepository.findByAccountNumber(accountNumber);

        return accountMapper.toDTO(account);
    }
}
