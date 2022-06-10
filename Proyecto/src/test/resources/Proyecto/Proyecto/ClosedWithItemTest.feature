Feature: ClosedWithItemTest 

   Scenario: Tenemos un microondas ClosedWithItem
    Given ClosedWithItem
    When Tengo un microondas ClosedWithItem
    Then la luz está apagada
    And el plato no gira
    And tiene comida
    And no calienta
    And la puerta cerrada
    And no cocina
   
    
  Scenario: Abrir un microondas ClosedWithItem
    Given ClosedWithItem
    When Abro la puerta
    Then Obtenemos un OpenWithItem
    
  Scenario: Incrementamos la potencia
    Given ClosedWithItem
    When Incrementamos la potencia a los <a> de potencia
    Then Teniamos <a> y ahora <b> de potencia
    Examples:
    |	a  |	b  |
    |	0	 |	50 |
    |	50 |	100|
    |	200|	250|
    
  Scenario: Incrementamos el tiempo
    Given ClosedWithItem
    When Incrementamos el tiempo a los <a> de tiempo
    Then Teniamos <a> y ahora <b> de tiempo
    Examples:
    |	a |	b |
    |	0	|	5 |
    |	5 |	10|
    |	20|	25|
   
  Scenario: Queremos cocinar
    Given ClosedWithItem
    When La potencia no es cero
    And El tiempo no es cero
    Then Cocinamos
   




  