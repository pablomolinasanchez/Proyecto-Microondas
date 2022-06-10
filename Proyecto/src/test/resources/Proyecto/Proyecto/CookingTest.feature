Feature: CookingTest

   Scenario: Tenemos un microondas Cooking
    Given Cooking
    When Tengo un microondas Cooking
    Then la luz está encendida
    And el plato gira
    And tiene comida
    And calienta
    And la puerta cerrada
    And la potencia mayor a 0
    And el tiempo mayor a 0
    And cocina
   
    
  Scenario: Abrir un microondas Cooking
    Given Cooking
    When Abro la puerta
    Then Obtenemos un OpenWithItem
    
  Scenario: Parar de cocinar un microondas Cooking
    Given Cooking
    When Paro de cocinar
    Then Obtenemos un ClosedWithItem
    
   Scenario: Resetear el tiempo de un microondas Cooking
    Given Cooking
    When Reseteo el tiempo
    Then Obtenemos un ClosedWithItem
    
   Scenario: Resetear la potencia de un microondas Cooking
    Given Cooking
    When Reseteo la potencia
    Then Obtenemos un ClosedWithItem

		

		