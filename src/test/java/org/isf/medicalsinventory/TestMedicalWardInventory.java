package org.isf.medicalsinventory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.isf.medicalinventory.model.InventoryStatus;
import org.isf.medicalinventory.model.InventoryType;
import org.isf.medicalinventory.model.MedicalInventory;
import org.isf.utils.exception.OHException;
import org.isf.utils.time.TimeTools;
import org.isf.ward.model.Ward;

public class TestMedicalWardInventory {
	private int id = 1;
	private String status = InventoryStatus.draft.toString();
	private LocalDateTime inventoryDate = TimeTools.getNow();
	private String user = "admin";
	private String inventoryReference = "REFERENCE";
	private String inventoryType = InventoryType.ward.toString();
	private String ward = "Z";
	private String destination = "Z";
	private String reason = "reason";

	public MedicalInventory setup(Ward ward, boolean usingSet) throws OHException {
		MedicalInventory medicalInventory;

		if (usingSet) {
			medicalInventory = new MedicalInventory();
			setParameters(medicalInventory);
		} else {
			// create MedicalInventory with all parameters
			medicalInventory = new MedicalInventory(id, status, inventoryDate, user, inventoryReference, inventoryType, ward.getCode(), destination, reason);
		}
		return medicalInventory;
	}

	public void setParameters(MedicalInventory medicalInventory) {
		medicalInventory.setId(id);
		medicalInventory.setStatus(status);
		medicalInventory.setInventoryDate(inventoryDate);
		medicalInventory.setUser(user);
		medicalInventory.setInventoryReference(inventoryReference);
		medicalInventory.setInventoryType(inventoryType);
		medicalInventory.setWard(ward);
		medicalInventory.setDestination(destination);
		medicalInventory.setReason(reason);
	}

	public void check(MedicalInventory medicalInventory, int id) {
		assertThat(medicalInventory.getId()).isEqualTo(id);
		assertThat(medicalInventory.getStatus()).isEqualTo(status);
		assertThat(medicalInventory.getInventoryDate()).isCloseTo(inventoryDate, within(1, ChronoUnit.SECONDS));
		assertThat(medicalInventory.getUser()).isEqualTo(user);
		assertThat(medicalInventory.getInventoryReference()).isEqualTo(inventoryReference);
		assertThat(medicalInventory.getInventoryType()).isEqualTo(inventoryType);
		assertThat(medicalInventory.getWard()).isEqualTo(ward);
		assertThat(medicalInventory.getDestination()).isEqualTo(destination);
		assertThat(medicalInventory.getReason()).isEqualTo(reason);
	}
}
