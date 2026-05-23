package Classes;

import java.util.Iterator;

public class Player {
    private Playlist playlist;

    public Player(Playlist playlist) {
        this.playlist = playlist;
    }

    public int getTotalMusicas() {
        int total = 0;
        Iterator<Musica> it = playlist.iterator();
        while (it.hasNext()) {
            it.next();
            total++;
        }
        return total;
    }

    public void exibirPlaylist() {
        Iterator<Musica> it = playlist.iterator();
        int faixa = 1;
        while (it.hasNext()) {
            Musica m = it.next();
            System.out.println(faixa + ". " + m.getTitulo()
                    + " — " + m.getArtista());
            faixa++;
        }
    }
}