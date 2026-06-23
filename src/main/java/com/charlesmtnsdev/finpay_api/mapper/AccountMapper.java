package com.charlesmtnsdev.finpay_api.mapper;

import com.charlesmtnsdev.finpay_api.dto.AccountDTO;
import com.charlesmtnsdev.finpay_api.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public AccountDTO toDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setBeneficiary(account.getBeneficiary());
        accountDTO.setAccountNumber(account.getAccountNumber());
        accountDTO.setBalance(account.getBalance());
        return accountDTO;
    }
}
