/**
 * 
 */
package com.altioracorp.core;

import org.springframework.stereotype.Component;

import com.altioracorp.util.identification.EIdentification;
import com.altioracorp.util.logg.LoggerTool;

/**
 * @author Cnaranjo
 *
 */
@Component
public class ValidatorCore implements IValidatorCore {

	@Override
	public Boolean validateIdentificacion(EIdentification identificationType, String identificationNumber) {
		if(EIdentification.CEDULA.equals(identificationType)) {
			return validateCedula(identificationNumber);
		} else if(EIdentification.RUC.equals(identificationType)) {
			return Boolean.FALSE;
		} else {
			return Boolean.FALSE;
		}
	}
	
	
	/**
	 * Service responsible for validating a identification number.
	 * 
	 * @param identificationNumber Identification number.
	 * @return TRUE If is a identification number valid - FALSE Other case.
	 */
	private Boolean validateCedula(String identificationNumber) {
		// Preguntamos si la numeroCedula consta de 10 digitos
		if (identificationNumber.length() == 10) {

			// Obtenemos el digito de la region que sonlos dos primeros digitos
			int regionDigit = Integer.parseInt(identificationNumber.substring(0, 2));

			// Pregunto si la region existe ecuador se divide en 24 regiones
			if (regionDigit >= 1 && regionDigit <= 24) {

				// Extraigo el ultimo digito
				String lastDigit = identificationNumber.substring(9, 10);

				// Agrupo todos los pares y los sumo
				int pairs = Integer.parseInt(identificationNumber.substring(1, 2))
						+ Integer.parseInt(identificationNumber.substring(3, 4))
						+ Integer.parseInt(identificationNumber.substring(5, 6))
						+ Integer.parseInt(identificationNumber.substring(7, 8));

				// Agrupo los impares, los multiplico por un factor de 2, si la resultante es >
				// que 9 le restamos el 9 a la resultante
				int number1 = getOddNumber(identificationNumber, 0, 1);
				int number3 = getOddNumber(identificationNumber, 2, 3);
				int number5 = getOddNumber(identificationNumber, 4, 5);
				int number7 = getOddNumber(identificationNumber, 6, 7);
				int number9 = getOddNumber(identificationNumber, 8, 9);

				int odd = number1 + number3 + number5 + number7 + number9;

				// Suma total
				int total = (pairs + odd);

				// extraemos el primero digito
				int firstDigit = Integer.parseInt(String.valueOf(total).substring(0, 1));

				// Obtenemos la decena inmediata
				int tenNumber = (firstDigit + 1) * 10;

				// Obtenemos la resta de la decena inmediata - la suma_total esto nos da el
				// digito validador
				int checkDigit = tenNumber - total;

				// Si el digito validador es = a 10 toma el valor de 0
				if (checkDigit == 10) {
					checkDigit = 0;
				}

				// Validamos que el digito validador sea igual al de la numeroCedula
				if (checkDigit == Integer.parseInt(lastDigit)) {
					return Boolean.TRUE;
				} else {
					return Boolean.FALSE;
				}

			} else {
				// imprimimos en consola si la region no pertenece
				LoggerTool.LOG.info("La cédula: {} no pertenece a ninguna región", identificationNumber);
				return Boolean.FALSE;
			}
		} else {
			// imprimimos en consola si la numeroCedula tiene mas o menos de 10 digitos
			LoggerTool.LOG.info("La cédula: {} no pertenece a ninguna región", identificationNumber);
			return Boolean.FALSE;
		}
	}
	
	private static int getOddNumber(String number, int beginChain, int endChain) {
		int returnValue = Integer.parseInt(number.substring(beginChain, endChain));
		returnValue = (returnValue * 2);
		if (returnValue > 9) {
			returnValue = (returnValue - 9);
		}
		return returnValue;
	}

}
