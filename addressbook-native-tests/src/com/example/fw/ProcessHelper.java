package com.example.fw;

import java.io.IOException;

public class ProcessHelper extends HelperBase {

	private Process process;

	public ProcessHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void startAppUnderTest() throws IOException {
		String command = manager.getProperty("app.path");
		process = Runtime.getRuntime().exec(command);
	}

	public void stopAppUnderTest() {
		process.destroy();
	}

	public int getTimeout() {
		String timeoutProperty = manager.getProperty("timeout");
		int timeout;
		if (timeoutProperty != null) {
			timeout = Integer.parseInt(timeoutProperty);
		} else {
			timeout = 5000;
		}

		return timeout;
	}

//	public void closeApplication() {
//		manager.getAutoItHelper().click("Exit");
//	}

}
