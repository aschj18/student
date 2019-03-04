package dk.shrit.account.rest.request;

import java.util.UUID;

import dk.shrit.account.model.Account;

public class CreateAccountRequest {
	
	final Account account;
	final UUID xRequestID;
	
	public Account getAccount() {
		return account;
	}


	public UUID getxRequestID() {
		return xRequestID;
	}

	private CreateAccountRequest(Builder builder) {
		this.xRequestID = builder.xRequestID;
		this.account = builder.account;
	}

	public static class Builder {

		UUID xRequestID;
		Account account;
		
		public Builder(UUID xRequestID, Account account) {
			this.xRequestID = xRequestID;
			this.account = account;
		}

		public CreateAccountRequest build() {
			return new CreateAccountRequest(this);
		}
	}

}
