package io.github.harishvelmurugan14.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel {
    @ManyToOne
    private Screen screen;
    @ManyToOne
    private Movie movie;
    private LocalDateTime showTime;
}
