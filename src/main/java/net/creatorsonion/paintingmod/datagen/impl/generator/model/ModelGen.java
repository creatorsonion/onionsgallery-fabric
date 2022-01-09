package net.creatorsonion.paintingmod.datagen.impl.generator.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.util.Identifier;

@FunctionalInterface
public interface ModelGen {
    ModelGen EMPTY = name -> new JsonObject();
    JsonElement makeJson(Identifier name);
}
