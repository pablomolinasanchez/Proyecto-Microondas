Feature: ClosedWithNoItemTest

   Scenario: Tenemos un microondas ClosedWithNoItem
    Given ClosedWithNoItem
    When Tengo un microondas ClosedWithNoItem
    Then la luz está apagada
    And el plato no gira
    And no tiene comida
    And no calienta
    And la puerta cerrada
    And no cocina
   
    
  Scenario: Abrir un microondas ClosedWithNoItem
    Given ClosedWithNoItem
    When Abro la puerta
    Then Obtenemos un OpenWithNoItem
    
     Scenario: Incrementamos la potencia
    Given ClosedWithNoItem
    When Incrementamos la potencia a los <a> de potencia
    Then Teniamos <a> y ahora <b> de potencia
    Examples:
    |	a  |	b  |
    |	0	 |	50 |
    |	50 |	100|
    |	200|	250|
    
  Scenario: Incrementamos el tiempo
    Given ClosedWithNoItem
    When Incrementamos el tiempo a los <a> de tiempo
    Then Teniamos <a> y ahora <b> de tiempo
    Examples:
    |	a |	b |
    |	0	|	5 |
    |	5 |	10|
    |	20|	25|
