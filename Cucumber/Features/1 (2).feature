Feature: Orange HRM

	#|Verify the successful log in of orange hrm application--providing multiple valid user id's and passwords|
	@OH-4 @OH-3
	Scenario Outline: Verify the successful log in of orange hrm application--providing multiple valid user id's and passwords
		Login button with valid user id and password
		    Given user navigates to the url
		    When user enters valid "<username>"  and "<password>"
		    Then home page disapleyd
		
		    Examples: 
		      | username   | password |
		      | qaplanet1 | lab1 |
			

	#|Verify the log in functionality with invalid user and password|
	@OH-6 @OH-3
	Scenario Outline: Verify the log in functionality with invalid user and password
		Scenario Outline: Verify the log in functionality with invalid user and password
		    Given user navigates to the url
		    When user enters invalid "<username>"  and "<password>"
		    Then user should get an error message "Invalid Login"
		    Examples: 
		    | username | password |
		      | testuser_1 | lab1 |
		      	

	#|Verify the log in functionality with not providing valid user and password|
	@OH-7 @OH-3
	Scenario Outline: Verify the log in functionality with not providing valid user and password
		Scenario Outline: Login button with not giving  user id and password
		    Given user navigates to the url
		    When user  passes blank value in  "<username>"  and "<password>"
		    Then user should get an alert message 
		     Examples: 
		    | username | password |
		      |  |  |	

	#|Verify the functionality of clear button on the log in page|
	@OH-8 @OH-3
	Scenario Outline: Verify the functionality of clear button on the log in page
		 Given user navigates to the url
		    When user enters invalid "<username>"  and "<password>"
		    When user click on clear button 
		   Then user name and password fields should reset to blank 
		
		    Examples: 
		    | username | password |
		    | testuser_1 | lab1 |	

	#|verfiy the functionlity of Change password after logging into the applciation|
	@OH-9 @OH-3
	Scenario Outline: verfiy the functionlity of Change password after logging into the applciation
		Given user navigates to the url
		    When user enters valid "<username>"  and "<password>"
		    Then home page disapleyd
		    When user click on the link Change password 
		    Then user should get a change password window 
		
		    Examples: 
		      | username   | password |
		      | qaplanet1 | lab1 |	

	#|verify the Logout functionality of the application|
	@OH-10 @OH-3
	Scenario Outline: verify the Logout functionality of the application
		Given user navigates to the url
		    When user enters valid "<username>"  and "<password>"
		    Then home page disapleyd
		    When user click on the logout link  
		    Then user should log out fron the applciation successfully
		
		    Examples: 
		      | username   | password |
		      | qaplanet1 | lab1 |