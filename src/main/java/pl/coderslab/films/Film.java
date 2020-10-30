package pl.coderslab.films;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Film {
    private int id;
    private String title;
    private int year;
    private String type;
    private String description;

}
