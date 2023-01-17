package Model;

import java.util.ArrayList;

public class Radio implements IRadio {
    
    private boolean state;
	private String Frequence = "AM";
	private double FMActualStation = 87.9;
	private int AMActualStation = 530;
	private double FMSlot;
	private int AMSlot;

	
	
    // The constructor of the class.
	public Radio() {
    	state = false;
    }
    
	/**
	 * This function returns a boolean value that is true if the light is on and false if the light is off
	 * 
	 * @return The state of the light.
	 */
	public boolean isOn() {
		return state;
	}

	/**
	 * This function sets the state of the light to the value of the parameter
	 * 
	 * @param state The state of the button.
	 */
	public void setState(boolean state) {
		this.state = state;
	}

	/**
	 * This function returns the value of the variable Frequence
	 * 
	 * @return The value of the variable Frequence.
	 */
	public String getFrequence() {
		return Frequence;
	}
	
	/**
	 * This function is used to set the frequency of the radio
	 * 
	 * @param freq The frequency of the radio.
	 */
	@Override
	public void setFrequence(String freq) throws Exception {
			try{
				if(freq.toUpperCase().equals("AM")){
					this.Frequence = freq.toUpperCase();
				
				} else if(freq.toUpperCase().equals("FM")){
					this.Frequence = freq.toUpperCase();
					
				}
			} catch(Exception e) {
				System.out.println("Se ha detectado el error: " + e.getMessage());
				e.printStackTrace();
				
			}
	
	}

	/**
	 * This function returns the actual station of the FM radio
	 * 
	 * @return The value of the variable FMActualStation.
	 */
	public double getFMActualStation() {
		return FMActualStation;
	}

	/**
	 * This function sets the actual station of the FM radio
	 * 
	 * @param actualStation The station that the train is currently at.
	 */
	public void setFMActualStation(double actualStation) {
		FMActualStation = actualStation;
	}

	/**
	 * This function returns the current AM station
	 * 
	 * @return The AMActualStation variable is being returned.
	 */
	public int getAMActualStation() {
		return AMActualStation;
	}

	/**
	 * This function sets the actual station of the AM radio
	 * 
	 * @param actualStation The station that the user is currently listening to.
	 */
	public void setAMActualStation(int actualStation) {
		AMActualStation = actualStation;
	}

	/**
	 * This function turns the radio on
	 */
	@Override
	public void on() {
		state = true;
		
	}

	/**
	 * The function off() sets the state of the radio to false
	 */
	@Override
	public void off() {
		state = false;
		
	}

	/**
	 * The function Forward() is used to change the station to the next one
	 */
	@Override
	public void Forward() {
		if(Frequence.equals("AM")) {
			if(AMActualStation < 1610) {
				AMActualStation += 10;
			}else if(AMActualStation >= 1610) {
				AMActualStation = 530;
			}
			System.out.println("La emisora actual es: " +  AMActualStation + " AM.");
		} if(Frequence.equals("FM")) {
			if(FMActualStation < 107.9) {
				FMActualStation += 0.2;
			}else if(FMActualStation >= 107.9) {
					FMActualStation = 87.9;
			}
			System.out.println("La emisora actual es: " + FMActualStation + " FM.");
		}
		System.out.println("");
	}

	/**
	 * This function is used to change the station to the previous one
	 */
	@Override
	public void Backward() {
		if(Frequence.equals("AM")) {
			if(AMActualStation > 530) {
				AMActualStation -= 10;
			}else if(AMActualStation <= 530) {
				AMActualStation = 1610;
			}
			System.out.println("La emisora actual es: " + AMActualStation + " AM.");
			
		} if(Frequence.equals("FM") ) {
			if(FMActualStation > 87.9) {
				FMActualStation -= 0.2;
			}else if(FMActualStation <= 87.9) {
				FMActualStation = 107.9;
			}
			System.out.println("La emisora actual es: " + FMActualStation + " FM.");
		}
	}
	
	private ArrayList<Double> FMSavedStations = new ArrayList<>();

	/**
	 * It adds 12 empty slots to the array, then adds the actual station to the slot that the user wants
	 * 
	 * @param actualStation The actual station that the user is listening to.
	 * @param slot The slot where the station will be saved.
	 */
	@Override
	public void saveFMStation(double actualStation, int slot) {
		if(Frequence.equals("FM")) {
			for(int i = 0; i < 12; i++) {
				FMSavedStations.add(0.0);
			}
			FMSavedStations.add(slot - 1, FMActualStation);
			
		} else {
			System.out.println("No se puede guardar la emisora en la frecuencia actual.");
		}
	}

	private ArrayList<Integer> AMSavedStations = new ArrayList<>();
	
	/**
	 * This function saves the actual AM station in the slot that the user wants
	 * 
	 * @param actualStation The actual station that the user is listening to.
	 * @param slot The slot where the user wants to save the station.
	 */
	@Override
	public void saveAMStation(int actualStation, int slot) {
		if(Frequence.equals("AM")) {
			for(int i = 0; i < 12; i++) {
				AMSavedStations.add(0);
			}
			
			AMSavedStations.add(slot - 1, AMActualStation);
		} else {
			System.out.println("No se puede guardar la emisora en la frecuencia actual.");
		}
	}

	/**
	 * This function returns the FM station saved in the slot specified by the parameter
	 * 
	 * @param slot The slot number to get the frequency from.
	 * @return The FM station saved in the slot.
	 */
	@Override
	public double getFMSlot(int slot) {
		return FMSavedStations.get(slot);
	}

	/**
	 * This function returns the AM station saved in the slot passed in as a parameter
	 * 
	 * @param slot The slot number of the station you want to get.
	 * @return The AMSavedStations.get(slot) is being returned.
	 */
	@Override
	public int getAMSlot(int slot) {
		return AMSavedStations.get(slot);
	}

	}


