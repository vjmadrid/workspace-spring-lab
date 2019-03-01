package com.acme.example.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.acme.architecture.common.entity.AbstractEntity;

public class User extends AbstractEntity {
	
	private static final long serialVersionUID = -5561781116865187153L;

	private Long id;

	//@Size(min=3, max=10)
	private String name;
	
	//@NotEmpty
	private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof User)) {
			return false;
		}
		
		final User other = (User)object;

		return new EqualsBuilder().append(getId(), other.getId())
				.append(getName(), other.getName())
				.append(getPassword(), other.getPassword())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).append(getName()).append(getPassword()).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", getId())
				.append("name", getName())
				.append("password", getPassword())
				.toString();
	}

}