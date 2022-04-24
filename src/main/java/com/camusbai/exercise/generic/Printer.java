package com.camusbai.exercise.generic;

import java.io.Serializable;

public class Printer <T extends Printer.MyClass & Serializable>{


    static class MyClass{

    }
}
