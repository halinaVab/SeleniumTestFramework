package data;

import java.io.File;

public class ContactUsFormData {

	private String subjectHeading;
	private String email;
	private String message;
	private String orderReference;
	private static String filePath = System.getProperty("user.dir") + File.separator + "ContactUsData.txt";

	public ContactUsFormData() {
		String data = FileUtils.readDataFromFile(filePath);
		String[] arr = data.split(",");
		subjectHeading = arr[0];
		email = arr[1];
		orderReference = arr[2];
		message = arr[3];
	}

	public String getSubjectHeading() {
		return subjectHeading;
	}

	public void setSubjectHeading(String subjectHeading) {
		this.subjectHeading = subjectHeading;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOrderReference() {
		return orderReference;
	}

	public void setOrderReference(String orderReference) {
		this.orderReference = orderReference;
	}

}
