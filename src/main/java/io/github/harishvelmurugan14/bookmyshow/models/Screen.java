package io.github.harishvelmurugan14.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Screen extends BaseModel{
    private int number;
    @ManyToOne
    private Theatre theatre;
    @OneToMany(mappedBy = "screen")
    private List<Seat> seats;
}
