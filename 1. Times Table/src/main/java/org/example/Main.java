package org.example;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    record Pair<T>(T item1, T item2) {
        public Pair<T> reverse() {
            return new Pair<>(item2, item1);
        }
    }

    static Scanner in = new Scanner(System.in);
    static Set<Pair<Integer>> pairs = new HashSet<>();

    public static void main(String[] args) {

        int correct = 0;
        int total = getRandom(10, 15);

        for (int i = 0; i < total; i++) {
            Pair<Integer> pair;
            do {
                var a = getRandom(2, 10);
                var b = getRandom(2, 10);
                pair = new Pair<Integer>(a, b);
            } while (pairs.contains(pair) || pairs.contains(pair.reverse()));

            var product = pair.item1 * pair.item2;
            System.out.printf("№%d. \t %d * %d = ", i + 1, pair.item1, pair.item2);
            var answer = getUserInt();
            if (answer == pair.item1 * pair.item2) {
                correct++;
            }
        }

        System.out.printf("Правильних відповідей: %d/%d%n", correct, total);
        System.out.printf("Оцінка: %d/12", (int) Math.floor(12.0 * correct / total));
    }

    public static int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(min, max);
    }

    public static int getUserInt() {
        return Integer.parseInt(in.nextLine());
    }
}