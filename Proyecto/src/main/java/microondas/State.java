package microondas;
public abstract class State {

	public abstract void door_opened(Microwave m);

	public abstract void door_closed(Microwave m);

	public abstract void item_placed(Microwave m);

	public abstract void item_removed(Microwave m);

	public abstract void cooking_start(Microwave m);

	public abstract void cooking_stop(Microwave m);
	
	public abstract void timer_reset(Microwave m);
	
	public abstract void power_reset(Microwave m);

	public abstract void tick(Microwave m);
	
	public abstract void power_desc(Microwave m);
	
	public abstract void timer_desc(Microwave m);
	
	public abstract void power_inc(Microwave m);
	
	public abstract void timer_inc(Microwave m);

}


