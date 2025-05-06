package it.finalround.repository;

import it.finalround.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
    List<Channel> findByIdIn(List<Long> ids);
}
