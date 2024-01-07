@Test
Feature: capstone Project

  Scenario: Verify elements on the-internet.herokuapp.com
  
    Given I launch the URL "http://the-internet.herokuapp.com/"
    Then the title of the page should be "The Internet"

    When I click on the link "A/B Testing"
    Then the text on the page should be "A/B Test Variation 1"

    And I navigate back to the Home page
    When I click on the link "Dropdown"
    And I select "Option 1" from the dropdown
    Then "Option 1" should be selected

    And I navigate back to the Home page
    When I click on the link "Frames"
    Then the link "Nested Frames" should be presented
    And the link "iFrame" should be presented
