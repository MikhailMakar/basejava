package com.basejava.webapp.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArrayStorageTest.class,
        ListStorageTest.class,
        MapResumeStorageTest.class,
        MapUuidStorageTest.class,
        SortedArrayStorageTest.class,
        ObjectStreamPathStorageTest.class,
        ObjectStreamFileStorageTest.class})
public class AllStorageTest {
}
