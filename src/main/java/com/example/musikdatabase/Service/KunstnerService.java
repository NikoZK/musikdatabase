package com.example.musikdatabase.Service;

import com.example.musikdatabase.Model.Kunstner;
import com.example.musikdatabase.Repository.KunstnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KunstnerService {
    @Autowired
    private KunstnerRepo kunstnerRepo;

    public List<Kunstner> fetchAll() {
        return kunstnerRepo.fetchAll();
    }

    public void addKunstner(Kunstner kunstner) {
        kunstnerRepo.addKunstner(kunstner);
    }
}
