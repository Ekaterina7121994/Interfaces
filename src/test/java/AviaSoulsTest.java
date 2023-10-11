import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void comparisonTicketsByPrice() {
        Ticket ticket1 = new Ticket("Нижний", "Москва", 5_200, 14, 17);
        Ticket ticket2 = new Ticket("Казань", "Москва", 1_500, 11, 20);
        Ticket ticket3 = new Ticket("Нижний", "Пенза", 500, 13, 15);
        Ticket ticket4 = new Ticket("Саратов", "Ковров", 1_850, 4, 9);
        Ticket ticket5 = new Ticket("Нижний", "Москва", 3_600, 16, 23);
        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Arrays.sort(tickets);
    }

    @Test
    public void backArrayMultipleTickets() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Нижний", "Москва", 5_200, 14, 17);
        Ticket ticket2 = new Ticket("Казань", "Москва", 1_500, 11, 20);
        Ticket ticket3 = new Ticket("Нижний", "Пенза", 500, 13, 15);
        Ticket ticket4 = new Ticket("Саратов", "Ковров", 1_850, 4, 9);
        Ticket ticket5 = new Ticket("Нижний", "Москва", 3_600, 16, 23);
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] actual = aviaSouls.search("Нижний", "Москва");
        Ticket[] expected = {ticket5, ticket1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void backArrayOneTicket() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Нижний", "Москва", 5_200, 14, 17);
        Ticket ticket2 = new Ticket("Казань", "Москва", 1_500, 11, 20);
        Ticket ticket3 = new Ticket("Нижний", "Пенза", 500, 13, 15);
        Ticket ticket4 = new Ticket("Саратов", "Ковров", 1_850, 4, 9);
        Ticket ticket5 = new Ticket("Нижний", "Москва", 3_600, 16, 23);
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] actual = aviaSouls.search("Саратов", "Ковров");
        Ticket[] expected = {ticket4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void backEmptyArray() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Нижний", "Москва", 5_200, 14, 17);
        Ticket ticket2 = new Ticket("Казань", "Москва", 1_500, 11, 20);
        Ticket ticket3 = new Ticket("Нижний", "Пенза", 500, 13, 15);
        Ticket ticket4 = new Ticket("Саратов", "Ковров", 1_850, 4, 9);
        Ticket ticket5 = new Ticket("Нижний", "Москва", 3_600, 16, 23);
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] actual = aviaSouls.search("Саратов", "Москва");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TicketTimeComparator() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("Нижний", "Москва", 5_200, 2, 15); // 13
        Ticket ticket2 = new Ticket("Казань", "Москва", 1_500, 19, 20); //1
        Ticket ticket3 = new Ticket("Нижний", "Пенза", 500, 7, 24);  //17
        Ticket ticket4 = new Ticket("Саратов", "Ковров", 1_850, 4, 9); //5
        Ticket ticket5 = new Ticket("Нижний", "Москва", 3_600, 7, 23); //16

        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Arrays.sort(tickets, timeComparator);
    }

    @Test
    public void backEmptyArrayComparator() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Нижний", "Москва", 5_200, 2, 15);
        Ticket ticket2 = new Ticket("Казань", "Москва", 1_500, 19, 20);
        Ticket ticket3 = new Ticket("Нижний", "Пенза", 500, 7, 24);
        Ticket ticket4 = new Ticket("Саратов", "Ковров", 1_850, 4, 9);
        Ticket ticket5 = new Ticket("Нижний", "Москва", 3_600, 7, 23);
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = aviaSouls.searchAndSortBy("Саратов", "Москва", comparator);
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void backArrayOneTicketComparator() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Нижний", "Москва", 5_200, 2, 15);
        Ticket ticket2 = new Ticket("Казань", "Москва", 1_500, 19, 20);
        Ticket ticket3 = new Ticket("Нижний", "Москва", 500, 7, 24);
        Ticket ticket4 = new Ticket("Саратов", "Ковров", 1_850, 4, 9);
        Ticket ticket5 = new Ticket("Нижний", "Москва", 3_600, 7, 23);
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = aviaSouls.searchAndSortBy("Саратов", "Ковров", comparator);
        Ticket[] expected = {ticket4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void backArraySeveralTicketComparator() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Нижний", "Москва", 5_200, 2, 15); // 13
        Ticket ticket2 = new Ticket("Казань", "Москва", 1_500, 19, 20);
        Ticket ticket3 = new Ticket("Нижний", "Москва", 500, 7, 24);  //17
        Ticket ticket4 = new Ticket("Саратов", "Ковров", 1_850, 4, 9);
        Ticket ticket5 = new Ticket("Нижний", "Москва", 3_600, 7, 23); //16
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = aviaSouls.searchAndSortBy("Нижний", "Москва", comparator);
        Ticket[] expected = {ticket1, ticket5, ticket3};
        Assertions.assertArrayEquals(expected, actual);
    }
}