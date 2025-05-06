package it.finalround.repository;

import it.finalround.entity.PatreonSupporter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatreonSupporterRepository extends JpaRepository<PatreonSupporter, String> {
    List<PatreonSupporter> findTop10ByPatronStatusOrderByLifetimeSupportCentsDesc(String patronStatus);
}
