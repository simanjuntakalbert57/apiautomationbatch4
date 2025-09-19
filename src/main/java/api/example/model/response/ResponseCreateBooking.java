package api.example.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseCreateBooking {
    /*
     * {
    "bookingid": 1,
    "booking": {
        "firstname": "Jim",
        "lastname": "Brown",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01",
                    "Address" : {
                    "street": "Jalan Merdeka",
                    "city": "Jakarta"
                }
        },
        "additionalneeds": "Breakfast"
        "Address" : {
            "street": "Jalan Merdeka",
            "city": "Jakarta",
        }
    }
}
     */

     @JsonProperty("bookingid")
     public int bookingid;

     @JsonProperty("booking")
     public Booking booking;

     public static class Booking {
         @JsonProperty("firstname")
         public String firstname;

         @JsonProperty("lastname")
         public String lastname;

         @JsonProperty("totalprice")
         public int totalprice;

         @JsonProperty("depositpaid")
         public boolean depositpaid;

         @JsonProperty("additionalneeds")
         public String additionalneeds;

         @JsonProperty("bookingdates")
         public BookingDates bookingdates;
     }

     public static class BookingDates {
         @JsonProperty("checkin")
         public String checkin;

         @JsonProperty("checkout")
         public String checkout;

         @JsonProperty("Address")
         public Address address;
     }

     public static class Address {
         @JsonProperty("street")
         public String street;

         @JsonProperty("city")
         public String city;
     }

}
