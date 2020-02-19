package com.yamanov.logic.model;

import com.yamanov.logic.format.FormatText;

import java.util.ArrayList;

public class CommonItem {

    //общее
    private String name;  // название/статья в журнале
    private ArrayList<Author> authors = new ArrayList<>();
    private String publisher;  // издательство/журнал
    private String city;
    private Integer year;
    private Integer pages;

    private String date;

    //для статьи, монографии
    private String numJournal;
    private Integer startPage;
    private Integer endPage;

    //для автореферата/диссертации
    private String regaliaAuthor;

    //для диссертиции
    private String workStatus;

    //для учебных пособий
    private String editor;

    //для патентов
    private String numPatent;
    private Integer numBull;

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

    public String getNumJournal() {
        return numJournal;
    }

    public void setNumJournal(String numJournal) {
        this.numJournal = numJournal;
    }

    public Integer getStartPage() {
        return startPage;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    public Integer getEndPage() {
        return endPage;
    }

    public void setEndPage(Integer endPage) {
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

    public Integer getNumBull() {
        return numBull;
    }

    public void setNumBull(Integer numBull) {
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

    public Author getAuthor(Integer index) {
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public void clearAuthorsList() {
        authors.clear();
    }

    public String[] getFormattedText() {
        return new String[]{new FormatText().getFormatText(this)};
    }
}
