package com.data.reactive.data.repository;

import com.data.reactive.data.NothingEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface NothingRepository extends ReactiveCrudRepository<NothingEntity, Long> {
}
