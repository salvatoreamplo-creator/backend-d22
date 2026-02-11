package salvoamplo.esercizi.payload;

public record AuthorPayload(
        String nome,
        String cognome,
        String email
) {
}
