package net.creatorsonion.paintingmod.datagen.impl;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import net.creatorsonion.paintingmod.datagen.impl.provider.AdvancementProvider;
import net.creatorsonion.paintingmod.datagen.impl.provider.ItemModelProvider;
import net.creatorsonion.paintingmod.datagen.impl.provider.LootTableProvider;
import net.creatorsonion.paintingmod.datagen.impl.provider.RecipeProvider;
import net.creatorsonion.paintingmod.datagen.impl.provider.StateModelProvider;
import net.creatorsonion.paintingmod.datagen.impl.provider.TagProvider;
import net.minecraft.data.DataGenerator;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.stream.Collectors;

public class DataMain {
    public static void main(String[] strings) throws IOException {
        OptionParser opts = new OptionParser();

        OptionSpec<Void> help     = opts.accepts("help", "Show the help menu").forHelp();
        OptionSpec<Void> server   = opts.accepts("server", "Include server generators");
        OptionSpec<Void> client   = opts.accepts("client", "Include client generators");
        OptionSpec<Void> dev      = opts.accepts("dev", "Include development tools");
        OptionSpec<Void> reports  = opts.accepts("reports", "Include data reports");
        OptionSpec<Void> validate = opts.accepts("validate", "Validate inputs");
        OptionSpec<Void> all      = opts.accepts("all", "Include all generators");

        OptionSpec<String> output = opts.accepts("output", "Output folder").withRequiredArg().defaultsTo("generated");
        OptionSpec<String> extra  = opts.accepts("extra", "Additional output folder to copy assets to").withRequiredArg();
        OptionSpec<String> input  = opts.accepts("input", "Input folder").withRequiredArg();

        OptionSet optionSet = opts.parse(strings);
        if (!optionSet.has(help) && optionSet.hasOptions()) {
            Path path = Paths.get(output.value(optionSet));

            boolean genAll      = optionSet.has(all);
            boolean genClient   = genAll || optionSet.has(client);
            boolean genServer   = genAll || optionSet.has(server);
            boolean genDev      = genAll || optionSet.has(dev);
            boolean genReports  = genAll || optionSet.has(reports);
            boolean genValidate = genAll || optionSet.has(validate);

            DataGenerator gen = create(
                path,
                optionSet.valuesOf(input)
                         .stream()
                         .map(Paths::get)
                         .collect(Collectors.toList()),
                genClient,
                genServer,
                genDev,
                genReports,
                genValidate
            );

            DataGenAccess access = (DataGenAccess) gen;
            access.run(config -> optionSet.valuesOf(extra)
                                          .stream()
                                          .map(Paths::get)
                                          .forEach(config::addCopyPath));
        } else {
            opts.printHelpOn(System.out);
        }
    }

    public static DataGenerator create(Path output, Collection<Path> inputs, boolean includeClient, boolean includeServer, boolean includeDev, boolean includeReports, boolean validate) {
        DataGenerator gen = new DataGenerator(output, inputs);

        if (includeClient) {
            gen.addProvider(new StateModelProvider(gen));
            gen.addProvider(new ItemModelProvider(gen));
        }
        if (includeServer) {
            gen.addProvider(new TagProvider(gen));
            gen.addProvider(new LootTableProvider(gen));
            gen.addProvider(new RecipeProvider(gen));
            gen.addProvider(new AdvancementProvider(gen));
        }

        return gen;
    }
}
