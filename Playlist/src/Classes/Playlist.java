package Classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Playlist implements Iterable<Musica> {
    private List<Musica> musicas = new ArrayList<>();

    public void addMusica(Musica musica) {
        musicas.add(musica);
    }

    @Override
    public Iterator<Musica> iterator() {
        return musicas.iterator();
    }
}