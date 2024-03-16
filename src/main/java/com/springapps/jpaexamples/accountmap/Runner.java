package com.springapps.jpaexamples.accountmap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    AccountService accountService;
    @Autowired
    public Runner(AccountService accountService) {
        this.accountService = accountService;
    }



    @Override
    public void run(String... args) throws Exception {
       // accountService.transferMoney(1l,2l,491);
        accountService.updateAccountBalance(1l,1000);
    }
}
