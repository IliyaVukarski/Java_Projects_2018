package PersonStreamRead;
/**
 * 
 * @author Iliya Vukarski
 *
 */
public class Address {
	private String country;
	private String city;
	private String postalCode;
	private String municipality;
	private String streetNumber;
	private String streetName;
	private Integer floorNumber;
	private Integer appartmentNumber;
	
	public Address(String country, String city, String postalCode,
			String municipality, String streetNumber, String streetName,
			Integer floorNumber, Integer appartmentNumber) {
		super();
		this.country = country;
		this.city = city;
		this.postalCode = postalCode;
		this.municipality = municipality;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.floorNumber = floorNumber;
		this.appartmentNumber = appartmentNumber;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public Integer getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(Integer floorNumber) {
		this.floorNumber = floorNumber;
	}

	public Integer getAppartmentNumber() {
		return appartmentNumber;
	}

	public void setAppartmentNumber(Integer appartmentNumber) {
		this.appartmentNumber = appartmentNumber;
	}
}
