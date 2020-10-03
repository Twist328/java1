package ru.progwards.java1.lessons.bigints;

public  class AbsInteger {


    public AbsInteger() {

    }

    public AbsInteger(int i, int i1) {

    }

    public static void main(String[] args) {
        AbsInteger num = new AbsInteger(2, 3);
        System.out.println(num);
    }

    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        int result = 0;
        result = (int) num1.add(num2);

        return null;
    }

    private Object add(AbsInteger num2) {
        return 0;
    }

}
    class ByteInteger extends AbsInteger {

        public ByteInteger(byte value) {
            super();

        }

        @Override
        public String toString() {
            return "ByteInteger{}";
        }
    }
        class ShortInteger extends AbsInteger {

            public ShortInteger(short value) {
                super();
            }

            @Override
            public String toString() {
                return "ShortInteger{}";

            }
        }
            class IntInteger extends AbsInteger {
                public IntInteger(int value) {
                    super();
                }

                @Override
                public String toString() {
                    return "IntInteger{}";
                }
            }


