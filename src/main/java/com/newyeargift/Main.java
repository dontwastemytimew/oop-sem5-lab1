package com.newyeargift;

import com.newyeargift.data.SweetCreator;
import com.newyeargift.data.SweetFileReader;
import com.newyeargift.model.gift.Gift;
import com.newyeargift.model.sweet.Sweet;
import com.newyeargift.service.SugarRangeSearcher;
import com.newyeargift.service.SweetComparators;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {

    private static final Path SWEETS_FILE = Path.of("data/sweets.txt");
    private static final double MIN_SUGAR_PERCENT = 40;
    private static final double MAX_SUGAR_PERCENT = 60;

    public static void main(String[] args) throws IOException {
        Gift gift = createGiftFromFile();

        System.out.println("Total weight: "
                + gift.calculateTotalWeightInGrams() + " g");

        gift.sortSweets(SweetComparators.BY_SUGAR_CONTENT);
        printSweets("Sorted by sugar content:", gift.getSweets());

        List<Sweet> found = new SugarRangeSearcher().findBySugarContentRange(
                gift.getSweets(), MIN_SUGAR_PERCENT, MAX_SUGAR_PERCENT);
        printSweets("Sugar content " + MIN_SUGAR_PERCENT + "-"
                + MAX_SUGAR_PERCENT + "%:", found);
    }

    private static Gift createGiftFromFile() throws IOException {
        SweetFileReader reader = new SweetFileReader(new SweetCreator());
        Gift gift = new Gift();
        for (Sweet sweet : reader.readSweets(SWEETS_FILE)) {
            gift.addSweet(sweet);
        }
        return gift;
    }

    private static void printSweets(String title, List<Sweet> sweets) {
        System.out.println(title);
        for (Sweet sweet : sweets) {
            System.out.println("  " + sweet);
        }
    }
}