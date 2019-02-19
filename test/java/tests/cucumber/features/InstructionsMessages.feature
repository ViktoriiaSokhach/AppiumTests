Feature:Instructions Messages
  As a User
  I want to read Instructions

  Scenario Outline: Read the Instructions Messages
  Given User is on Instructions first Page
  When He navigates to Instructions second Page
  Then Instruction First message <message1> is displayed
  Then User navigates to Instructions third Page
  And Instruction Second message <message2> is displayed

  Examples:
  | message1                                              | message2                                     |
  | Select a cell, then tap a number to fill in the cell. | Make notes to keep track of possible numbers |