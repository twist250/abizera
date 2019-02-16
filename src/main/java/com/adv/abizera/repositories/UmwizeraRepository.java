package com.adv.abizera.repositories;

import com.adv.abizera.domain.Gender;
import com.adv.abizera.domain.Umwizera;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UmwizeraRepository extends GenericRepository<Umwizera> {
    List<Umwizera> findAllByFirstNameContaining(String firstName);

    List<Umwizera> findAllByLastNameContaining(String lastName);

    Umwizera findByNationalId(long nationalId);

    List<Umwizera> findAllByGender(Gender gender);
}
