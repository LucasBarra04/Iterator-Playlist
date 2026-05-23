package Classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlaylistIteratorTest {

    private Playlist playlist;
    private Player player;

    @BeforeEach
    void setUp() {
        playlist = new Playlist();

        Musica musica1 = new Musica();
        musica1.setTitulo("Numb");
        musica1.setArtista("Linkin Park");

        Musica musica2 = new Musica();
        musica2.setTitulo("Payphone");
        musica2.setArtista("Marron 5");

        Musica musica3 = new Musica();
        musica3.setTitulo("B.Y.O.B.");
        musica3.setArtista("System Of A Down");

        playlist.addMusica(musica1);
        playlist.addMusica(musica2);
        playlist.addMusica(musica3);

        player = new Player(playlist);
    }

    @Test
    void totalMusicasDeveRetornarQuantidadeCorreta() {
        assertEquals(3, player.getTotalMusicas());
    }

    @Test
    void playlistVaziaDeveTerTotalZero() {
        Player playerVazio = new Player(new Playlist());
        assertEquals(0, playerVazio.getTotalMusicas());
    }

    @Test
    void iteratorDevePercorrerTodasAsMusicas() {
        int count = 0;
        for (Musica m : playlist) {
            count++;
        }
        assertEquals(3, count);
    }

    @Test
    void iteratorDeveRetornarMusicasNaOrdemDeInsercao() {
        var it = playlist.iterator();
        assertEquals("Numb", it.next().getTitulo());
        assertEquals("Payphone",  it.next().getTitulo());
        assertEquals("B.Y.O.B.", it.next().getTitulo());
    }

    @Test
    void hasNextDeveFalsoQuandoPlaylistVazia() {
        assertFalse(new Playlist().iterator().hasNext());
    }

    @Test
    void hasNextDeveTrueQuandoHaMusicas() {
        assertTrue(playlist.iterator().hasNext());
    }

    @Test
    void exibirPlaylistNaoDeveLancarExcecao() {
        assertDoesNotThrow(() -> player.exibirPlaylist());
    }

    @Test
    void adicionarMusicaDeveAumentarTotal() {
        Musica nova = new Musica();
        nova.setTitulo("Livin' On A Prayer");
        nova.setArtista("Bon Jovi");
        playlist.addMusica(nova);
        assertEquals(4, player.getTotalMusicas());
    }
}