Feature: Home Insurance

  Scenario: Home Insurance1
    Given I am on home-insurance page
    And I enter the following details about me
      | DOB   | 5-5-1980 |
      | Marital Status | Single |
      | Occupation     | Accountant |
      | Smoker         | No         |
#    And I agree with statements about me
#    And I enter the following property details
#    And I agree with statements about property
    And I select "No" for safety and security options
    And I "do not choose" to add a joint policy holder
    And I select following options for insurance history
      | Years Insurance Held | 5 years |
      | Claims Made          | No      |
    And I select "Buildings only" cover with following options
      | Start Date       | Today  |
      | Property Value   | 200000 |
      | Rebuild Cost     | 100000 |
      | Accidental Cover | Yes    |
      | Standard Excess  | 500    |

