package com.company;

public class Main {
    public static class InputInfo {
        InputInfo(String firstStrVal, String secondStrVal) {
            if (firstStrVal == null || secondStrVal == null || firstStrVal.isEmpty() || secondStrVal.isEmpty())
                throw new NullPointerException();

            try {
                firstVal = Integer.parseInt(firstStrVal);
                secondVal = Integer.parseInt(secondStrVal);
            }
            catch (NumberFormatException ex) {
                throw new NumberFormatException();
            }
        }

        public Integer[] getIntegerValues() {
            return new Integer[] {firstVal, secondVal};
        }

        Integer firstVal;
        Integer secondVal;
    }

    public static class PrintInfo {
        PrintInfo(SimpleOperationInteger object) {
            if (object == null)
                return;

            if (object.isEquals())
                System.out.println("Values is equals");
            else {
                String biggerOrLessStr = object.firstIsBigger() ? "bigger" : "less";

                System.out.format("Number %s is %s than the %s number\n",
                        object.getFirstValue().toString(), biggerOrLessStr, object.getSecondValue().toString());
            }

            System.out.format("Sum of the numbers: %s\n", object.sum().toString());
        }
    }

    public static class SimpleOperationInteger {
        SimpleOperationInteger(Integer firstValue, Integer secondValue) {
            try {
                if (firstValue == null || secondValue == null)
                    throw new NullPointerException();
            }
            catch (NullPointerException ex) {
                System.out.println("Exception: error create of object SimpleOperationInteger - invariant values");
            }

            _firstValue = firstValue;
            _secondValue = secondValue;
        }

        boolean firstIsBigger() {
            return (_firstValue > _secondValue);
        }

        Integer sum() {
            return _firstValue + _secondValue;
        }

        Integer getFirstValue() {
            return _firstValue;
        }

        Integer getSecondValue() {
            return _secondValue;
        }

        boolean isEquals() {
            return _firstValue.equals(_secondValue);
        }

        private Integer _firstValue;
        private Integer _secondValue;
    }

    public static void main(String[] args) {
        InputInfo inputInfo;
        try {
            inputInfo = new InputInfo("-31", "-20");
        }
        catch (NullPointerException ex) {
            System.err.println("Exception: error create of object InputInfo - invariant values");
            return;
        }
        catch (NumberFormatException ex){
            System.err.println("Exception: error create of object InputInfo - error parse values");
            return;
        }

        SimpleOperationInteger simpleOperationInteger  = new SimpleOperationInteger(inputInfo.getIntegerValues()[0],
                    inputInfo.getIntegerValues()[1]);

        PrintInfo printInfo = new PrintInfo(simpleOperationInteger);
    }
}


