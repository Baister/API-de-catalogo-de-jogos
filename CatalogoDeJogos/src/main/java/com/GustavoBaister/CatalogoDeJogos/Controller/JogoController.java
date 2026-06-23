package com.GustavoBaister.CatalogoDeJogos.Controller;


import com.GustavoBaister.CatalogoDeJogos.DTO.Request.JogoRequest;
import com.GustavoBaister.CatalogoDeJogos.DTO.Response.JogoResponse;
import com.GustavoBaister.CatalogoDeJogos.Service.JogoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Jogo", description = "Endpoints para gerenciamento de jogos")
@CrossOrigin("*")
@RequestMapping("/api/jogos")
@RestController
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @GetMapping("/{id}")
    @Operation(summary = "Buscar jogo", description = "Ele busca o jogo conforme o id")
    public ResponseEntity<JogoResponse> buscarPorId(@PathVariable Long id){
        return new ResponseEntity<>(jogoService.buscarPorId(id), HttpStatus.OK);
    }

    @GetMapping
    @Operation(summary = "Listar jogos", description = "Ele retorna a lista de jogos que há no banco")
    public ResponseEntity<List<JogoResponse>> listarJogos(){
        //return new ResponseEntity<>(jogoService.listarJogos(), HttpStatus.OK);
        List<JogoResponse> jogos = jogoService.listarJogos();

        if(jogos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(jogos, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Cadastrar jogo", description = "É possível cadastrar o jogo")
    public ResponseEntity<JogoResponse> criarJogo(@RequestBody JogoRequest request){
        return new ResponseEntity<>(jogoService.cadastrarJogo(request), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar jogo", description = "Atualiza os dados de um jogo")
    public ResponseEntity<JogoResponse> atualizarJogo(@PathVariable Long id, @RequestBody JogoRequest request){
        return new ResponseEntity<>(jogoService.atualizarJogo(id, request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar jogo", description = "Deletar o cadastro de um jogo")
    public ResponseEntity<JogoResponse> deletarJogo(@PathVariable Long id){
        jogoService.deletar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
