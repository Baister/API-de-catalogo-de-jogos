package com.GustavoBaister.CatalogoDeJogos.DTO.Response;

public record JogoResponse(
        Long id,
        String titulo,
        Integer anoLancamento,
        String desenvolvedora,
        Double preco
) {
}
