package Cavallo.TonnoAlBurro.entities;

import jakarta.persistence.*;
import lombok.*;

// stiamo construendo una progetto per gestire dei minchia di pesci
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pesce {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private boolean isDisponibile;
    private int prezzoPerKg;

    @Enumerated(EnumType.STRING)
    private Dimensione dimensione;

    @Enumerated(EnumType.STRING)
    private Specie specie;

    // stiamo mettendo degli enum perchè ci piace incasinarci la vita
}
