package com.fifetoyi.nuban.repository;

import com.fifetoyi.nuban.model.Nuban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NubanRepository extends JpaRepository<Nuban, Long> {
}
