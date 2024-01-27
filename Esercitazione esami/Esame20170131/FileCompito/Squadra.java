public class Squadra extends Archivio {
    private static final int MAX_PLAYERS = 18;
    private int availableBudget = 300;

    public void inserisci(String nome, int prezzo) {
        if (nome == null) return;
        if (super.taglia() == MAX_PLAYERS) return;
        if (soldi() < prezzo) return;
        super.inserisci(nome, prezzo);
        availableBudget -= prezzo;
    }

    public Coppia cancella (String nome) {
        if (nome == null) return null;
        Coppia removedPlayer = super.cancella(nome);
        if (removedPlayer == null) return null;
        availableBudget += removedPlayer.getAttributo();
        return removedPlayer;
    }

    public int soldi () {
        return availableBudget;
    }
}