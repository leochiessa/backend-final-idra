package backend.services;

import backend.models.Car;
import backend.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Service
public class CarService {

    private final CarRepository cr;

    @Autowired
    public CarService(CarRepository cr) {
        this.cr = cr;
    }

    public ResponseEntity<List<Car>> getAll() {
        try {
            return ResponseEntity.status(OK).body(cr.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity addCar(Car c) {
        try {
            cr.save(c);
            return ResponseEntity.status(CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity updateCar(String plate, Car c) {
        try {
            Car ca = cr.findById(plate).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Car not found!"));
            ca.setBrand(c.getBrand());
            ca.setModel(c.getModel());
            ca.setYear(c.getYear());
            ca.setColor(c.getColor());
            ca.setDoors(c.getDoors());
            cr.save(ca);
            return ResponseEntity.status(OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity deleteCar(String plate) {
        try {
            cr.deleteById(plate);
            return ResponseEntity.status(OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }
}