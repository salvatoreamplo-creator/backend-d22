package salvoamplo.esercizi.payload;

import java.util.UUID;

public record BlogPostPayload(
        String titolo,
        String contenuto,
        int tempoDiLettura,
        UUID authorId
) {
}
