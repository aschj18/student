package dk.shrit.account.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import dk.shrit.account.TestConstants;

import dk.shrit.account.model.AccountDetails;
import dk.shrit.account.service.AccountServiceImpl;
import dk.shrit.account.service.Mapper;

/**
 * 
 * Controller unit test, does not start server
 * 
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

	UUID uuid;
	HttpHeaders requestHeaders;

	   @InjectMocks
	    private AccountController controller;

	
	private MockMvc mvc;

	@MockBean
	private AccountServiceImpl service;

	@Before
	public void setUp() {
	       MockitoAnnotations.initMocks(this);
	        mvc = MockMvcBuilders.standaloneSetup(controller)
//	        	     .setControllerAdvice(new ExceptionController())
	        		.build();

	        
//		service = new AccountServiceImpl(repository);
		List<AccountDetails> accounts = Mapper.toModel(TestConstants.accounts);
		when(service.getAccounts(any())).thenReturn(accounts);
		uuid = UUID.randomUUID();
		requestHeaders = new HttpHeaders();
		requestHeaders.set("X-Request-ID", uuid.toString());
		requestHeaders.set("Consent-ID", "1f588ed1-6c85-4736-9435-85576285152c");
	}

	@Test
	public void testReadAccountDetailsWithbalance() throws Exception {
		this.mvc.perform(get("/v1/accounts/").param("withBalance", "true").headers(requestHeaders)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.accounts[0].name").value("nameA"));
		;

	}
	
	@Test
	public void testReadAccountDetailsWithbalance2() throws Exception {
		this.mvc.perform(get("/v2/accounts/").param("withBalance", "true").headers(requestHeaders)).andDo(print())
				.andExpect(status().isNotFound()).andExpect(jsonPath("$.accounts[0].name").value("nameA"));
		;

	}

}
