package files;

public class Payload {
	public static String credentials() {
		return "{\n"
				+ "    \"username\": \"sachindua99\",\n"
				+ "    \"password\": \"Sachin.dua90\"\n"
				+ "}";
	}
	
	public static String addCommentDetails() {
		return "{\n"
				+ "    \"body\": \"Please review it\",\n"
				+ "    \"visibility\": {\n"
				+ "        \"type\": \"role\",\n"
				+ "        \"value\": \"Administrators\"\n"
				+ "    }\n"
				+ "}";
	}

}
