package Proyecto.Proyecto.TestJava;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import microondas.*;

class TestMicrowave {

	private Microwave m = new Microwave();
	
	@Test
	void testBeeper() {
		// Vemos si se crea correctamente el beeper
		Beeper beeper= new Beeper();
		beeper.beep(3);
		Assertions.assertNotNull(beeper);
		

	}
	
	@Test
	void testDisplay() {
		Display display = new Display();

		// Vemos si imprime bien mensajes
		display.setDisplay("Prueba en el display");
		Assertions.assertEquals("Prueba en el display", display.getDisplay());
		
		// Vemos si al limpiar la pantalla esta se queda vac�a
		display.clearDisplay();
		Assertions.assertEquals("",display.getDisplay());
	}


	@Test
	void testHeating() {
		Heating heating = new Heating();

		// Vemos si cambia correctamente la potencia
		heating.setPower(50);
		Assertions.assertEquals(50, heating.getPower());

		// Vemos su encendido
		heating.heating_on();
		Assertions.assertTrue(heating.isHeating());
		
		//Vemos su apagado
		heating.heating_off();
		Assertions.assertFalse(heating.isHeating());
	
	}

	

	@Test
	void testLamp() {
		Lamp lamp = new Lamp();

		// Vemos el encendido 
		lamp.lamp_on();
		Assertions.assertTrue(lamp.isLampOn());
		
		// Vemos el apagado
		lamp.lamp_off();
		Assertions.assertFalse(lamp.isLampOn());
	
	}

	@Test
	void testTurntable() {
		Turntable turntable = new Turntable();

		// Vemos el inicio 
		turntable.turntable_start();
		Assertions.assertTrue(turntable.isMoving());
		
		// Vemos el parado
		turntable.turntable_stop();
		Assertions.assertFalse(turntable.isMoving());
		
	}

	
	@Test
	void testTimer() {

		// Vemos si funciona el aumentar el tiempo
		m.timer_inc();
		Assertions.assertEquals(5, m.getTimer());
		
		// Vemos si funciona el resetear el tiempo
		m.timer_reset();
		Assertions.assertEquals(0, m.getTimer());

		
		// Vemos si lanza excepci�n si el timer toma valor negativo
		Assertions.assertThrows(RuntimeException.class, () -> m.timer_dec());
		
		// Vemos si lanza error al exceder el tiempo permitido de 60 minutos
		int i=0;
		while(i<=719) {
			m.timer_inc();
			i++;
		}
		Assertions.assertThrows(RuntimeException.class, () -> m.timer_inc());

		

	}
	
	@Test
	void testPower() {

		// Vemos si funciona el aumentar la potencia
		
		m.power_inc();
		Assertions.assertEquals(50, m.getPower());
		
		// Vemos si funciona el resetear la potencia
		m.power_reset();
		Assertions.assertEquals(0, m.getPower());
		
		// Vemos si lanza excepci�n si el timer toma valor negativo
		Assertions.assertThrows(RuntimeException.class, () -> m.power_dec());
		
		// Vemos si lanza error al exceder la potencia permitida de 300 kwh
		int i=0;
		while(i<=5) {
			m.power_inc();
			i++;
		}
		Assertions.assertThrows(RuntimeException.class, () -> m.power_inc());

		

	}

	@Test
	void testClosedWithNoItem() {
		
		// Vemos si se inicializa correctamente recordando que el estado 
		//tiene las siguientes caracter�sticas 		
		//m.setCooking(false); 
		//m.setWithItem(false);
		//m.setDoorOpen(false);
		//m.getHeating().heating_off();
		//m.getLamp().lamp_off();
		//m.getTurntable().turntable_stop();

		Assertions.assertFalse(m.isCooking());
		Assertions.assertFalse(m.isWithItem());
		Assertions.assertFalse(m.isDoorOpen());
		Assertions.assertFalse(m.getHeating().isHeating());
		Assertions.assertFalse(m.getLamp().isLampOn());
		Assertions.assertFalse(m.getTurntable().isMoving());
		Assertions.assertTrue(m.getState() instanceof ClosedWithNoItem);
		
		// Vemos si lanza excepciones 
		Assertions.assertThrows(RuntimeException.class, () -> m.door_closed());
		Assertions.assertThrows(RuntimeException.class, () -> m.cooking_start());
		Assertions.assertThrows(RuntimeException.class, () -> m.cooking_stop());
		Assertions.assertThrows(RuntimeException.class, () -> m.item_placed());
		Assertions.assertThrows(RuntimeException.class, () -> m.item_removed());
		Assertions.assertThrows(RuntimeException.class, () -> m.tick());
		//Vemos si cambia de estado cuando abre la puerta
		m.door_opened();
		Assertions.assertTrue(m.getState() instanceof OpenWithNoItem);

	}

	@Test
	void testOpenWithNoItem() {
		//Abrimos la puerta para obtener el estado
		
		m.door_opened();
		
		// Vemos si se inicializa correctamente recordando que el estado 
		//tiene las siguientes caracter�sticas 		
		//m.setCooking(false); 
		//m.setWithItem(false);
		//m.setDoorOpen(true);
		//m.getHeating().heating_off();
		//m.getLamp().lamp_on();
		//m.getTurntable().turntable_stop();
		Assertions.assertFalse(m.isCooking());
		Assertions.assertFalse(m.isWithItem());
		Assertions.assertTrue(m.isDoorOpen());
		Assertions.assertFalse(m.getHeating().isHeating());
		Assertions.assertTrue(m.getLamp().isLampOn());
		Assertions.assertFalse(m.getTurntable().isMoving());
		Assertions.assertTrue(m.getState() instanceof OpenWithNoItem);

		// Vemos si lanza excepciones
		Assertions.assertThrows(RuntimeException.class, () -> m.door_opened());
		Assertions.assertThrows(RuntimeException.class, () -> m.cooking_start());
		Assertions.assertThrows(RuntimeException.class, () -> m.cooking_stop());
		Assertions.assertThrows(RuntimeException.class, () -> m.item_removed());
		Assertions.assertThrows(RuntimeException.class, () -> m.tick());
		
		m.door_closed();
		Assertions.assertTrue(m.getState() instanceof ClosedWithNoItem);

	}

	@Test
	void testOpenWithItem() {
		//Abrimos la puerta y metemos comida para obtener el estado
		m.door_opened();
		m.item_placed();
		// Vemos si se inicializa correctamente recordando que el estado 
		//tiene las siguientes caracter�sticas 		
		//m.setCooking(false); 
		//m.setWithItem(true);
		//m.setDoorOpen(true);
		//m.getHeating().heating_off();
		//m.getLamp().lamp_on();
		//m.getTurntable().turntable_stop()
		Assertions.assertFalse(m.isCooking());
		Assertions.assertTrue(m.isWithItem());
		Assertions.assertTrue(m.isDoorOpen());
		Assertions.assertFalse(m.getHeating().isHeating());
		Assertions.assertTrue(m.getLamp().isLampOn());
		Assertions.assertFalse(m.getTurntable().isMoving());
		Assertions.assertTrue(m.getState() instanceof OpenWithItem);
		
		// Vemos si lanza excepciones 
		Assertions.assertThrows(RuntimeException.class, () -> m.door_opened());
		Assertions.assertThrows(RuntimeException.class, () -> m.cooking_stop());
		Assertions.assertThrows(RuntimeException.class, () -> m.item_placed());
		Assertions.assertThrows(RuntimeException.class, () -> m.tick());
		// Vemos si cambia de estado al cerrar la puerta
		m.door_closed();
		Assertions.assertTrue(m.getState() instanceof ClosedWithItem);
		// Vemos si cambia de estado al eliminar la comida
		m.door_opened();
		m.item_removed();
		Assertions.assertTrue(m.getState() instanceof OpenWithNoItem);

	}

	@Test
	void testClosedWithItem() {
		//Abrimos la puerta, metemos comida y volvemos a cerrar la puerta para obtener el estado
		m.door_opened();
		m.item_placed();
		m.door_closed();
		// Vemos si se inicializa correctamente recordando que el estado 
		//tiene las siguientes caracter�sticas 		
		//m.setCooking(false); 
		//m.setWithItem(true);
		//m.setDoorOpen(false);
		//m.getHeating().heating_off();
		//m.getLamp().lamp_off();
		//m.getTurntable().turntable_stop();
		Assertions.assertFalse(m.isCooking());
		Assertions.assertTrue(m.isWithItem());
		Assertions.assertFalse(m.isDoorOpen());
		Assertions.assertFalse(m.getHeating().isHeating());
		Assertions.assertFalse(m.getLamp().isLampOn());
		Assertions.assertFalse(m.getTurntable().isMoving());
		Assertions.assertTrue(m.getState() instanceof ClosedWithItem);
		// Vemos si lanza excepciones
		Assertions.assertThrows(RuntimeException.class, () -> m.door_closed());
		Assertions.assertThrows(RuntimeException.class, () -> m.cooking_start());
		Assertions.assertThrows(RuntimeException.class, () -> m.cooking_stop());
		Assertions.assertThrows(RuntimeException.class, () -> m.item_placed());
		Assertions.assertThrows(RuntimeException.class, () -> m.item_removed());
		Assertions.assertThrows(RuntimeException.class, () -> m.tick());

		// Vemos si cambia el estado al abrir la puerta
		m.door_opened();
		Assertions.assertTrue(m.getState() instanceof OpenWithItem);
	}

	@Test
	void testCooking() {
		//Abrimos la puerta, metemos comida, volvemos a cerrar la puerta 
		//y metemos potencia y tiempo para obtener el estado
		m.door_opened();
		m.item_placed();
		m.door_closed();
		m.power_inc();
		m.timer_inc();
		m.cooking_start();
		
		// Vemos si se inicializa correctamente recordando que el estado 
		//tiene las siguientes caracter�sticas 		
		//m.setCooking(true); 
		//m.setWithItem(true);
		//m.setDoorOpen(false);
		//m.getHeating().heating_on();
		//m.getLamp().lamp_on();
		//m.getTurntable().turntable_start();
		Assertions.assertTrue(m.isCooking());
		Assertions.assertTrue(m.isWithItem());
		Assertions.assertFalse(m.isDoorOpen());
		Assertions.assertTrue(m.getHeating().isHeating());
		Assertions.assertTrue(m.getLamp().isLampOn());
		Assertions.assertTrue(m.getTurntable().isMoving());
		Assertions.assertTrue(m.getState() instanceof Cooking);

		// Vemos si lanza excepciones 
		Assertions.assertThrows(RuntimeException.class, () -> m.door_closed());
		Assertions.assertThrows(RuntimeException.class, () -> m.cooking_start());
		Assertions.assertThrows(RuntimeException.class, () -> m.item_placed());
		Assertions.assertThrows(RuntimeException.class, () -> m.item_removed());
		//Vemos si cambia de estado al abrir la puerta
		m.door_opened();
		Assertions.assertTrue(m.getState() instanceof OpenWithItem);
		
		//Vemos si cambia de estado al parar de cocinar
		m.door_closed();
		m.cooking_start();
		m.cooking_stop();
		Assertions.assertTrue(m.getState() instanceof ClosedWithItem);
		
		//Vemos si cambia de estado al resetear el tiempo
		m.timer_reset();
		Assertions.assertTrue(m.getState() instanceof ClosedWithItem);
		
		//Vemos si cambia de estado al resetear la potencia
		m.timer_inc();
		m.cooking_start();
		m.power_reset();
		Assertions.assertTrue(m.getState() instanceof ClosedWithItem);
}



}




