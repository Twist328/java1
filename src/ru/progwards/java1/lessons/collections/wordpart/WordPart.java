package ru.progwards.java1.lessons.collections.wordpart;

interface WordPart {
    String getWordPart();
}

 class Root extends Ending implements WordPart {

    private String part;

    public Root(String part) {
        this.part = part;
    }

    @Override
    public String getWordPart() {
        return part;
    }
}

class Prefix extends Ending implements WordPart {

    private String part;

    public Prefix(String part) {
        this.part = part;
    }

    @Override
    public String getWordPart() {
        return part;
    }
}

class Suffix extends Ending implements WordPart {

    private String part;

    public Suffix(String part) {
        super();
        this.part = part;
    }

    @Override
    public String getWordPart() {
        return part;
    }
}

class Ending implements WordPart {

    private String part;

    public Ending(String part) {
        this.part = part;
    }

    public Ending() {

    }

    @Override
    public String getWordPart() {
        return part;
    }
}