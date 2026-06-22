package com.GustavoBaister.CatalogoDeJogos.DTO.Response;

public record JogoResponse(
        Long id,
        String titulo,
        String desenvolvedora,
        Double preco
) {
}
