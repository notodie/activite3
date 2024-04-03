package ma.emsi.activite3;

import ma.emsi.activite3.entities.Patient;
import ma.emsi.activite3.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HospitalApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Patient patient = new Patient();
        patient.setId(null);
        patient.setNom("Mohamed");
        patient.setDateNaissance(new Date());
        patient.setMalade(false);
        patient.setScore(23);

        Patient patient2 = new Patient(null, "Yassine", new Date(), false, 123);

        Patient patient3 = Patient.builder()
                .nom("Imane")
                .dateNaissance(new Date())
                .score(56)
                .malade(true)
                .build();
        patientRepository.save(new Patient(null, "Yassine", new Date(), false, 123));
        patientRepository.save(new Patient(null, "Hanane", new Date(), true, 321));
        patientRepository.save(new Patient(null, "Imane", new Date(), false, 456));
    }
}
