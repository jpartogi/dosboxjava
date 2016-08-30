package dosbox;

import dosbox.configuration.Configurator;

public class Program {
	public static void main(String[] args) {
		Configurator config = new Configurator();
		config.orchestrateSystem();
	}
}