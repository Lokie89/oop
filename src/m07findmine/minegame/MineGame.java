package m07findmine.minegame;

import m07findmine.MineExploreException;
import m07findmine.FindAllMineException;
import m07findmine.mineboard.MineBoard;
import m07findmine.mineboard.MineList;
import m07findmine.miner.MineGamer;
import m07findmine.miner.Miner;

import java.util.Scanner;

public class MineGame implements Game {
    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);
        MineBoard mineBoard = new MineList(3, 30);
        while (true) {
            try {
                Miner miner = new MineGamer(scanner.nextInt(), scanner.nextInt());
                miner.dig(mineBoard);
                mineBoard.print();
            } catch (MineExploreException e) {
                System.out.println(e.getMessage());
                break;
            } catch (FindAllMineException e){
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}
