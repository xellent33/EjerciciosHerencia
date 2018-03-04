package meteo;

/**
 * La clase main contiene el programa principal
 * Es tan solo una muestra de funcionamiento de las estaciones climaticas
 * 
 * @author Alberto
 * @author Javier Sergio Prado
 * @version 1.0
 */
public class Main {

	/**
	 * El metodo main del programa 
	 * Un programa muy simple para testear el funcionamiento de las estaciones.
	 * 
	 * @param argv
	 */
public static void main (  String [] argv ){ 
        
        EstacionClimatica estacion  = new EstacionClimatica("Burgos",2017); 
       

        System.out.println(" Introducir 5 medidas :"); 
        

        for (int i=0; i< 5; i++){ 
             TempHumDia  medicion = EstacionClimatica.leerMedida (); 
             estacion.addDia( medicion); 
        } 
        
       estacion.listarDias(); 
        
       System.out.println("Introduca 2 medidas a Borrar:"); 
       TempHumDia  medida1 = EstacionClimatica.leerMedida(); 
       TempHumDia  medida2 = EstacionClimatica.leerMedida(); 
       
       estacion.delDia(medida1); 
       estacion.delDia(medida2); 

       
       estacion.listarDias();      
             
    }            
        
 }
	
