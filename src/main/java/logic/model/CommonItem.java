package logic.model;

import logic.format.FormatText;

import java.util.ArrayList;

public class CommonItem {

    //общее
    private String name;  // название/статья в журнале
    private ArrayList<Author> authors = new ArrayList<>();
    private String publisher;  // издательство/журнал
    private String city;
    private int year;
    private int pages;

    private String date;

    //для статьи, монографии
    private int numJournal;
    private int startPage;
    private int endPage;

    //для автореферата/диссертации
    private String regaliaAuthor;

    //для диссертиции
    private String workStatus;

    //для учебных пособий
    private String editor;

    //для патентов
    private String numPatent;
    private int numBull;

    //для материалов конференций
    private String topic;

    //для интернет документов
    private String url;

    private String itemType;


    public CommonItem() {
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumJournal() {
        return numJournal;
    }

    public void setNumJournal(int numJournal) {
        this.numJournal = numJournal;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public String getRegaliaAuthor() {
        return regaliaAuthor;
    }

    public void setRegaliaAuthor(String regaliaAuthor) {
        this.regaliaAuthor = regaliaAuthor;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getNumPatent() {
        return numPatent;
    }

    public void setNumPatent(String numPatent) {
        this.numPatent = numPatent;
    }

    public int getNumBull() {
        return numBull;
    }

    public void setNumBull(int numBull) {
        this.numBull = numBull;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String[] getFormattedText() {
        return new String[]{new FormatText().getFormatText(this)};
    }
}
