package com.acme.example.custom.message.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.acme.architecture.common.entity.AbstractEntity;

@Entity
@Table(name = "custommessage")
public class CustomMessage extends AbstractEntity {

	private static final long serialVersionUID = -6242095987088758384L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "vip")
	private boolean vip;

	
	@Column(name = "creationdate")
	private Date creationDate;
	
	@Column(name = "deleteddate")
	private Date deletedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

	@Override
	public boolean equals(Object object) {
		
		if (this == object) {
			return true;
		}

		if (!(object instanceof CustomMessage)) {
			return false;
		}
		
		final CustomMessage other = (CustomMessage)object;

		return new EqualsBuilder().append(getId(), other.getId())
				.append(getDescription(), other.getDescription())
				.append(isVip(), other.isVip())
				.append(getCreationDate(), other.getCreationDate())
				.append(getDeletedDate(), other.getDeletedDate())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).append(getDescription()).append(isVip()).append(getCreationDate()).append(getDeletedDate()).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).toString();
//		return new ToStringBuilder(this).append("instanceId", this)
//				.append("id", getId())
//				.append("description", getDescription())
//				.append("creationDate", getCreationDate())
//				.append("deletedDate", getDeletedDate())
//				.append("vip", isVip())
//				.toString();
		
	}
	
}
