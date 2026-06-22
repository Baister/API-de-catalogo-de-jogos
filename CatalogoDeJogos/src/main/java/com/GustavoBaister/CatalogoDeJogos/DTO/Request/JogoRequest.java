package com.GustavoBaister.CatalogoDeJogos.DTO.Request;


public record JogoRequest(
        String titulo,
        String desenvolvedora,
        Integer anoLancamento,
        Double preco
) {
}
