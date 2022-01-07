Feature: LabCorp

  Scenario: Search a job
    Given I navigate to LabCorp
    And I go to "Careers"
    When I search "QA Software Analyst" job
    Then I should see "QA Software Analyst" job title
    And I should see "Burlington, North Carolina" job location
    And I should see "21-97375" job id
    And The job description sentence number 1 should be
    """
    Responsible for identifying, planning, and executing testing activities in an Agile/Scrum environment to ensure high quality software and compliance according to regulatory statutes, policies, and procedures
    """
    And The job description bullet number 2 should be "Test Web Services"
    And The job requirements number 3 should be "Selenium Webdriver LoadRunner scripting"
    And I click Apply button
    Then I should see "QA Software Analyst" job title on Apply page
    And I should see "Burlington, NC" job location on Apply page
    And I should see "#21-97375" job id on Apply page
    And The job description sentence number 1 on Apply page should be
    """
    Responsible for identifying, planning, and executing testing activities in an Agile/Scrum environment to ensure high quality software and compliance according to regulatory statutes, policies, and procedures
    """
    And The job description bullet number 2 on Apply page should be "Test Web Services"
    And The job requirements number 3 on Apply page should be "Selenium Webdriver LoadRunner scripting"
    And I click Return To Job search button

