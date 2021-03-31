package newcastbots;


enum Emoji {

    GRINNING_FACE_WITH_SMILING_EYES('\uD83D', '\uDE01'),
    FACE_WITH_TEARS_OF_JOY('\uD83D', '\uDE02'),
    SMILING_FACE_WITH_OPEN_MOUTH('\uD83D', '\uDE03'),
    SMILING_FACE_WITH_OPEN_MOUTH_AND_SMILING_EYES('\uD83D', '\uDE04'),
    SMILING_FACE_WITH_OPEN_MOUTH_AND_COLD_SWEAT('\uD83D', '\uDE05'),
    SMILING_FACE_WITH_OPEN_MOUTH_AND_TIGHTLY_CLOSED_EYES('\uD83D', '\uDE06'),
    WINKING_FACE('\uD83D', '\uDE09');

    Character firstChar;
    Character secondChar;

    Emoji(Character firstChar, Character secondChar) {
        this.firstChar = firstChar;
        this.secondChar = secondChar;
    }

    Emoji() {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (this.firstChar != null) {
            sb.append(this.firstChar);
        }
        if (this.secondChar != null) {
            sb.append(this.secondChar);
        }

        return sb.toString();
    }

}

