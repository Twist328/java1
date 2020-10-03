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

        return (AbsInteger) num1.add(num2);
    }

    private Object add(AbsInteger num2) {
        return 0;
    }

}
    class ByteInteger extends AbsInteger {
        byte value=0;
        public ByteInteger(byte value) {
            super();

        }

        @Override
        public String toString() {
            return ""+ value;
        }
    }
        class ShortInteger extends AbsInteger {
            short value=0;
            public ShortInteger(short value) {
                super();
            }

            @Override
            public String toString() {
                return "" + value;

            }
        }
            class IntInteger extends AbsInteger {
                int value=0;
                public IntInteger(int value) {
                    super();
                }

                @Override
                public String toString() {
                    return ""+ value;
                }
            }


