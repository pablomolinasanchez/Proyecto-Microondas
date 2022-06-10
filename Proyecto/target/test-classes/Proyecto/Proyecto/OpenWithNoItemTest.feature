Feature: OpenWithNoItemTest

  Scenario: Tenemos un microondas OpenWithNoItem
    Given OpenWithNoItem
    When Tengo un microondas OpenWithNoItem
    Then la luz está encendida
    And el plato no gira
    And no tiene comida
    And no calienta
    And la puerta abierta
    And no cocina
   
    
  Scenario: Cerrar un microondas OpenWithNoItem
    Given OpenWithNoItem
    When Cierro la puerta
    Then Obtenemos un ClosedWithNoItem
    
  Scenario: Colocar comida en un microondas OpenWithNoItem
    Given OpenWithNoItem
    When Coloco la comida
    Then Obtenemos un OpenWithItem
    
 Scenario: Incrementamos la potencia
    Given OpenWithNoItem
    When Incrementamos la potencia a los <a> de potencia
    Then Teniamos <a> y ahora <b> de potencia
    Examples:
    |	a  |	b  |
    |	0	 |	50 |
    |	50 |	100|
    |	200|	250|
    
  Scenario: Incrementamos el tiempo
    Given OpenWithNoItem
    When Incrementamos el tiempo a los <a> de tiempo
    Then Teniamos <a> y ahora <b> de tiempo
    Examples:
    |	a |	b |
    |	0	|	5 |
    |	5 |	10|
    |	20|	25|