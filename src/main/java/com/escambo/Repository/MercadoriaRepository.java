package com.escambo.Repository;

import com.escambo.Entity.Mercadoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MercadoriaRepository extends JpaRepository<Mercadoria, Long> {
}
