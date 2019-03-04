package dk.shrit.account.service;

import java.util.ArrayList;
import java.util.List;

import dk.shrit.account.model.AccountDetails;
import dk.shrit.account.model.AccountStatus;
import dk.shrit.account.persistance.Account;

public class Mapper {
	
	public static List<AccountDetails> toModel(List<Account> accounts) {
		List<AccountDetails> r = new ArrayList<AccountDetails>();
		for(Account a : accounts) {
			r.add(toModel(a));
		}
		return r;
	}
	
	public static  AccountDetails toModel(Account account) {
		AccountDetails r = new AccountDetails();
		r.setName(account.getName());
		r.setStatus(AccountStatus.fromValue(account.getStatus()));
		return r;
	}	

}
