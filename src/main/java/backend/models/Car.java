package backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {
    @Id
    private String plate;
    @NotNull
    private String brand;
    @NotNull
    private String model;
    @NotNull
    private Integer year;
    @NotNull
    private String color;
    @NotNull
    private Integer doors;
}