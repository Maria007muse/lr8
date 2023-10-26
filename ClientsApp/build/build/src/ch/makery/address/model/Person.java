package ch.makery.address.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 * Класс-модель для адресата (Person).
 *
 * @author Marco Jakob
 */
public class Person {

	private final StringProperty firstName;
	private final StringProperty lastName;
	private final StringProperty email;
	private final IntegerProperty phone_number;
	private final StringProperty status;
	private final StringProperty kind_client;

	/**
	 * Конструктор по умолчанию.
	 */
	public Person() {
		this(null, null);
	}
	
	/**
	 * Конструктор с некоторыми начальными данными.
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public Person(String firstName, String lastName) {
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		
		// Какие-то фиктивные начальные данные для удобства тестирования.
		this.email = new SimpleStringProperty("эмейл");
		this.phone_number = new SimpleIntegerProperty(1234);
		this.status = new SimpleStringProperty("статус клиента");
		this.kind_client = new SimpleStringProperty("тип клиента");
	}
	
	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}
	
	public StringProperty firstNameProperty() {
		return firstName;
	}

	public String getLastName() {
		return lastName.get();
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}
	
	public StringProperty lastNameProperty() {
		return lastName;
	}

	public String getEmail() {
		return email.get();
	}

	public void setEmail(String mail) {
		this.email.set(mail);
	}
	
	public StringProperty emailProperty() {
		return email;
	}

	public int getPhone() {
		return phone_number.get();
	}

	public void setPhone(int phone) {
		this.phone_number.set(phone);
	}
	
	public IntegerProperty phoneProperty() {
		return phone_number;
	}

	public String getStatus() {
		return status.get();
	}

	public void setStatus(String city) {
		this.status.set(city);
	}
	
	public StringProperty statusProperty() {
		return status;
	}

	public String getType() {
		return kind_client.get();
	}

	public void setType(String type)  {
		this.kind_client.set(type);
	}
	
	public StringProperty typeProperty()  {
		return kind_client;
	}
}
