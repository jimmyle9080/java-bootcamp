package com.academy.library;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class ReportService {

    private final LibraryService libraryService;

    public ReportService(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public void displaySummaryReport() {
        int totalBooks = libraryService.getBooks().size();
        int borrowedBooks = libraryService.getBorrowRecords().size();
        int availableBooks = totalBooks - borrowedBooks;
        int totalMembers = libraryService.getMembers().size();

        System.out.println("Reports");
        System.out.println("Books : " + totalBooks);
        System.out.println("Borrowed : " + borrowedBooks);
        System.out.println("Available : " + availableBooks);
        System.out.println("Members : " + totalMembers);
        System.out.println("Most Popular Category : " + findMostPopularCategory());
    }

    public Path exportReportToFile(String fileName) throws IOException {
        int totalBooks = libraryService.getBooks().size();
        int borrowedBooks = libraryService.getBorrowRecords().size();
        int availableBooks = totalBooks - borrowedBooks;
        int totalMembers = libraryService.getMembers().size();

        StringBuilder sb = new StringBuilder();
        sb.append("Reports").append(System.lineSeparator());
        sb.append("Books : ").append(totalBooks).append(System.lineSeparator());
        sb.append("Borrowed : ").append(borrowedBooks).append(System.lineSeparator());
        sb.append("Available : ").append(availableBooks).append(System.lineSeparator());
        sb.append("Members : ").append(totalMembers).append(System.lineSeparator());
        sb.append("Most Popular Category : ").append(findMostPopularCategory()).append(System.lineSeparator());
        sb.append(System.lineSeparator());
        sb.append("Books per Category").append(System.lineSeparator());
        libraryService.getCategoryBookCount().forEach((category, count) ->
                sb.append(category).append(" : ").append(count).append(System.lineSeparator()));

        Path path = Path.of(fileName);
        Files.writeString(path, sb.toString());
        return path;
    }

    private String findMostPopularCategory() {
        return libraryService.getCategoryBookCount().entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("N/A");
    }
}