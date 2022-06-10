Feature: OpenWithItemTest

  Scenario: Tenemos un microondas OpenWithItem
    Given OpenWithItem
    When Tengo un microondas OpenWithItem
    Then la luz está encendida
    And el plato no gira
    And tiene comida
    And no calienta
    And la puerta abierta
    And no cocina
   
  Scenario: Cerrar un microondas OpenWithItem
    Given OpenWithItem
    When Cierro la puerta
    Then Obtenemos un ClosedWithItem
    
   Scenario: Quitar comida de un microondas OpenWithItem
    Given OpenWithItem
    When Quito comida
    Then Obtenemos un OpenWithNoItem
    
  Scenario: Incrementamos la potencia
    Given OpenWithItem
    When Incrementamos la potencia a los <a> de potencia
    Then Teniamos <a> y ahora <b> de potencia
    Examples:
    |	a  |	b  |
    |	0	 |	50 |
    |	50 |	100|
    |	200|	250|
    
  Scenario: Incrementamos el tiempo
    Given OpenWithItem
    When Incrementamos el tiempo a los <a> de tiempo
    Then Teniamos <a> y ahora <b> de tiempo
    Examples:
    |	a |	b |
    |	0	|	5 |
    |	5 |	10|
    |	20|	25|