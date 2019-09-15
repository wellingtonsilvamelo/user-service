package com.wellington.applications;

public class DataMock {
	
	/*public static final Long PERSON_ID = 1L;
	public static final String PERSON_NAME = "Sauron";
	
	public static final Long ADDRESS_ID = 1L;
	public static final String ADDRESS_STREET = "Rua Osvaldo Cruz";
	public static final Integer ADDRESS_NUMBER = 80;
	public static final String ADDRESS_NEIGHBORHOOD = "Sertãozinho";
	public static final String ADDRESS_CITY = "Nazaré da Mata";
	public static final String ADDRESS_STATE = "PE";
	
	public static final Long PHONE_ID = 1L;
	public static final String PHONE_NUMBER = "81989886767";
	public static final String PHONE_TYPE = "CELLPHONE";
	
	public static Person buildPersonToInsert() {		
		
		Address address = new Address(ADDRESS_STREET, ADDRESS_NUMBER, ADDRESS_NEIGHBORHOOD, ADDRESS_CITY, ADDRESS_STATE);
		
		Person person = getPerson();
		person.setAddress(address);
		
		return person;
				
	}
	
	public static Person buildPersonToReturn() {		
		
		Address address = new Address(ADDRESS_ID, ADDRESS_STREET, ADDRESS_NUMBER, ADDRESS_NEIGHBORHOOD, ADDRESS_CITY, ADDRESS_STATE);
		
		Person person = getPerson();
		person.setId(PERSON_ID);
		person.setAddress(address);
		
		return person;
				
	}
	
	public static Person getPerson() {
		return PersonBuilder.create()
				.name(PERSON_NAME)
				.build();		
	}

	public static List<Phone> buildPhonenToInsert() {
		List<Phone> phones = new ArrayList<>();
		phones.add(new Phone(PHONE_NUMBER, PHONE_TYPE, buildPersonToReturn()));
		return phones;
	}*/

}
