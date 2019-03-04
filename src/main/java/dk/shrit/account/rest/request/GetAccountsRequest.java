package dk.shrit.account.rest.request;

import java.util.UUID;

public class GetAccountsRequest {
	
	UUID xRequestID;
	
	private GetAccountsRequest(Builder builder) {
		this.xRequestID = builder.xRequestID;
	}

	public UUID getxRequestID() {
		return xRequestID;
	}

	public void setxRequestID(UUID xRequestID) {
		this.xRequestID = xRequestID;
	}

	public static class Builder {

		UUID xRequestID;
		
		public Builder(UUID xRequestID) {
			this.xRequestID = xRequestID;
		}

		public GetAccountsRequest build() {
			return new GetAccountsRequest(this);
		}
	}

}
