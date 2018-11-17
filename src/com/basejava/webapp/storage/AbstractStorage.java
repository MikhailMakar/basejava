package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractStorage implements Storage {

    protected List<Resume> listResume = new ArrayList<>();
    protected Map<String, Resume> mapResume = new HashMap<>();

}
