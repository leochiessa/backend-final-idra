package backend.controller;

import backend.models.Car;
import backend.services.CarService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
@CrossOrigin(origins = "*")
public class CarController {

    @Autowired
    private CarService cs;

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll() {
        return cs.getAll();
    }

    @PostMapping("")
    public ResponseEntity addCar(@RequestBody final @NotNull Car c) {
        return cs.addCar(c);
    }

    @PostMapping("/{plate}/update")
    public ResponseEntity updateCar(@PathVariable final @NotNull String plate, @RequestBody final @NotNull Car c) {
        return cs.updateCar(plate, c);
    }

    @PostMapping("/{plate}/delete")
    public ResponseEntity deleteCar(@PathVariable final @NotNull String plate) {
        return cs.deleteCar(plate);
    }
}