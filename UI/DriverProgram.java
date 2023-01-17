/*Héctor Daniel Penedo Juarez
 * No. 22217
 * Algoritmos y Estructuras de Datos
 * Hoja de Trabajo 1
 */



package UI;
import Model.IRadio;
import Model.Radio;
import java.util.Scanner;


public class DriverProgram {

    // The main method of the program.
	public static void main(String[] args) throws Exception {
        IRadio miRadio = new Radio();
        try (Scanner entrada = new Scanner(System.in)) {
        	boolean loop = true;
          
            // A loop that is executed until the user decides to exit the program.
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
            		
            		// Asking the user to write AM or FM to change the frequency.
					case "1": {
            			System.out.println("Escribe 'AM' o 'FM' para cambiar la frecuencia.");
            			String freq = entrada.nextLine();
            			miRadio.setFrequence(freq);
            			System.out.println("");

            		} break;
            		
            		// Calling the method Forward() from the class Radio.
					case "2": {
            			miRadio.Forward();
            		} break;
            		
            		// Calling the method Backward() from the class Radio.
					case "3": {
            			miRadio.Backward();
            		} break; 
            		
            		// Asking the user to write a number from 1 to 12 to save the station.
					case "4": {
            			if(miRadio.getFrequence().equals("AM")) {
            				System.out.println("Ingresa un número del 1 al 12 para guardar la emisora.");
            				int slot = entrada.nextInt();
            				miRadio.saveAMStation(miRadio.getAMActualStation(), slot);
            				System.out.println("Emisora guardada.");
            			
            			} else if(miRadio.getFrequence().equals("FM")){
            				System.out.println("Ingresa un número del 1 al 12 para guardar la emisora.");
            				int slot = entrada.nextInt();
            				miRadio.saveFMStation(miRadio.getFMActualStation(), slot);
            				System.out.println("Emisora guardada.");
            			}
            			
            		} break;
            		
            		// Asking the user to write a number from 1 to 12 to select the station.
					case "5": {
            			if(miRadio.getFrequence().equals("AM")) {
            				System.out.println("Selecciona la posición de la emisora: ");
            				int slot = entrada.nextInt();
            				miRadio.saveAMStation(miRadio.getAMActualStation(), slot);
            				System.out.println("La emisora actual es: " + miRadio.getAMSlot(slot) + " AM.");
            				
            			} else if(miRadio.getFrequence().equals("FM")) {
            				System.out.println("Selecciona la posición de la emisora: ");
            				int slot = entrada.nextInt();
            				miRadio.saveFMStation(miRadio.getFMActualStation(), slot);
            				System.out.println("La emisora actual es: " + miRadio.getFMSlot(slot) + " FM.");
            			}
            		} break;
            		
            		// Calling the method off() from the class Radio.
					case "6": {
            			miRadio.off();
            		} break;
            		
            		} 
            		
            	}// This is the code that is executed when the radio is off.
				else {
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

