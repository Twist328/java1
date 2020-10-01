package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;

class AbsInteger extends BigDecimal {

    public AbsInteger() {
        super(BigInteger.ONE);

    }

    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        AbsInteger result = (AbsInteger) AbsInteger.valueOf(0);
          result = (AbsInteger) num1.add(num2);

         return (AbsInteger) result;
     }

     @Override
     public String toString() {
         return "AbsInteger{}";
     }
 }

    class ByteInteger extends AbsInteger {

        public ByteInteger(byte b) {
            super();

        }

        @Override
        public String toString() {
            return "ByteInteger{}";
        }
    }

      class   ShortInteger extends AbsInteger {

          public ShortInteger(short a) {
              super();
          }

          @Override
          public String toString() {
              return "ShortInteger{}";
          }
      }
    class IntInteger extends AbsInteger {
        public IntInteger(int i) {
            super();
        }

        @Override
        public String toString() {
            return "IntInteger{}";
        }
    }
