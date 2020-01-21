package logic.format;

import logic.model.CommonItem;

public final class FormatText {

    public String getFormatTextManual(CommonItem item) {
        return item.getAuthor().getShortRecordWithComma() + " " + item.getName() + "/"+ item.getStringAuthors() + ": " + item.getCity()
                + ":" + item.getPublisher() + " - " + item.getYear() + ", " + item.getPages() + " c.";
    }

    public String getFormatTextMonography() {
        return "this is monography";
    }

}
