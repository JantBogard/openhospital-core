/*
 * Open Hospital (www.open-hospital.org)
 * Copyright © 2006-2024 Informatici Senza Frontiere (info@informaticisenzafrontiere.org)
 *
 * Open Hospital is a free and open source software for healthcare data management.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * https://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */
package org.isf.medicalstockward.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.Version;

import org.isf.medicals.model.Medical;
import org.isf.medicalstock.model.Lot;
import org.isf.utils.db.Auditable;
import org.isf.ward.model.Ward;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "OH_MEDICALDSRWARD")
@EntityListeners(AuditingEntityListener.class)
@AttributeOverride(name = "createdBy", column = @Column(name = "MDSRWRD_CREATED_BY", updatable = false))
@AttributeOverride(name = "createdDate", column = @Column(name = "MDSRWRD_CREATED_DATE", updatable = false))
@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "MDSRWRD_LAST_MODIFIED_BY"))
@AttributeOverride(name = "active", column = @Column(name = "MDSRWRD_ACTIVE"))
@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "MDSRWRD_LAST_MODIFIED_DATE"))
public class MedicalWard extends Auditable<String> implements Comparable<Object> {

	@EmbeddedId
	MedicalWardId id;

	@Column(name = "MDSRWRD_IN_QTI")
	private float in_quantity;

	@Column(name = "MDSRWRD_OUT_QTI")
	private float out_quantity;

	/**
	 * Lock control
	 */
	@Version
	@Column(name = "MDSRWRD_LOCK", columnDefinition = "INT(11) NOT NULL DEFAULT 0")
	private int lock;

	@Transient
	private Double qty = 0.0;

	@Transient
	private volatile int hashCode;

	public MedicalWard() {
		super();
		this.id = new MedicalWardId();
	}

	public MedicalWard(Medical medical, Double qty) {
		super();
		this.id = new MedicalWardId();
		this.id.setMedical(medical);
		this.qty = qty;
	}

	public MedicalWard(Ward ward, Medical medical, float inQuantity, float outQuantity, Lot lot) {
		super();
		this.id = new MedicalWardId(ward, medical, lot);
		this.in_quantity = inQuantity;
		this.out_quantity = outQuantity;

	}

	public MedicalWard(Medical med, double quantity, Lot lot) {
		super();
		this.id = new MedicalWardId();

		this.id.setMedical(med);
		this.id.setLot(lot);
		this.qty = quantity;
	}

	public MedicalWardId getId() {
		return id;
	}

	public void setId(Ward ward, Medical medical, Lot lot) {
		this.id = new MedicalWardId(ward, medical, lot);
	}

	public Lot getLot() {
		return id.getLot();
	}

	public void setLot(Lot lot) {
		id.setLot(lot);
	}

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public int getLock() {
		return lock;
	}

	public void setLock(int lock) {
		this.lock = lock;
	}

	@Override
	public int compareTo(Object anObject) {
		Medical medical = id.getMedical();
		if (anObject instanceof MedicalWard) {
			return (medical.getDescription().toUpperCase().compareTo(
				((MedicalWard) anObject).getMedical().getDescription().toUpperCase()));
		}
		return 0;
	}

	public Ward getWard() {
		return this.id.getWard();
	}

	public void setWard(Ward ward) {
		this.id.setWard(ward);
	}

	public Medical getMedical() {
		return this.id.getMedical();
	}

	public void setMedical(Medical medical) {
		this.id.setMedical(medical);
	}

	public float getIn_quantity() {
		return this.in_quantity;
	}

	public void setIn_quantity(float inQuantity) {
		this.in_quantity = inQuantity;
	}

	public float getOut_quantity() {
		return this.out_quantity;
	}

	public void setOut_quantity(float outQuantity) {
		this.out_quantity = outQuantity;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MedicalWard ward)) {
			return false;
		}

		return (this.id.getMedical() == ward.id.getMedical());
	}

	@Override
	public int hashCode() {
		if (this.hashCode == 0) {
			final int m = 23;
			int c = 133;

			c = m * c + this.id.getMedical().getCode();

			this.hashCode = c;
		}

		return this.hashCode;
	}
}
