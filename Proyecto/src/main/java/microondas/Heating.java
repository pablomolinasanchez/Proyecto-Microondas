package microondas;

public class Heating {
	private boolean heating=false;
	private Integer power=0;
	
	public void heating_on() {
		heating=true;
	}
	
	public void heating_off() {
		heating=false;
	}
	
	public void setPower(Integer power) {
		this.power=power;
	}
	
	public boolean isHeating() {
		return heating;
	}
	
	public Integer getPower() {
		return power;
	}

}
