package pl.coderslab.series;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Series {
    private int id;
    private String title;
    private String type;
    private String description;
    private String lastEp;

}