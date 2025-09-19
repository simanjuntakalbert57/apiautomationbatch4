package api.example.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestAddBooks {
    @JsonProperty("userId")
    public String userId;

    @JsonProperty("collectionOfIsbns")
    public Isbn[] collectionOfIsbns;

    public static class Isbn {
        @JsonProperty("isbn")
        public String isbn;
    }
}
