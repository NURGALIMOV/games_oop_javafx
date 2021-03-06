package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class RookBlack implements Figure {
    private final Cell position;

    public RookBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (source.y == dest.y || source.x == dest.x) {
            steps = new Cell[]{dest};
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }

    @Override
    public boolean checkMove(Figure[] figure, Cell source, Cell dest) {
        boolean check = true;
        if (source.x == dest.x) {
            if (source.y < dest.y) {
                for (int i = dest.y; i != source.y; i--) {
                    for (Figure fr : figure) {
                        if ((fr.position().x == source.x) && (fr.position().y == i)) {
                            check = false;
                        }
                    }
                }
            }
            if (source.y > dest.y) {
                for (int i = dest.y; i != source.y; i++) {
                    for (Figure fr : figure) {
                        if ((fr.position().x == source.x) && (fr.position().y == i)) {
                            check = false;
                        }
                    }
                }
            }
        }
        if (source.y == dest.y) {
            if (source.x < dest.x) {
                for (int i = dest.x; i != source.x; i--) {
                    for (Figure fr : figure) {
                        if ((fr.position().y == source.y) && (fr.position().x == i)) {
                            check = false;
                        }
                    }
                }
            }
            if (source.x > dest.x) {
                for (int i = dest.x; i != source.x; i++) {
                    for (Figure fr : figure) {
                        if ((fr.position().y == source.y) && (fr.position().x == i)) {
                            check = false;
                        }
                    }
                }
            }
        }
        return check;
    }
}
