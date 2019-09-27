/**
 * 
 */
package com.altioracorp.core;

import com.altioracorp.util.identification.EIdentification;

/**
 * @author Cnaranjo
 *
 */
public interface IValidatorCore {
	
	/**
	 * Service responsible for validating an identification number.
	 * 
	 * @param identificationType   Identification type
	 * @param identificationNumber Identification number
	 */
	public Boolean validateIdentificacion(EIdentification identificationType, String identificationNumber);

}
