package meteo;

import java.util.Scanner; 

/**
 * La clase EstacionClimatica genera una plantilla que almacena un pool de mediciones del tipo TempHumDia
 * 
 * 
 * @author Alberto
 * @author Javier Sergio Prado
 * @version 1.0
 */
public class EstacionClimatica 
{ 
    private String nombre; 
    private int año; 
    private TempHumDia mediciones[];  // Tabla de mediciones 
    private int nummediciones;      // Número de mediciones almacenadas 

    /** 
     * Constructor por defecto genera un pool de 366 mediciones para almacenar 1 diaria 
     */ 
    public EstacionClimatica() { 
         this.nombre = ""; 
         this.año = 2000;  
         mediciones = new TempHumDia[366];  // Por si el año es bisiesto.  
         nummediciones = 0; 
    } 
    
    /**
     * Constructor con parametros para definir nombre y año de medicion
     * 
     * @param nombre Define el nombre de la Estacion
     * @param año Define el año de la medicion
     */
    public EstacionClimatica( String nombre, int año) { 
         this(); 
         this.nombre = nombre; 
         this.año = año; 
         
    } 
    
    /**
     * Devuelve un String con los valores de la instancia, menos el pool de mediciones.
     * ( el pool de mediciones tiene un metodo en exclusiva)
     */
    public String toString() {
    	return "Nombre Estacion: " + this.nombre + " | Año de mediciones: " + this.año + " | Numero de mediciones: " + this.nummediciones;
    }

    /**
     * Se comprueba que los años de la medicion y de la estacion coincidan, 
     * si es asi entonces añade la fecha a un lugar vacio del pool.
     * 
     * @param medicion Contiene los valores de medicion que presumiblemente se van a añadir al pool.
     * @return Devuelve true si se añaden los valores y false si no han sido añadidos.
     */
    public boolean addDia ( TempHumDia medicion){ 
    	boolean correcto = false;
    	if (medicion.año==this.año) {
    		correcto = true;
    		for (int i=0;i<mediciones.length;i++) {
    			if (mediciones[i] == null) {
    				mediciones[i] = medicion;
    				nummediciones++;
    				break;
    			}
    		}
    	} else {
    		System.out.println("ERROR: El año de la medicion y de la estacion no se corresponden");
    	}
        return correcto;
    } 
    /**
     * Borra una medicion del pool de la estacion, atendiendo al dia y mes que se pasa como parametro de medicion.
     * 
     * @param medicion Contiene los valores de medicion que se quieren borrar
     * @return Devuelve true si la medicion se ha borrado del pool y false si no se ha podido borrar.
     */
    public boolean delDia ( TempHumDia medicion){ 
    	boolean correcto = false;
    	for (int i=0;i<this.mediciones.length;i++) {
    		if (medicion.dia==mediciones[i].dia && medicion.mes==mediciones[i].mes) {
    			mediciones[i] = null;
    			nummediciones--;
    			correcto = true;
    			break;
    		}
    	}
        return correcto; 
    } 
    
    /**
     * Este metodo lista las mediciones que contiene el pool de mediciones de la estacion.
     */
    public void listarDias(){ 
    	for (int i=0;i<mediciones.length;i++) {
    		if (mediciones[i] != null) {
    			System.out.println(mediciones[i].toString());
    		}
    	}
     
    } 
    /**
     * Método auxiliar que me indica si una fecha es correcta 
     * Esta primera version contiene unas restricciones muy laxas para definir una fecha correcta
     * 
     * @param dia dia
     * @param mes mes 
     * @param año año
     * @return Devuelve true si la fecha es valida y false si no es valida
     */
    // 
    static boolean fechaOK ( int dia, int mes, int año){ 
    	
    	boolean correcto = true;
    	if(dia<1||dia>30) correcto = false;
    	if(mes<1||mes>12) correcto = false;
    	if(año<1900) correcto = false;
        
       return correcto; 
    
    } 
    
    /**
     * Pide al usuario introducir valores de medicion que se almacenan para su posterior uso.
     * 
     * @return devuelve un objeto de tipo TempHumDia con valores de medicion.
     */
    static TempHumDia leerMedida () { 

         Scanner leer = new Scanner(System.in); 
         int dia,mes,año, tempmax, tempmin, hummax, hummin; 
         TempHumDia  medicion = null; 
         
        boolean error = true; 
        do { 
        System.out.println("Día:"); dia = leer.nextInt(); 
        System.out.println("Mes:");  mes = leer.nextInt(); 
        System.out.println("Año:");  año = leer.nextInt(); 
  
        if ( fechaOK( dia,mes,año) ) { 
             System.out.println ( " Tº Máxima:"); tempmax = leer.nextInt(); 
             System.out.println ( " Tº Mínima:"); tempmin = leer.nextInt(); 
             System.out.println ( " Hº Máxima:"); hummax = leer.nextInt(); 
             System.out.println ( " Hº Mínima:"); hummin = leer.nextInt(); 
             medicion = new TempHumDia ( dia,mes,año, tempmax, tempmin, hummax, hummin); 
             error = false; 
            } 
        else 
        { 
            System.out.println(" Fecha érronea"); 
        } 
    
    } while (  error); 
    
    leer.close(); 
    return medicion; 
    } 
}