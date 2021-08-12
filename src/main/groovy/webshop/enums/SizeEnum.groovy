package webshop.enums

enum SizeEnum {
    S("S"),
    M("M"),
    L("L")

    private final String string;

    SizeEnum(String string) {
        this.string = string
    }

    String getText() {
        return string
    }
}
