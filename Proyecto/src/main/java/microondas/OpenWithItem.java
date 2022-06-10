package microondas;


public class OpenWithItem extends State{

	public OpenWithItem(Microwave m) {
		m.setCooking(false); 
		m.setWithItem(true);
		m.setDoorOpen(true);
		m.getHeating().heating_off();
		m.getLamp().lamp_on();
		m.getTurntable().turntable_stop();

	}
	
	@Override
	public void door_opened(Microwave m) {
		throw new RuntimeException("La puerta ya está abierta");
	}
	
	@Override
	public void door_closed(Microwave m) {
		m.setState(new ClosedWithItem(m));
		
	}

	@Override
	public void item_placed(Microwave m) {
		throw new RuntimeException("Ya tienes comida colocada");
		
	}

	@Override
	public void item_removed(Microwave m) {
		m.setState(new OpenWithNoItem(m));
	}

	@Override
	public void cooking_start(Microwave m) {
		throw new RuntimeException("Para cocinar debes tener la puerta cerrada");
	}
	
	@Override
	public void cooking_stop(Microwave m) {
		throw new RuntimeException("Aún no estás cocinando");
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
		throw new RuntimeException("Actualmente no estás cocinando, por lo que el contador no puede actuar");
		
	}
	
}
