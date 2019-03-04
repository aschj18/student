package dk.shrit.account.rest;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dk.shrit.account.exception.AccountNotFoundException;
import dk.shrit.account.model.Account;
import dk.shrit.account.model.AccountDetails;
import dk.shrit.account.model.AccountList;
import dk.shrit.account.model.AccountsResponse201;
import dk.shrit.account.rest.AccountInformationServiceAisApi;
import dk.shrit.account.rest.request.CreateAccountRequest;
import dk.shrit.account.rest.request.GetAccountsRequest;
import dk.shrit.account.service.AccountService;
import dk.shrit.account.service.AccountServiceImpl;
import io.swagger.annotations.ApiParam;

@RestController
public class AccountController implements AccountInformationServiceAisApi {

	private static Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	AccountService service;

	public AccountController(AccountService service) {
		this.service = service;
	}

	@Override
	public ResponseEntity<AccountsResponse201> createAccount(
			@RequestHeader(value = "X-Request-ID", required = true) java.util.UUID xRequestID, @Valid @RequestBody  Account account) {
		// TODO Auto-generated method stub
		CreateAccountRequest req = new CreateAccountRequest.Builder(xRequestID, account).build();
		AccountDetails rep = service.createAccount(req);
		AccountsResponse201 r = new AccountsResponse201();
		r.setAccountId(rep.getResourceId());
		
		return new ResponseEntity<>(r, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<AccountList> getAccountList(
			@RequestHeader(value = "X-Request-ID", required = true) java.util.UUID xRequestID,
			@Valid @RequestParam(value = "withBalance", required = false) Boolean withBalance) {
		logger.debug("getAccountList {}");
		GetAccountsRequest req = new GetAccountsRequest.Builder(xRequestID).build();
		List<AccountDetails> accounts = service.getAccounts(req);
		AccountList list = new AccountList();
		list.setAccounts(accounts);
		logger.debug("getAccountList {}", list.getAccounts().size());
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<AccountDetails> readAccountDetails(String accountId,
			@RequestHeader(value = "X-Request-ID", required = true) java.util.UUID xRequestID,
			@Valid @RequestParam(value = "withBalance", required = false) Boolean withBalance) {
		// TODO Auto-generated method stub
		return AccountInformationServiceAisApi.super.readAccountDetails(accountId, xRequestID, withBalance);
	}

}