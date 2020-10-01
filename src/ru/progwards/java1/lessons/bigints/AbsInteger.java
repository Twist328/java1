package ru.progwards.java1.lessons.bigints;

 class AbsInteger {
     public AbsInteger() {
     }

     static AbsInteger add(AbsInteger num1, AbsInteger num2) {
         AbsInteger absInteger =num1.add(num2);

         return absInteger;
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

        public ByteInteger() {
        }

        @Override
        public String toString() {
            return "ByteInteger{}";
        }
    }

      class   ShortInteger extends AbsInteger {

          public ShortInteger() {
          }

          @Override
          public String toString() {
              return "ShortInteger{}";
          }
      }
    class IntInteger extends AbsInteger {
        public IntInteger() {
        }

        @Override
        public String toString() {
            return "IntInteger{}";
        }
    }
