package com.GustavoBaister.CatalogoDeJogos.Service;

import com.GustavoBaister.CatalogoDeJogos.DTO.Request.JogoRequest;
import com.GustavoBaister.CatalogoDeJogos.DTO.Response.JogoResponse;
import com.GustavoBaister.CatalogoDeJogos.Model.Jogo;
import com.GustavoBaister.CatalogoDeJogos.Repository.IJogoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {

    @Autowired
    private IJogoRepository jogoRepository;

    private JogoResponse toResponse(Jogo jogo){
        return new JogoResponse(
                jogo.getId(),
                jogo.getTitulo(),
                jogo.getAnoLancamento(),
                jogo.getDesenvolvedora(),
                jogo.getPreco()
        );
    }

    public List<JogoResponse> listarJogos(){
        return jogoRepository.findAll().stream().map(this::toResponse).toList();
    }

    public JogoResponse buscarPorId(Long id){
        Jogo jogo = jogoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado"));
        return toResponse(jogo);
    }

    public JogoResponse cadastrarJogo(JogoRequest request){
        Jogo jogo = new Jogo();
        jogo.setTitulo(request.titulo());
        jogo.setPreco(request.preco());
        jogo.setDesenvolvedora(request.desenvolvedora());
        jogo.setAnoLancamento(request.anoLancamento());

        return toResponse(jogoRepository.save(jogo));
    }

    public JogoResponse atualizarJogo(Long id, JogoRequest request){
        Jogo jogo = jogoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado com id: " + id));
        jogo.setTitulo(request.titulo());
        jogo.setDesenvolvedora(request.desenvolvedora());
        jogo.setPreco(request.preco());
        jogo.setAnoLancamento(request.anoLancamento());

        return toResponse(jogoRepository.save(jogo));
    }

    public void deletar(Long id){
        Jogo jogo = jogoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado com id:" + id));
        jogoRepository.delete(jogo);
    }
}
