import org.example.Door;
import org.example.Game;
import org.example.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Тест кейс для тестирования методов порадокса
 */
public class Tests {

    static List<Door> doors;

    @BeforeEach
    void initDoors() {
        doors = new ArrayList<>();
        doors.add(new Door(true));
        doors.add(new Door(false));
        doors.add(new Door(false));
    }

    @Test
    void checkNotRiskWin() {
        //given
        Player player = new Player("Ваня", false);
        Game game = new Game(player, doors);
        //when
        Door door = game.round(0);
        //then
        Assertions.assertTrue(door.isPrize());
    }

    @Test
    void checkNotRiskLose() {
        //given
        Player player = new Player("Петр", false);
        Game game = new Game(player, doors);
        //when
        Door door = game.round(1);
        //then
        Assertions.assertFalse(door.isPrize());
    }

    @Test
    void checkRiskWin() {
        //given
        Player player = new Player("Лена", true);
        Game game = new Game(player, doors);
        //when
        Door door = game.round(1);
        //then
        Assertions.assertTrue(door.isPrize());
    }

    @Test
    void checkRiskLose() {
        //given
        Player player = new Player("Ира", true);
        Game game = new Game(player, doors);
        //when
        Door door = game.round(0);
        //then
        Assertions.assertFalse(door.isPrize());
    }
    @Test
    void checkNotSameObject() {
        //given
        Player player = new Player("Игрок", true);
        Game game = new Game(player, doors);
        //when
        Door door = game.round(1);
        //then
        Assertions.assertNotSame(player, game);
    }

    @Test
    void checkSameObject() {
        //given
        Player player = new Player("Игрок", true);
        Game game = new Game(player, doors);
        //when
        Door door = game.round(1);
        //then
        Assertions.assertSame(player,player);
    }




}