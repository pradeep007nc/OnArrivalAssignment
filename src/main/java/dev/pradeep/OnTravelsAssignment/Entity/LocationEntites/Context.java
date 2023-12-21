package dev.pradeep.OnTravelsAssignment.Entity.LocationEntites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Context {
    private String id;
    private String mapboxId;
    private String text;
    private String wikidata;
    private String shortCode;

    // Getters and setters (omitting for brevity)
}
