package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FigureTest {
    @Test
    public void whenThereIsPawn() {
        Figure figure = new PawnBlack(Cell.E7);
        Cell[] cell = figure.way(Cell.E7, Cell.E6);
        assertThat(cell[0], is(Cell.E6));
    }
    @Test
    public void whenThereIsBishop() {
        Figure figure = new BishopBlack(Cell.C8);
        Cell[] cell = figure.way(Cell.C8, Cell.A6);
        assertThat(cell[0], is(Cell.A6));
    }
    @Test
    public void whenThereIsKing() {
        Figure figure = new KingBlack(Cell.E8);
        Cell[] cell = figure.way(Cell.E8, Cell.E7);
        assertThat(cell[0], is(Cell.E7));
    }
    @Test
    public void whenThereIsKnight() {
        Figure figure = new KnightBlack(Cell.B8);
        Cell[] cell = figure.way(Cell.B8, Cell.A6);
        assertThat(cell[0], is(Cell.A6));
    }
    @Test
    public void whenThereIsQeen() {
        Figure figure = new QeenBlack(Cell.D8);
        Cell[] cell = figure.way(Cell.D8, Cell.H4);
        assertThat(cell[0], is(Cell.H4));
    }
    @Test
    public void whenThereIsRook() {
        Figure figure = new RookBlack(Cell.A8);
        Cell[] cell = figure.way(Cell.A8, Cell.A3);
        assertThat(cell[0], is(Cell.A3));
    }
}
