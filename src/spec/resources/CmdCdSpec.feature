Feature: CmdCdSpec

  Scenario: change directory from root dir
    Given I am currently at "root" directory
    When I change to "subDir1"
    Then it should change to "subDir1"
  	 	