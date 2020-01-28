package logic.format;

import logic.model.Author;
import logic.model.CommonItem;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleToIntFunction;

public final class FormatText {

    private CommonItem item;

    public String getFormatText(CommonItem item) {
        this.item = item;
        switch (this.item.getItemType()) {
            case "Учебники": return getFormatTextManual();
            case "Монографии": return getFormatTextMonography();
            case "Журнальные статьи": return getFormatTextJournal();
            case "Авторефераты": return getFormatTextSynopsis();
            case "Диссертации": return getFormatTextDissertation();
            case "Обзоры (аналитика)": return getFormatTextReview();
            case "Патенты": return getFormatTextPatents();
            case "Материалы конференций": return getFormatTextConferention();
            case "Интернет-документы": return getFormatTextWebDocuments();
            case "Учебные пособия": return getFormatTextTutorial();
            case "Словари": return getFormatTextDictionary();
        }

        return "";
    }

    private void getText(String pattern) {
        Map<String, String> map = new HashMap<>();
        map.put("автор", item.getAuthor(0).getShortRecordWithComma());
        map.put("название", item.getName());
        map.put("номер", getIntegerToString(item.getNumJournal()));
        map.put("регалии", item.getRegaliaAuthor());
        map.put("специализация", item.getWorkStatus());
        map.put("год", getIntegerToString(item.getYear()));
        map.put("страницы", getFormattedPages());
        map.put("соавторы", getFormattedListAuthors());
        map.put("город", getFormattedCity());
        map.put("автор(полностью)", item.getAuthor(0).getFullRecord());
        map.put("издательство", item.getPublisher());
    }

    private String getFormatTextDissertation() {
        return MessageFormat.format("{0} {1}: дис. ...{2}: {3} / {4} - {5}, {6}. - {7}",
                item.getAuthor(0).getShortRecordWithComma(),
                item.getName(),
                item.getRegaliaAuthor(),
                item.getWorkStatus(),
                item.getAuthor(0).getFullRecord(),
                getFormattedCity(),
                getIntegerToString(item.getYear()),
                getFormattedPages());
    }

    private String getFormatTextReview() {
        return "review";
    }

    private String getFormatTextPatents() {
        return "patents";
    }

    private String getFormatTextConferention() {
        return "conferention";
    }

    private String getFormatTextWebDocuments() {
        return "web document";
    }

    private String getFormatTextTutorial() {
        return "tutorial";
    }

    private String getFormatTextDictionary() {
        return "dictionary";
    }

    private String getFormatTextManual() {
        return MessageFormat.format("{0} {1} / {2} - {3}: {4}, {5}. - {6}",
                item.getAuthor(0).getShortRecordWithComma(),
                item.getName(),
                getFormattedListAuthors(),
                getFormattedCity(),
                item.getPublisher(),
                getIntegerToString(item.getYear()),
                getFormattedPages() );
    }

    private String getFormatTextMonography() {
        return "this is monography";
    }

    private String getFormatTextJournal() {
        return MessageFormat.format("{0} {1} / {2} // {3}. - {4}. - №{5}. - {6}",
                item.getAuthor(0).getShortRecordWithComma(),
                item.getName(),
                getFormattedListAuthors(),
                item.getPublisher(),
                getIntegerToString(item.getYear()),
                getIntegerToString(item.getNumJournal()),
                getFormattedPages());
    }

    private String getFormatTextSynopsis() {
        return MessageFormat.format("{0} {1}: Автореф.дис. ...{2}: {3} / {4} - {5}, {6}. - {7}",
                item.getAuthor(0),
                item.getName(),
                item.getRegaliaAuthor(),
                item.getWorkStatus(),
                item.getAuthor(0).getFullRecord(),
                getFormattedCity(),
                getIntegerToString(item.getYear()),
                getFormattedPages());
    }


    private String getFormattedListAuthors() {
        ArrayList<String> stringAuthors = new ArrayList<>();
        if (item.getAuthors().size() > 3) {
            return item.getAuthor(0).getShortRecord() + " [и др.]";
        } else {
            for (Author author: item.getAuthors()) {
                stringAuthors.add(author.getShortRecord());
            }
            return String.join(", ", stringAuthors);
        }
    }

    private String getFormattedCity() {
        if (item.getCity().equalsIgnoreCase("Москва")){
            return "М.";
        } else if (item.getCity().equalsIgnoreCase("Санкт-Петербург") ||
                item.getCity().equalsIgnoreCase("Санкт Петербург")) {
            return "СПб.";
        } else {
            return item.getCity();
        }
    }

    private String getIntegerToString(int value) {
        return Integer.toString(value).replaceAll(" ", "");
    }

    private String getFormattedPages() {
        if (item.getStartPage() == 0 && item.getEndPage() == 0) {
            return getIntegerToString(item.getPages())  + " с.";
        } else {
            if (item.getStartPage() == item.getEndPage()) {
                return ("С. " + item.getStartPage());
            } else {
                return (getIntegerToString(item.getStartPage()) + "-" + getIntegerToString(item.getEndPage()) + " с.");
            }
        }
    }
}
