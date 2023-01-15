package Model;
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
	public void setFrequence(String freq) {
			this.Frequence = freq;
	
	}

	public double getFMActualStation() {
		return FMActualStation;
	}

	public void setFMActualStation(double fMActualStation) {
		FMActualStation = fMActualStation;
	}

	public int getAMActualStation() {
		return AMActualStation;
	}

	public void setAMActualStation(int aMActualStation) {
		AMActualStation = aMActualStation;
	}

	public double getFMSlot() {
		return FMSlot;
	}

	public void setFMSlot(double fMSlot) {
		FMSlot = fMSlot;
	}

	public int getAMSlot() {
		return AMSlot;
	}

	public void setAMSlot(int aMSlot) {
		AMSlot = aMSlot;
	
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
		if(Frequence == "AM") {
			if(AMActualStation > 530) {
				AMActualStation -= 10;
			}else if(AMActualStation <= 530) {
				AMActualStation = 1610;
			}
		} if(Frequence == "FM") {
			if(FMActualStation > 87.9) {
				FMActualStation -= 0.2;
			}else if(FMActualStation <= 87.9) {
				FMActualStation = 107.9;
			}
		}
		System.out.println(Frequence);
		
	}

	@Override
	public void saveFMStation(double actualStation, int slot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAMStation(int actualStation, int slot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getFMSlot(int slot) {
		// TODO Auto-generated method stub
		return FMSlot;
	}

	@Override
	public int getAMSlot(int slot) {
		// TODO Auto-generated method stub
		return AMSlot;
	}

	}


