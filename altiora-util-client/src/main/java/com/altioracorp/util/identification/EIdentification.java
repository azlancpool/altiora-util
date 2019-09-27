/**
 * 
 */
package com.altioracorp.util.identification;

/**
 * @author Cnaranjo
 *
 */
public enum EIdentification {
	CEDULA("C\u00C9DULA", 2), RUC("RUC", 1), PASAPORTE("PASAPORTE", 3);

	private String identificationTypeName;

	private int identificationTypeNumberValue;

	private EIdentification(String identificationTypeName, int identificationTypeNumberValue) {
		this.identificationTypeName = identificationTypeName;
		this.identificationTypeNumberValue = identificationTypeNumberValue;
	}

	public String getIdentificationTypeName() {
		return identificationTypeName;
	}

	public int getIdentificationTypeNumberValue() {
		return identificationTypeNumberValue;
	}

}
