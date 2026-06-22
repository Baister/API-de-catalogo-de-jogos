package com.GustavoBaister.CatalogoDeJogos.Repository;

import com.GustavoBaister.CatalogoDeJogos.Model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJogoRepository extends JpaRepository<Jogo, Long> {
}
