package dk.shrit.account.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import dk.shrit.account.TestConstants;
import dk.shrit.account.model.AccountDetails;
import dk.shrit.account.persistance.AccountRepository;
import dk.shrit.account.rest.request.GetAccountsRequest;

@RunWith(MockitoJUnitRunner.class)

public class AccountServiceImplTest {

	@Mock
	private AccountRepository repository;

	@InjectMocks
	private AccountServiceImpl service;

	UUID xRequestID = UUID.randomUUID();

	GetAccountsRequest getAccountsRequest;

	@Before

	public void setUp() {

		MockitoAnnotations.initMocks(this);

		UUID uuid = UUID.randomUUID();

		getAccountsRequest = new GetAccountsRequest.Builder(uuid).build();
		when(repository.findAll()).thenReturn(TestConstants.accounts);

	}

	@Test

	public void postPaymentTest() {
		List<AccountDetails> accounts = service.getAccounts(getAccountsRequest);
		assertEquals(2, accounts.size());
	}
}