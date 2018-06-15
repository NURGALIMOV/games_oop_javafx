package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopWhite implements Figure {
    private final Cell position;

    public BishopWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (Math.abs(source.y - source.x) == Math.abs(dest.y - dest.x)) {
            steps = new Cell[]{dest};
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }

    @Override
    public boolean checkMove(Figure[] figure, Cell source, Cell dest) {
        boolean check = true;
        if (source.x < dest.x && source.y < dest.y) {
            for (int x = dest.x, y = dest.y; x != source.x && y != source.y; x--, y--) {
                for (Figure fr : figure) {
                    if (fr.position().x == x && fr.position().y == y) {
                        check = false;
                    }
                }
            }
        }
        if (source.x > dest.x && source.y > dest.y) {
            for (int x = dest.x, y = dest.y; x != source.x && y != source.y; x++, y++) {
                for (Figure fr : figure) {
                    if (fr.position().x == x && fr.position().y == y) {
                        check = false;
                    }
                }
            }
        }
        if (source.x > dest.x && source.y < dest.y) {
            for (int x = dest.x, y = dest.y; x != source.x && y != source.y; x++, y--) {
                for (Figure fr : figure) {
                    if (fr.position().x == x && fr.position().y == y) {
                        check = false;
                    }
                }
            }
        }
        if (source.x < dest.x && source.y > dest.y) {
            for (int x = dest.x, y = dest.y; x != source.x && y != source.y; x--, y++) {
                for (Figure fr : figure) {
                    if (fr.position().x == x && fr.position().y == y) {
                        check = false;
                    }
                }
            }
        }
        return check;
    }
}
