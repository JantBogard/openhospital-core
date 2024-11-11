/*
 * Open Hospital (www.open-hospital.org)
 * Copyright © 2006-2023 Informatici Senza Frontiere (info@informaticisenzafrontiere.org)
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

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import org.isf.medicals.model.Medical;
import org.isf.medicalstock.model.Lot;
import org.isf.ward.model.Ward;

@SuppressWarnings("serial")
@Embeddable
public class MedicalWardId implements Serializable {

	@NotNull
	@ManyToOne
	@JoinColumn(name="MDSRWRD_WRD_ID_A")
	private Ward ward;

	@NotNull
	@ManyToOne
	@JoinColumn(name="MDSRWRD_MDSR_ID")
	private Medical medical;
	
	@ManyToOne
	@JoinColumn(name="MDSRWRD_LT_ID_A")
	private Lot lot;

	public MedicalWardId() {
	}

	public MedicalWardId(Ward ward, Medical medical, Lot lot) {
		this.ward = ward;
		this.medical = medical;
		this.lot = lot;
	}

	public Ward getWard() {
		return this.ward;
	}
	
	public void setWard(Ward ward) {
		this.ward = ward;
	}
	public Lot getLot() {
		return this.lot;
	}
	
	public void setLot(Lot lot) {
		this.lot = lot;
	}

	public Medical getMedical() {
		return this.medical;
	}
	
	public void setMedical(Medical medical) {
		this.medical = medical;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + medical.getCode();
		result = prime * result + ward.getCode().charAt(0);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof MedicalWardId other)) {
			return false;
		}
		if (medical != other.medical) {
			return false;
		}
		if (ward != other.ward) {
			return false;
		}
		return lot == other.lot;
	}
}
