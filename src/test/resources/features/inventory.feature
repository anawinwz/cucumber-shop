Feature: Track inventory
    As an owner
    I want to keep track of inventory

Background:
    Given a product Bread with price 20.50 and quantity 2 exists
    And a product Jam with price 80.00 and quantity 2 exists

Scenario: Buy then inventory is empty
    When a customer buy Bread with quantity 2
    Then quantity of Bread should be 0

Scenario: Buy then inventory is not empty
    When a customer buy Bread with quantity 2
    And a customer buy Jam with quantity 1
    Then quantity of Bread should be 0
    And quantity of Jam should be 1


