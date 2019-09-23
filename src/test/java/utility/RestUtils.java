package utility;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

	public static String getFirstName() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return ("John" + generatedString);
	}

	public static String getLastName() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return ("Kennedy" + generatedString);
	}

	public static String getUserName() {
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		return ("John" + generatedString);
	}

	public static String getPassword() {
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		return ("John" + generatedString);
	}

	public static String getEmail() {
		String generatedString = RandomStringUtils.randomAlphabetic(7);
		return (generatedString + "@gmail.com");
	}

	public static String empName() {
		String generatedString = RandomStringUtils.randomAlphabetic(2);
		return ("John" + generatedString);
	}

	public static String empSal() {
		String randomSal = RandomStringUtils.randomNumeric(5);
		return randomSal;
	}

	public static String empAge() {
		String randomAge = RandomStringUtils.randomNumeric(2);
		return randomAge;
	}
}
