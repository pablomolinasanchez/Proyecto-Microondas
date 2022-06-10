package microondas;

public class ClosedWithItem extends State {

	public ClosedWithItem(Microwave m) {
		m.setCooking(false); 
		m.setWithItem(true);
		m.setDoorOpen(false);
		m.getHeating().heating_off();
		m.getLamp().lamp_off();
		m.getTurntable().turntable_stop();
		m.getDisplay().clearDisplay();
	}
	
	@Override
	public void door_opened(Microwave m) {
		m.setState(new OpenWithItem(m));
	}

	@Override
	public void door_closed(Microwave m) {
		throw new IllegalStateException("Puerta cerrada");
	}

	@Override
	public void item_placed(Microwave m) {
		throw new RuntimeException("Puerta cerrada");
	}

	@Override
	public void item_removed(Microwave m) {
		throw new RuntimeException("Puerta cerrada");
	}

	@Override
	public void cooking_start(Microwave m) {
		if(m.getTimer() > 0 && m.getPower() > 0) {
			m.setState(new Cooking(m));
		} else {
			throw new RuntimeException("Debe seleccionar tiempo y potencia adecuados");
		}
	}

	@Override
	public void cooking_stop(Microwave m) {
		throw new RuntimeException("No estamos cocinando");
	}

	@Override
	public void timer_reset(Microwave m) {
		m.setTimer(0);
		
	}
	
	@Override
	public void power_reset(Microwave m) {
		m.setPower(0);
	}

	@Override
	public void power_desc(Microwave m) {
			m.power_dec();
			m.getDisplay().setDisplay(Integer.toString(m.getPower()));
		}
	

	@Override
	public void timer_desc(Microwave m) {
			m.timer_dec();
			m.getDisplay().setDisplay(Integer.toString(m.getTimer()));
		}
	@Override
	public void power_inc(Microwave m) {
			m.power_inc();
			m.getDisplay().setDisplay(Integer.toString(m.getPower()));
		
	}
	
	@Override
	public void timer_inc(Microwave m) {
		m.timer_inc();
		m.getDisplay().setDisplay(Integer.toString(m.getTimer()));
	}
	

	@Override
	public void tick(Microwave m) {
		throw new RuntimeException("Aún no estamos cocinando");
	}
	
	

	}

