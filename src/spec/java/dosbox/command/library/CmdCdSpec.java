package dosbox.command.library;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dosbox.SpecSetup;
import dosbox.helpers.TestHelper;

public class CmdCdSpec extends SpecSetup {
	@Before
	public void setUp(){
		super.createTestFileStructure();
		commandInvoker.addCommand(new CmdCd("cd", drive));
	}

	
	@Given("^I am currently at \"(.*?)\" directory$")
	public void i_am_currently_at_directory(String dirName) throws Throwable {
		drive.changeCurrentDirectory(rootDir);
	}

	@When("^I change to \"(.*?)\"$")
	public void i_change_to(String dirName) throws Throwable {
		executeCommand("cd " + subDir1.getPath());
	}

	@Then("^it should change to \"(.*?)\"$")
	public void it_should_change_to(String dirName) throws Throwable {
		TestHelper.assertOutputIsEmpty(testOutput);
        TestHelper.assertCurrentDirectoryIs(drive, subDir1);
	}
	
}
