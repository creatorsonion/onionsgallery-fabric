package net.creatorsonion.paintingmod.datagen.impl;

import java.nio.file.Path;

public interface DataCacheAccess {
    void addCopyPath(Path out);
    void keepFiles(Path... keep);
}
