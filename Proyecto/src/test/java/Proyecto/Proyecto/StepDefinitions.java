package Proyecto.Proyecto;
import microondas.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
	Microwave m;
	int a;
	int b;
	
	@Given("ClosedWithNoItem")
	public void ClosedWithNoItem() {
		m=new Microwave();
	}
	
	@Given("ClosedWithItem")
	public void ClosedWithItem() {
		ClosedWithNoItem();
		m.door_opened();
		m.item_placed();
		m.door_closed();
	}
	
	@Given("OpenWithNoItem")
	public void OpenWithNoItem() {
		ClosedWithNoItem();
		m.door_opened();
	}
	
	@Given("ClosedWithItem")
	public void OpenWithItem() {
		ClosedWithNoItem();
		m.door_opened();
		m.item_placed();
	}
	
	@Given("Cooking")
	public void Cooking() {
		ClosedWithItem();
		m.door_opened();
		m.item_placed();
		m.door_closed();
		m.power_inc();
		m.timer_inc();
		m.cooking_start();
		
	}
	
	@When("Abro la puerta")
	public void abro_puerta() {
		m.door_opened();
		
	}
	
	@When("Cierro la puerta")
	public void cierro_puerta() {
		m.door_opened();
		
	}
	
	@When("Paro de cocinar")
	public void paro_cocinar() {
		m.cooking_stop();
		
	}
	
	@When("Reseteo la potencia")
	public void reseteo_potencia() {
		m.power_reset();
		
	}
	
	@When("Reseteo el tiempo")
	public void reseteo_tiempo() {
		m.timer_reset();
		
	}
	
	@When("Quito comida")
	public void quito_comida() {
		m.item_removed();
		
	}
	
	@When("Coloco la comida")
	public void coloco_comida() {
		m.item_placed();
		
	}
	
	@When("Incrementamos la potencia a los <a> de potencia")
	public void incrementamos_potencia() {
		a=m.getPower();
		m.power_inc();
		
	}
	
	@When("Incrementamos el tiempo a los <a> de tiempo")
	public void incrementamos_tiempo() {
		a=m.getTimer();
		m.timer_inc();
		
	}
	@Then("Obtenemos un ClosedWithNoItem")
	public void obtenemos_ClosedWithNoItem() {
		Assertions.assertTrue(m.getState() instanceof ClosedWithNoItem);
		
	}
	
	@Then("Obtenemos un ClosedWithItem")
	public void obtenemos_ClosedWithItem() {
		Assertions.assertTrue(m.getState() instanceof ClosedWithItem);
	}
	
	@Then("Obtenemos un OpenWithNoItem")
	public void obtenemos_OpenWithNoItem() {
		Assertions.assertTrue(m.getState() instanceof OpenWithNoItem);
	}
	
	@Then("Obtenemos un OpenWithItem")
	public void obtenemos_OpenWithItem() {
		Assertions.assertTrue(m.getState() instanceof OpenWithItem);
	}
	
	@Then("Obtenemos un Cooking")
	public void obtenemos_Cooking() {
		Assertions.assertTrue(m.getState() instanceof Cooking);
		
	}
	
	@Then("Teniamos <a> y ahora <b> de potencia")
	public void teniamos_tenemos_potencia() {
		b=m.getPower();
	}
	
	@Then("Teniamos <a> y ahora <b> de tiempo")
	public void teniamos_tenemos_tiempo() {
		b=m.getTimer();
	}
	
	@Then("el plato no gira")
	public void plato_no_gira() {
		Assertions.assertFalse(m.getTurntable().isMoving());
	}
	
	@Then("el plato gira")
	public void plato_gira() {
		Assertions.assertTrue(m.getTurntable().isMoving());
	}
	
	@Then("la luz está apagada")
	public void luz_apagada() {
		Assertions.assertFalse(m.getLamp().isLampOn());
	}
	
	@Then("la luz está encendida")
	public void luz_encendida() {
		Assertions.assertTrue(m.getLamp().isLampOn());
	}
	
	@Then("no tiene comida")
	public void no_comida() {
		Assertions.assertFalse(m.isWithItem());
	}
	
	@Then("tiene comida")
	public void si_comida() {
		Assertions.assertTrue(m.isWithItem());
	}
	
	@Then("no calienta")
	public void no_calienta() {
		Assertions.assertFalse(m.getHeating().isHeating());
	}
	
	@Then("calienta")
	public void calienta() {
		Assertions.assertTrue(m.getHeating().isHeating());
	}
	
	@Then("la puerta abierta")
	public void puerta_abierta() {
		Assertions.assertTrue(m.isDoorOpen());
	}
	
	@Then("la puerta cerrada")
	public void puerta_cerrada() {
		Assertions.assertFalse(m.isDoorOpen());
	}
	
	@Then("no cocina")
	public void no_cocina() {
		Assertions.assertFalse(m.isCooking());
	}
	
	@Then("cocina")
	public void cocina() {
		Assertions.assertTrue(m.isCooking());
	}
	
	
	

}
