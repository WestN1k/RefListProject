package logic.model;

import java.util.ArrayList;

public class CommonItem {
    private String name;
    private ArrayList<Author> authors = new ArrayList<>();
    private String publisher;
    private String city;
    private int year;
    private int pages;

    private String itemType;

    public CommonItem() {
    }

    public CommonItem(String name, String publisher, String city, int year, int pages, String itemType) {
        this.name = name;
        this.publisher = publisher;
        this.city = city;
        this.year = year;
        this.pages = pages;
        this.itemType = itemType;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setAuthor(Author author) {
        authors.add(author);
    }

    public Author getAuthor(int index) {
        return getAuthors().get(index);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void clearAuthorsList() {
        authors.clear();
    }

    public String getStringAuthors() {
        ArrayList<String> stringAuthors = new ArrayList<>();
        for(Author author: getAuthors()) {
            stringAuthors.add(author.getShortRecord());
        }
        return String.join(", ", stringAuthors);
    }
}
