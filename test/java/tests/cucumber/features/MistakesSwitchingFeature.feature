Feature: Change Settings
  As a User
  I want to change Settings

  Background: User is on Play Page

  @ChangeMistakesLimit
  Scenario Outline: Set Mistakes limit OFF
    Given User navigates to Settings
    And Mistakes Limit is ON
    When He clicks on Limit switcher
    Then Mistakes Limit changes to OFF
    And Auto-Check For Mistakes changes to OFF
    Then He clicks on Limit switcher
    And Notification message <message> is displayed

    Examples:
      | message                                  |
      | Changes will be applied in the next game |
