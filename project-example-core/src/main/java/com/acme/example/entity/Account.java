package com.acme.example.entity;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.acme.architecture.common.entity.AbstractEntity;
import com.acme.example.common.enumerate.AccountTypeEnum;

public class Account extends AbstractEntity {
	
	private static final long serialVersionUID = 4984202727271017459L;

	private Long id;
	
	private String owner;
	
	private double balance;

	private boolean locked;
	
	private AccountTypeEnum accountType;

	private Date creationDate;
	
	private Date accessDate;
	
	private Date lockedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getAccessDate() {
		return accessDate;
	}

	public void setAccessDate(Date accessDate) {
		this.accessDate = accessDate;
	}

	public Date getLockedDate() {
		return lockedDate;
	}

	public void setLockedDate(Date lockedDate) {
		this.lockedDate = lockedDate;
	}

	public AccountTypeEnum getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountTypeEnum accountType) {
		this.accountType = accountType;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Account)) {
			return false;
		}
		
		final Account other = (Account)object;

		return new EqualsBuilder().append(getId(), other.getId())
				.append(getOwner(), other.getOwner())
				.append(getBalance(), other.getBalance())
				.append(isLocked(), other.isLocked())
				.append(getAccountType(), other.getAccountType())
				.append(getCreationDate(), other.getCreationDate())
				.append(getAccessDate(), other.getAccessDate())
				.append(getLockedDate(), other.getLockedDate())
				.isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).append(getOwner()).append(getBalance()).append(isLocked())
				.append(getAccountType()).append(getCreationDate()).append(getAccessDate()).append(getLockedDate()).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", getId())
				.append("owner", getOwner())
				.append("balance", getBalance())
				.append("locked", isLocked())
				.append("type", getAccountType())
				.append("creationDate", getCreationDate())
				.append("accessDate", getAccessDate())
				.append("creationAuthor", getLockedDate())
				.toString();
	}
	
	
}
