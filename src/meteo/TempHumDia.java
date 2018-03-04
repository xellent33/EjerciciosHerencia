package meteo;

/**
 * La clase TempHumDia es una extension de la clase TempDia
 * Permite a la plantilla almacenar valores de humedad ademas de los que ya almacena TempDia
 * 
 * @author Javier Sergio Prado
 * @version 1.0
 */
public class TempHumDia extends TempDia {

	private int humedadMax;
	private int humedadMin;
	
	/**
	 * Constructor por defecto, 
	 * llama al constructor de la clase superior y se completa con los atributos de su propia clase
	 */
	 public TempHumDia() {
		super();
		this.humedadMax = 0;
		this.humedadMin = 0;
	}
	 
	 /**
	  * Constructor con parametros de medicion 
	  * Llama al constructor de la clase superior.
	  * 
	  * @param dia
	  * @param mes
	  * @param a�o
	  * @param tMax
	  * @param tMin
	  * @param hMax
	  * @param hMin
	  */
	 public TempHumDia(int dia, int mes, int a�o, int tMax, int tMin, int hMax, int hMin) {
		 super(dia, mes, a�o, tMax, tMin);
		 this.humedadMax = hMax;
		 this.humedadMin = hMin;
	 }
	 
	 /**
	  * Devuelve un String que contiene los valores de medicion con los atributos de la clase
	  */
	 public String toString() {
		 return "Fecha Medicion: " + dia + "/" + mes + "/" + a�o + 
					"\n Temperatura Maxima :" + tempMax + " Temperatura Minima: " + tempMin + " Temperatura Media " + ((tempMax+tempMin)/2) + 
					"\n Humedad Maxima : " + humedadMax + " Humedad Minima: " + humedadMin + " Humedad Media " + ((humedadMax+humedadMin)/2);
	 }
}
