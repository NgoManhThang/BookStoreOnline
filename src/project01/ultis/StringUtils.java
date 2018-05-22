package project01.ultis;

public class StringUtils {
	public static boolean isNotNullOrEmpty(String inputStr) {
		if(inputStr != null && !inputStr.trim().isEmpty()) {
			return true;
		}
		return false;
	}
}
