package ru.progwards.java1.lessons.bigints;

public  class AbsInteger {

    public AbsInteger(byte value) {
    }

    public AbsInteger(short value) {
    }

    public AbsInteger(int value) {
    }

    public AbsInteger(AbsInteger value) {

    }

    public static void main(String[] args) {

        AbsInteger num = new AbsInteger(2);
        System.out.println(num);
    }

    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        AbsInteger number = AbsInteger.add(num1, num2);

        return number;
    }


}
    class ByteInteger extends AbsInteger {
        byte value=0;
        public ByteInteger(byte value) {
            super(value);

        }

        @Override
        public String toString() {
            return ""+ value;
        }
    }
        class ShortInteger extends AbsInteger {
            short value=0;
            public ShortInteger(short value) {
                super(value);
            }

            @Override
            public String toString() {
                return "" + value;

            }
        }
            class IntInteger extends AbsInteger {
                int value=0;
                public IntInteger(int value) {
                    super(value);
                }

                @Override
                public String toString() {
                    return ""+ value;
                }
            }


