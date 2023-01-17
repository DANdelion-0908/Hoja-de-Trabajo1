package Model;

import java.util.ArrayList;

public class Radio implements IRadio {
    
    private boolean state;
	private String Frequence = "AM";
	private double FMActualStation = 87.9;
	private int AMActualStation = 530;
	private double FMSlot;
	private int AMSlot;

	
	
    public Radio() {
    	state = false;
    }
    
	public boolean isOn() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getFrequence() {
		return Frequence;
	}
	
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

	public double getFMActualStation() {
		return FMActualStation;
	}

	public void setFMActualStation(double actualStation) {
		FMActualStation = actualStation;
	}

	public int getAMActualStation() {
		return AMActualStation;
	}

	public void setAMActualStation(int actualStation) {
		AMActualStation = actualStation;
	}

	@Override
	public void on() {
		state = true;
		
	}

	@Override
	public void off() {
		state = false;
		
	}

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

	@Override
	public void saveFMStation(double actualStation, int slot) {
		if(Frequence.equals("FM")) {
			FMSavedStations.add(slot + 1, FMActualStation);
			
		} else {
			System.out.println("No se puede guardar la emisora en la frecuencia actual.");
		}
	}

	private ArrayList<Integer> AMSavedStations = new ArrayList<>();
	
	@Override
	public void saveAMStation(int actualStation, int slot) {
		
		if(Frequence.equals("AM")) {
			AMSavedStations.add(slot - 1, AMActualStation);
			
		} else {
			System.out.println("No se puede guardar la emisora en la frecuencia actual.");
		}
	}

	@Override
	public double getFMSlot(int slot) {
		return FMSlot;
	}

	@Override
	public int getAMSlot(int slot) {
		return AMSlot;
	}

	}


