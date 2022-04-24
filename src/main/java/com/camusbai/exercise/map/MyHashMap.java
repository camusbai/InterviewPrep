package com.camusbai.exercise.map;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap {
    int SIZE = 12;
    private List<List<Entry>> data = new ArrayList<>();

    public MyHashMap() {
        for (int i = 0; i < SIZE; i++) {
            data.add(new ArrayList<>());
        }
    }

    public void put(String key, String value) {
        int idx = key.hashCode() % SIZE;
        List<Entry> entries = data.get(idx);
        if (entries == null) {
            List<Entry> newEntries = new ArrayList<>();
            Entry entry = new Entry();
            entry.key = key;
            entry.val = value;
            newEntries.add(entry);
        } else {
            boolean keyExists = false;
            for (Entry entry : entries) {
                if (key.equals(entry.key)) {
                    entry.val = value;
                    keyExists = true;
                }
            }
            if (!keyExists) {
                entries.add(new Entry().withKey(key).withVal(value));
            }
        }
    }

    public String get(String key) {
        int idx = key.hashCode() % 12;
        List<Entry> entries = data.get(idx);
        return entries.stream().filter(entry -> key.equals(entry.getKey()))
                .findAny()
                .map(Entry::getVal).orElse(null);
    }

    static class Entry {
        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Entry withKey(String key) {
            this.key = key;
            return this;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }

        public Entry withVal(String val) {
            this.val = val;
            return this;
        }

        private String key;
        private String val;
    }
}
