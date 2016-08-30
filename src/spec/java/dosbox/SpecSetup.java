package dosbox;

import dosbox.command.framework.TestOutput;
import dosbox.filesystem.Directory;
import dosbox.filesystem.Drive;
import dosbox.filesystem.File;
import dosbox.interfaces.IDrive;
import dosbox.invoker.CommandInvoker;

public abstract class SpecSetup {
	protected CommandInvoker commandInvoker;
	protected TestOutput testOutput;
	protected IDrive drive;
	protected Directory rootDir;
	protected File fileInRoot1;
	protected File fileInRoot2;
	protected Directory subDir1;
	protected File file1InDir1;
	protected File file2InDir1;
	protected Directory subDir2;
	protected int numbersOfDirectoriesBeforeTest;
	protected int numbersOfFilesBeforeTest;
	
	protected void createTestFileStructure() {
		this.drive = new Drive("C");
		this.rootDir = this.drive.getRootDirectory();
		this.fileInRoot1 = new File("FileInRoot1", "an entry");
		this.rootDir.add(this.fileInRoot1);
		this.fileInRoot2 = new File("FileInRoot2", "a long entry in a file");
		this.rootDir.add(this.fileInRoot2);
		
		this.subDir1 = new Directory("subDir1");
		this.rootDir.add(subDir1);
		this.file1InDir1 = new File("File1InDir1", "");
		this.subDir1.add(this.file1InDir1);
		this.file2InDir1 = new File("File2InDir1", "");
		this.subDir1.add(this.file2InDir1);
		
		this.subDir2 = new Directory("subDir2");
		this.rootDir.add(subDir2);
		
		this.commandInvoker = new CommandInvoker();
		this.testOutput = new TestOutput();
		
		this.numbersOfDirectoriesBeforeTest = this.drive.getRootDirectory().getNumberOfContainedDirectories();
		this.numbersOfFilesBeforeTest = this.drive.getRootDirectory().getNumberOfContainedFiles();
	}
	
	protected void executeCommand(String commandLine) {
		if(this.commandInvoker == null)
			this.commandInvoker = new CommandInvoker();
		this.commandInvoker.executeCommand(commandLine, this.testOutput);
	}
}
