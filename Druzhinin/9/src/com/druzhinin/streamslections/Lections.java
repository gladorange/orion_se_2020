package com.druzhinin.streamslections;

public enum Lections {
    MATH {
        @Override
        public String toString() {
            return "Матанализ";
        }
    },
    PHIL {
        @Override
        public  String toString() {
            return "Философия";
        }
    },
    ENG {
        @Override
        public String toString() {
            return "Английский";
        }
    },
    HIST {
        @Override
        public String toString() {
            return "История";
        }
    },
    PHISC {
        @Override
        public String toString() {
            return "Физкультура";
        }
    }
}
