package org.turkcellBootCamp;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        CorporateCustomer corporateCustomer1 = new CorporateCustomer(1, "kodlamaio","12345678912");

        IndividualCustomer individualCustomer1 = new IndividualCustomer(2, "songül", "acikgoz", "11122233345");
        IndividualCustomer individualCustomer2 = new IndividualCustomer();
        individualCustomer2.setFirstName("berfin");
        individualCustomer2.setLastName("acikgoz");
        individualCustomer2.setNationalityId("11111111110");
        individualCustomer2.setId(1);

        Hotel hotel = new Hotel(1, "Hilton");

        Booking booking1 = new Booking();
        booking1.setId(1);
        booking1.setStartDate(new Date());
        booking1.setEndDate(new Date());
        booking1.setDailyPrice(3000);
        booking1.setCustomer(individualCustomer2);
        booking1.setHotel(hotel);

    }
}