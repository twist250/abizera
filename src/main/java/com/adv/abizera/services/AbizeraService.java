package com.adv.abizera.services;

import com.adv.abizera.domain.Child;
import com.adv.abizera.domain.Deceased;
import com.adv.abizera.domain.Umwizera;
import com.adv.abizera.repositories.GenericRepository;
import com.adv.abizera.repositories.OtherRepository;
import com.adv.abizera.repositories.UmwizeraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbizeraService {
    private final UmwizeraRepository umwizeraRepository;
    private final OtherRepository otherRepository;
    private final GenericRepository genericRepository;

    @Autowired
    public AbizeraService(UmwizeraRepository umwizeraRepository, OtherRepository otherRepository, GenericRepository genericRepository) {
        this.umwizeraRepository = umwizeraRepository;
        this.otherRepository = otherRepository;
        this.genericRepository = genericRepository;
    }

    public Umwizera saveUmwizera(Umwizera umwizera) {
        return umwizeraRepository.save(umwizera);
    }

    public List<Umwizera> getAbizera() {
        return umwizeraRepository.findAll();
    }

    public List<Umwizera> findUmwizeraByFirstName(String firstName) {
        return umwizeraRepository.findAllByFirstNameContaining(firstName);
    }

    public List<Umwizera> findUmwizeraByLastName(String lastName) {
        return umwizeraRepository.findAllByFirstNameContaining(lastName);
    }

    public Child saveChild(Child child) {
        return (Child) genericRepository.save(child);
    }

//    public List<Deceased> getAllDeceased() {
//        genericRepository.
//    }

    //TODO For next time
}
