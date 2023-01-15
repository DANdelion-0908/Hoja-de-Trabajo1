package UI;
import Model.IRadio;
import Model.Radio;
import java.util.Scanner;


public class DriverProgram {

    public static void main(String[] args) throws Exception {
        IRadio miRadio = new Radio();
        try (Scanner entrada = new Scanner(System.in)) {
        	boolean loop = true;
            String offOut;
          
            while(loop) {  
            	if(miRadio.isOn()) {
            		System.out.println("La radio está encendida.");
            		System.out.println("La Frecuencia actual es: " + miRadio.getFrequence());
            		System.out.println("");
            		
            		System.out.println("1. Cambiar Frecuencia.");
            		System.out.println("2. Avanzar Emisoras.");
            		System.out.println("3. Retroceder Emisoras.");
            		System.out.println("4. Guardar Emisoras.");
            		System.out.println("5. Emisoras Guardadas.");
            		System.out.println("6. Apagar.");
            		System.out.println("");
            		
            		System.out.println("Ingresa la opción que desees realizar: ");
            		String opt = entrada.nextLine();
            		System.out.println("");
            		
            		switch(opt) {
            		
            		case "1": {
            			System.out.println("Escribe 'AM' o 'FM' para cambiar la frecuencia.");
            			String freq = entrada.nextLine();
            			miRadio.setFrequence(freq);
            			System.out.println("");

            		} break;
            		
            		case "2": {
            			miRadio.Forward();
            		} break;
            		
            		case "3": {
            			
            		} break; 
            		
            		case "4": {
            			
            		} break;
            		
            		case "5": {
            			
            		} break;
            		
            		case "6": {
            			miRadio.off();
            		} break;
            		
            		}
            	}else {
            		System.out.println("La radio está apagada.");
            		System.out.println("Escribe '1' para encender la Radio.");
            		String opt = entrada.nextLine();
            		if(opt.equals("1")) {
            			miRadio.on();
            		}
            	}
            }

          }
        }
    }

