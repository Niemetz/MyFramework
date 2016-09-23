Feature: Bring up browser and go to the application site

  Scenario: user is able to naviage to application website
    Given "Admin" user has a "Firefox" browser open.
    When he navigates to "amazon" website.
    Then he lands on the "home" page.
