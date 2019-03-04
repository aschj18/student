package dk.shrit.account.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dk.shrit.account.model.AccountDetails;
import dk.shrit.account.model.AccountStatus;
import dk.shrit.account.model.AccountsResponse201;
import dk.shrit.account.persistance.Account;
import dk.shrit.account.persistance.AccountRepository;
import dk.shrit.account.rest.request.CreateAccountRequest;
import dk.shrit.account.rest.request.GetAccountsRequest;

@Service
public class AccountServiceImpl implements AccountService{

	private static Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	private AccountRepository repository;

	public AccountServiceImpl(AccountRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<AccountDetails> getAccounts(GetAccountsRequest req) {
		logger.info("getAccounts {}", req.getClass());
		List<Account> acc = repository.findAll();
		logger.info("getAccounts {}", acc.size());
		return Mapper.toModel(acc);
	}

	@Override
	public AccountDetails createAccount(CreateAccountRequest req) {
		Account account = new Account();
		account.setAccountStatus(AccountStatus.ENABLED.toString());
		account.setName(req.getAccount().getName());
		repository.saveAndFlush(account);
		return Mapper.toModel(account);
	}


}

