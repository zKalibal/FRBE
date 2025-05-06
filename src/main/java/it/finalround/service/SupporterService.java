package it.finalround.service;

import it.finalround.entity.PatreonSupporter;
import it.finalround.repository.PatreonSupporterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupporterService {

    private final PatreonSupporterRepository repo;

    public List<PatreonSupporter> listAll(){
        return repo.findAll();
    }

    public List<PatreonSupporter> top(){
        return repo.findTop10ByPatronStatusOrderByLifetimeSupportCentsDesc("active_patron");
    }

    public PatreonSupporter save(PatreonSupporter s){
        return repo.save(s);
    }
}
