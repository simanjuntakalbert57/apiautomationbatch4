package api.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseAddBooks {
     @JsonProperty("books")
     public IsbnBook[] isbn;

     public static class IsbnBook {
         @JsonProperty("isbn")
         public String isbn;
     }
}
