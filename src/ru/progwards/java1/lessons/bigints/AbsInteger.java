package ru.progwards.java1.lessons.bigints;

 class AbsInteger {


     public AbsInteger() {
     }

     static AbsInteger add(AbsInteger num1, AbsInteger num2) {

         AbsInteger result = num1.add(num2);

         return result;
     }

     private AbsInteger add(AbsInteger num2) {
         return null;
     }


     @Override
     public String toString() {
         return "AbsInteger{}";
     }
 }

    class ByteInteger extends AbsInteger {

        public ByteInteger(byte b) {

        }

        @Override
        public String toString() {
            return "ByteInteger{}";
        }
    }

      class   ShortInteger extends AbsInteger {

          public ShortInteger(short a) {
          }

          @Override
          public String toString() {
              return "ShortInteger{}";
          }
      }
    class IntInteger extends AbsInteger {
        public IntInteger(int i) {
        }

        @Override
        public String toString() {
            return "IntInteger{}";
        }
    }
