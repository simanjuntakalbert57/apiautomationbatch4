package api.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestAddBooks {

    @JsonProperty("userId")
    public String userId;

    @JsonProperty("collectionOfIsbns")
    public CollectionOfIsbn[] collectionOfIsbns;

    public static class CollectionOfIsbn {
        @JsonProperty("isbn")
        public String isbn;
    }
}
