package logic.format;

import logic.model.CommonItem;

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

    private String getFormatTextDissertation() {
        return "this is dissertation";
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
        return item.getAuthor(0).getShortRecordWithComma() + " " + item.getName() + "/"+ item.getStringAuthors() + ": " + item.getCity()
                + ":" + item.getPublisher() + " - " + item.getYear() + ", " + item.getPages() + " c.";
    }

    private String getFormatTextMonography() {
        return "this is monography";
    }

    private String getFormatTextJournal() {
        return "this is journal";
    }

    private String getFormatTextSynopsis() {
        return "this is synopsis";
    }

}
