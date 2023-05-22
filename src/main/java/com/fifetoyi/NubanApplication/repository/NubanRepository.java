package com.fifetoyi.NubanApplication.repository;

import com.fifetoyi.NubanApplication.model.Nuban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NubanRepository extends JpaRepository<Nuban, Long> {
}
