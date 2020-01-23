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
        }

        return "";
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
