package com.altioracorp.core;

//abstract class Ruc {
//
//	private String consecutivoCadena;
//	private String numeroIdentificacion;
//	private String principalSucursalCadena;
//	private String provinciaCadena;
//	private RucTipo tipo;
//	private String tipoCadena;
//	private String verificadorCadena;
//
//	public Ruc(RucTipo tipo, String numeroIdentificacion) {
//		this.tipo = tipo;
//		this.numeroIdentificacion = numeroIdentificacion;
//		descomponer();
//	}
//
//	protected abstract void descomponer();
//
//	protected final void descomponer514() {
//		provinciaCadena = numeroIdentificacion.substring(0, 2);
//		tipoCadena = numeroIdentificacion.substring(2, 3);
//		consecutivoCadena = numeroIdentificacion.substring(3, 8); // 5
//		verificadorCadena = numeroIdentificacion.substring(8, 9); // 1
//		principalSucursalCadena = numeroIdentificacion.substring(9, 13); // 4
//	}
//
//	protected final void descomponer613() {
//		provinciaCadena = numeroIdentificacion.substring(0, 2);
//		tipoCadena = numeroIdentificacion.substring(2, 3);
//		consecutivoCadena = numeroIdentificacion.substring(3, 9); // 6
//		verificadorCadena = numeroIdentificacion.substring(9, 10); // 1
//		principalSucursalCadena = numeroIdentificacion.substring(10, 13); // 3
//	}
//
//	public String getConsecutivoCadena() {
//		return consecutivoCadena;
//	}
//
//	public String getPrincipalSucursalCadena() {
//		return principalSucursalCadena;
//	}
//
//	public String getProvinciaCadena() {
//		return provinciaCadena;
//	}
//
//	public RucTipo getTipo() {
//		return tipo;
//	}
//
//	public String getTipoCadena() {
//		return tipoCadena;
//	}
//
//	public String getVerificadorCadena() {
//		return verificadorCadena;
//	}
//
//	protected abstract void validacionEspecifica() throws Exception;
//
//	public final void validar() throws Exception {
//		validarPrincipalSucursal();
//		validacionEspecifica();
//	}
//
//	protected abstract void validarPrincipalSucursal() throws Exception;
//
//	void validarProvincia() throws Exception {
//		final short digitosProvincia = Short.parseShort(provinciaCadena);
////		ValidacionNumeroIdentificacionOperacionesComunes.validarProvincia(digitosProvincia);
//	}
//}
//
//class RucJuridico extends RucNoNaturalBase {
//
//	public RucJuridico(String numeroIdentificacion) {
//		super(RucTipo.RUC_JURIDICO, numeroIdentificacion);
//	}
//
//	@Override
//	protected short calcularDigitoVerificador(String base, short[] coeficientes) {
////		return calcularModulo11(base, coeficientes);
//		return 1;
//	}
//
//	@Override
//	protected short[] coeficientes() {
//		return new short[] { 4, 3, 2, 7, 6, 5, 4, 3, 2 };
//	}
//
//	@Override
//	protected void descomponer() {
//		descomponer613();
//	}
//
//	@Override
//	protected short longitudBase() {
//		return 9;
//	}
//
//	@Override
//	protected void validarPrincipalSucursal() throws Exception {
//		if (getPrincipalSucursalCadena().equals("000")) {
//			throw new Exception(getPrincipalSucursalCadena());
//		}
//	}
//}
//
//class RucNatural extends Ruc {
//
//	public RucNatural(String numeroIdentificacion) {
//		super(RucTipo.RUC_NATURAL, numeroIdentificacion);
//	}
//
//	@Override
//	protected void descomponer() {
//		descomponer613();
//	}
//
//	@Override
//	protected void validacionEspecifica() throws Exception {
//		ValidadorCedula
//				.validar(getProvinciaCadena() + getTipoCadena() + getConsecutivoCadena() + getVerificadorCadena());
//	}
//
//	@Override
//	protected void validarPrincipalSucursal() throws Exception {
//		switch (getPrincipalSucursalCadena()) {
//		case "001":
//		case "002":
//		case "003":
//			return;
//		default:
//			throw new Exception(getPrincipalSucursalCadena());
//		}
//	}
//}
//
//abstract class RucNoNaturalBase extends Ruc {
//
//	public RucNoNaturalBase(RucTipo tipo, String numeroIdentificacion) {
//		super(tipo, numeroIdentificacion);
//	}
//
//	protected abstract short calcularDigitoVerificador(String base, short[] coeficientes);
//
//	protected abstract short[] coeficientes();
//
//	private final String conformarBase() {
//		return getProvinciaCadena() + getTipoCadena() + getConsecutivoCadena();
//	}
//
//	protected abstract short longitudBase();
//
//	protected void validacionEspecifica() throws Exception {
//
//		validarProvincia();
//
//		final String base = conformarBase();
//		validarLongitudBase(base);
//
//		final short[] coeficientes = coeficientes();
//		validarLongitudCoeficientes(coeficientes);
//
//		final short verificadorCalculado = calcularDigitoVerificador(base, coeficientes);
//		final short verificadorDigito = Short.parseShort(getVerificadorCadena());
//
//		if (verificadorCalculado != verificadorDigito) {
//			throw new Exception();
//		}
//	}
//
//	private void validarLongitudBase(String base) throws Exception {
//		if (base.length() != longitudBase()) {
//			throw new Exception();
//		}
//	}
//
//	private void validarLongitudCoeficientes(short[] coeficientes) throws Exception {
//		if (coeficientes.length != longitudBase()) {
//			throw new Exception();
//		}
//	}
//}
//
//class RucPublico extends RucNoNaturalBase {
//
//	public RucPublico(String numeroIdentificacion) {
//		super(RucTipo.RUC_PUBLICO, numeroIdentificacion);
//	}
//
//	@Override
//	protected short calcularDigitoVerificador(String base, short[] coeficientes) {
//		return calcularModulo11(base, coeficientes);
//	}
//
//	@Override
//	protected short[] coeficientes() {
//		return new short[] { 3, 2, 7, 6, 5, 4, 3, 2 };
//	}
//
//	@Override
//	protected void descomponer() {
//		descomponer514();
//	}
//
//	@Override
//	protected short longitudBase() {
//		return 8;
//	}
//
//	@Override
//	protected void validarPrincipalSucursal() throws Exception {
//		if (getPrincipalSucursalCadena().equals("000")) {
//			throw new Exception(getPrincipalSucursalCadena());
//		}
//	}
//}
//
//enum RucTipo {
//	INVALIDO, RUC_JURIDICO, RUC_NATURAL, RUC_PUBLICO,
//}

public class ValidadorRuc {

//	private static final String PATRON = "^\\d{13}$";
//
//	private static Ruc crearRucDeTipoConNumeroIdentificacion(RucTipo tipo, String numeroIdentificacion)
//			throws Exception {
//
//		switch (tipo) {
//		case RUC_JURIDICO:
//			return new RucJuridico(numeroIdentificacion);
//		case RUC_NATURAL:
//			return new RucNatural(numeroIdentificacion);
//		case RUC_PUBLICO:
//			return new RucPublico(numeroIdentificacion);
//		default:
//			throw new Exception();
//		}
//	}
//
//	private static String extraerTipo(String numeroIdentificacion) {
//		return numeroIdentificacion.substring(2, 3);
//	}
//
//	static RucTipo identificarTipo(short digito) {
//		if (digito == 9) {
//			return RucTipo.RUC_JURIDICO;
//		} else if (digito == 6) {
//			return RucTipo.RUC_PUBLICO;
//		} else if ((digito >= 0) && (digito <= 5)) {
//			return RucTipo.RUC_NATURAL;
//		} else {
//			return RucTipo.INVALIDO;
//		}
//	}
//
//	public static void validar(String numeroIdentificacion) throws Exception {
//
//		validarPatron(numeroIdentificacion);
//
//		final String tipoCadena = extraerTipo(numeroIdentificacion);
//		final RucTipo tipo = validarTipo(tipoCadena);
//
//		final Ruc ruc = crearRucDeTipoConNumeroIdentificacion(tipo, numeroIdentificacion);
//		ruc.validar();
//	}
//
//	static void validarPatron(String numeroIdentificacion) throws Exception {
//		if (!Pattern.compile(PATRON).matcher(numeroIdentificacion).matches()) {
//			throw new Exception();
//		}
//	}
//
//	private static RucTipo validarTipo(String tipoCadena) throws Exception {
//
//		final short digitoTipo = Short.parseShort(tipoCadena);
//
//		final RucTipo tipo = identificarTipo(digitoTipo);
//
//		if (tipo.equals(RucTipo.INVALIDO)) {
//			throw new Exception();
//		} else {
//			return tipo;
//		}
//	}
}
