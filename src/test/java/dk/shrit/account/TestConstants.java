package dk.shrit.account;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dk.shrit.account.persistance.Account;

public class TestConstants {


	public static List<Account> accounts = new ArrayList<Account>() {{
	    add(new Account(1L, "nameA", "enabled"));
	    add(new Account(4L, "nameB", "enabled"));
	}};
	
	
	
	
}
