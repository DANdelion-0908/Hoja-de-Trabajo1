package UI;
import Model.IRadio;
import Model.Radio;
import java.util.Scanner;


public class DriverProgram {

    public static void main(String[] args) throws Exception {
        IRadio miRadio = new Radio();
        try (Scanner entrada = new Scanner(System.in)) {
        	boolean loop = true;
          
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
            			miRadio.Backward();
            		} break; 
            		
            		case "4": {
            			System.out.println("Ingresa un número del 1 al 12 para guardar la emisora.");
            			
            			if(miRadio.getFrequence().equals("AM")) {
            				int slot = entrada.nextInt();
            				miRadio.saveAMStation(miRadio.getAMActualStation(), slot);
            				System.out.println("Emisora guardada en la posición: " + slot);
            				
            			} else {
            				int slot = entrada.nextInt();
            				miRadio.saveFMStation(miRadio.getFMActualStation(), slot);
            				System.out.println("Emisora guardada en la posición: " + slot);
            			}
            			System.out.println("");
            			
            		} break;
            		
            		case "5": {
            			if(miRadio.getFrequence().equals("AM")) {
            				int slot = entrada.nextInt();
            				System.out.println("La emisora en esa posición es: " + miRadio.getAMActualStation());
            				System.out.println("La emisora actual es: " + miRadio.getAMActualStation());
            			}
            		} break;
            		
            		case "6": {
            			miRadio.off();
            		} break;
            		
            		}
            	}else {
            		System.out.println("La radio está apagada.");
            		System.out.println("Escribe '1' para encender la Radio.");
            		System.out.println("Escribe '2' para salir de la Radio.");
            		String opt = entrada.nextLine();
            		if(opt.equals("1")) {
            			miRadio.on();
            		}
            		
            		if(opt.equals("2")) {
            			System.out.println("Saliendo...");
            			loop = false;
            		}
            	}
            }

          }
        }
    }

