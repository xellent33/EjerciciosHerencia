package meteo;

/**
 * La clase TempDia es una plantilla de mediciones basicas de temperatura con fecha
 * 
 * @author Javier Sergio Prado
 * @version 1.0
 */
public class TempDia {

	protected int a�o;
	protected int mes;
	protected int dia;
	protected int tempMax;
	protected int tempMin;
	
	/**
	 * El constructor por defecto genera una fecha valida y mediciones a 0
	 * Los valores son arbitrarios y pueden modificarse segun necesidades.
	 */
	public TempDia() {
		this.a�o = 1990;
		this.mes = 1;
		this.dia = 1;
		this.tempMax = 0;
		this.tempMin = 0;
	}
	
	/**
	 * Este constructor recibe los valores de los parametros
	 * 
	 * @param dia dia
	 * @param mes mes
	 * @param a�o a�o
	 * @param tMax temperatura maxima
	 * @param tMin temperatura minima
	 */
	public TempDia(int dia, int mes, int a�o, int tMax, int tMin) {
		this.a�o = a�o;
		this.mes = mes;
		this.dia = dia;
		this.tempMax = tMax;
		this.tempMin = tMin;
	}
	
	/**
	 * Devuelve un String con los valores de los parametros 
	 */
	public String toString() {
		return "Fecha Medicion: " + dia + "/" + mes + "/" + a�o + 
				"\n Temperatura Maxima :" + this.tempMax + " Temperatura Minima: " + this.tempMin + " Temperatura Media " + ((this.tempMax+this.tempMin)/2);
	}
}
