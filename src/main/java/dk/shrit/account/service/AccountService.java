package dk.shrit.account.service;

import java.util.List;
import java.util.UUID;

import dk.shrit.account.model.AccountDetails;
import dk.shrit.account.model.AccountsResponse201;
import dk.shrit.account.rest.request.CreateAccountRequest;
import dk.shrit.account.rest.request.GetAccountsRequest;

public interface AccountService {

	List<AccountDetails> getAccounts(GetAccountsRequest req);

	AccountDetails createAccount(CreateAccountRequest req);

}
