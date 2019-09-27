/**
 * 
 */
package com.altioracorp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altioracorp.core.IValidatorCore;
import com.altioracorp.util.identification.EIdentification;

/**
 * @author Cnaranjo
 *
 */
@Service
public class ValidatorService implements IValidatorService {
	
	@Autowired
	private IValidatorCore validatorCore;

	@Override
	public Boolean validateIdentificacion(EIdentification identificationType, String identificationNumber) {
		return validatorCore.validateIdentificacion(identificationType, identificationNumber);
	}

}
