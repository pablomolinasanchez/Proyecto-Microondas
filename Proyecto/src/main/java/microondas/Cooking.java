package microondas;

import java.util.Timer;
import java.util.TimerTask;

public class Cooking extends State{

	public Cooking(Microwave m) {
		m.setCooking(true); 
		m.setWithItem(true);
		m.setDoorOpen(false);
		m.getHeating().heating_on();
		m.getLamp().lamp_on();
		m.getTurntable().turntable_start();

	}
	
	@Override
	public void door_opened(Microwave m) {
		m.setState(new OpenWithItem(m));
		
	}
	
	@Override
	public void door_closed(Microwave m) {
		throw new RuntimeException("La puerta ya está cerrada");
		
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
		throw new RuntimeException("Ya estás cocinando");
		
	}
	
	@Override
	public void cooking_stop(Microwave m) {
		m.setState(new ClosedWithItem(m));
		
	}
	
	@Override
	public void timer_reset(Microwave m) {
		m.setTimer(0);
		m.setState(new ClosedWithItem(m));
		
	}
	
	@Override
	public void power_reset(Microwave m) {
		m.setPower(0);
		m.setState(new ClosedWithItem(m));
	}

	@Override
	public void power_desc(Microwave m) {
		m.power_dec();
		m.getDisplay().setDisplay(Integer.toString(m.getPower()));
		if(m.getPower()==0) {
			m.setState(new ClosedWithItem(m));
		}
	}
	
	@Override
	public void timer_desc(Microwave m) {
		m.timer_dec();
	    Beeper beep=new Beeper();
	    beep.beep(3);
		if(m.getBeeper()==beep) {
			m.setState(new ClosedWithItem(m));
			m.getDisplay().setDisplay("Comida lista");
			
		}else {
			m.getDisplay().setDisplay(Integer.toString(m.getTimer()));
			
		}
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

			Timer timer=new Timer();
	        timer.scheduleAtFixedRate(new TimerTask() {
	        	int i=1;
	            public void run() {
	            	m.getDisplay().setDisplay(Integer.toString(m.getTimer()-1));
	                i++;

	                if (m.getTimer()-i == 0) {
	                    timer.cancel();
	                    Beeper beeper=new Beeper();
	                    beeper.beep(3);
	                    m.setBeeper(beeper);
	                    m.getDisplay().setDisplay("Comida lista");
	                }
	            }
	        }, 0, 1000);
		}
		
		
}

