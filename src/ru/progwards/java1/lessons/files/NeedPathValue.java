package ru.progwards.java1.lessons.files;

import java.nio.file.Path;

public interface NeedPathValue <Result, Value> {
    Result get(Value p);
}