package microondas;

public class Microwave {
	private boolean doorOpen=false;
	private Integer power;
	private Integer timer;
	private boolean cooking=false;
	private boolean withItem=false;
	private Heating heating;
	private Lamp lamp;
	private Display display;
	private Turntable turntable;
	private Beeper beeper;
	private State state;
	
	
	
	public Microwave() {
		doorOpen=false;
		power=0;
		timer=0;
		cooking=false;
		withItem=false;
		heating=new Heating();
		lamp=new Lamp();
		display=new Display();
		turntable=new Turntable();
		beeper=new Beeper();
		state=new ClosedWithNoItem(this);
		
				
		
	}

	public void door_opened() {
		state.door_opened(this);
	}
	
	public void door_closed() {
		state.door_closed(this);
	}
	
	public void item_placed() {
		state.item_placed(this);
	}
	
	public void item_removed() {
		state.item_removed(this);
	}
	
	public void power_inc() {
		if(power==300) {
			throw new RuntimeException("No puede incrementar la potencia porque "
					+ "excederías la potencia del microondas");
		}else {
			power=power+50;
		}
		
	}
	
	public void power_dec() {
	
		if(power>=50) {
			power=power-50;
		}else {
			throw new RuntimeException("No existe una potencia negativa");
			
		}
	}
	
	public void power_reset() {
		state.power_reset(this);
	}
	
	public void timer_inc() {
		if(timer==3600) {
			throw new RuntimeException("No puede incrementar el tiempo porque "
					+ "excederías la potencia del microondas");
		}else {
			timer=timer+5;
		}
	}
	
	public void timer_dec() {
		if(timer>=5) {
			timer=timer-5;
			
		}else {
			throw new RuntimeException("No existe un temporizador negativo");
			
		}
	}
	
	public void timer_reset() {
		state.timer_reset(this);
	}
	
	public void tick() {
		state.tick(this);
	}
	
	public void cooking_start() {
		cooking=true;
		state.cooking_start(this);
	}
	
	public void cooking_stop() {
		cooking=false;
		state.cooking_stop(this);
		}

	public void setDoorOpen(boolean doorOpen) {
		this.doorOpen = doorOpen;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public void setTimer(Integer timer) {
		this.timer = timer;
	}

	public void setCooking(boolean cooking) {
		this.cooking = cooking;
	}

	public void setWithItem(boolean withItem) {
		this.withItem = withItem;
	}

	public boolean isDoorOpen() {
		return doorOpen;
	}

	public Integer getPower() {
		return power;
	}

	public Integer getTimer() {
		return timer;
	}

	public boolean isCooking() {
		return cooking;
	}

	public boolean isWithItem() {
		return withItem;
	}

	public Heating getHeating() {
		return heating;
	}

	public Lamp getLamp() {
		return lamp;
	}

	public Display getDisplay() {
		return display;
	}

	public Turntable getTurntable() {
		return turntable;
	}

	public Beeper getBeeper() {
		return beeper;
	}

	public void setHeating(Heating heating) {
		this.heating = heating;
	}

	public void setLamp(Lamp lamp) {
		this.lamp = lamp;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public void setTurntable(Turntable turntable) {
		this.turntable = turntable;
	}

	public void setBeeper(Beeper beeper) {
		this.beeper = beeper;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	
	
	
}

