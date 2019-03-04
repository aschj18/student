package dk.shrit.account.persistance;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "account")
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String status;
	
	public Account() {
		super();
	}

	public Account(Long id, String name, String status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public void setAccountStatus(String status) {
		this.status = status;
	}

		
}