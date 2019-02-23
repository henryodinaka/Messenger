package com.leo.henry.messenger.lecture.interfaceLecture;

import java.util.List;

public interface ISavable {
    List<String> write();
    void read(List<String> savedValue);
}
