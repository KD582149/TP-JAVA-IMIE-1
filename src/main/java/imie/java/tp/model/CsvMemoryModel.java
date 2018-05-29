package imie.java.tp.model;

import org.gridmodel.core.GridModel;
import org.gridmodel.core.Instance;
import org.gridmodel.core.model.sources.RawSource;
import org.gridmodel.core.model.sources.Source;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.gridmodel.core.Adapters.asDouble;
import static org.gridmodel.core.Adapters.asLong;

@Service
@Scope("singleton")
public class CsvMemoryModel {

    private static Logger logger = LoggerFactory.getLogger(CsvMemoryModel.class);

    private static final String[] SERVERS_FILES = { "esx-alger-01_global.csv",
            "srv-DC-london_global.csv" };

    private static final String[] SERIES = {
        "time",
        "memory_used", "memory_size", "traffic_in", "traffic_out", "security_error", "disk_used", "disk_size",
        "cpu0", "cpu1", "cpu2", "cpu3", "cpu4", "cpu5", "cpu6", "cpu7", "cpu8"
    };

    private final Instance baseInstance;

    private static List<Source> getCsvSources(String... filenames) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        List<Source> sources = new ArrayList<>();

        for (String filename : filenames)
            sources.add(new RawSource(filename, classloader.getResourceAsStream(filename)));

        return sources;
    }

    public List<String> getServers() {
        return Stream.of(SERVERS_FILES)
                .map(server -> server.replaceAll(".csv", ""))
                .collect(Collectors.toList());
    }

    private void initialize() throws IOException {
        baseInstance.index("time", asLong());

        for (String serie : SERIES)
            baseInstance.index(serie, asDouble());

        baseInstance.custom("server", ctx ->
                ctx.sourceName().replaceAll(".csv", ""))
            .append(getCsvSources(SERVERS_FILES));
    }

    public CsvMemoryModel() {
        this.baseInstance = GridModel.instance();
        try {
            initialize();
            logger.info("CSV in memory model initialized");
        } catch (IOException ex) {
            logger.error("The in-memory model could not be initialized because of file loading failed.", ex);
        }
    }

    public Instance getBaseInstance() {
        return baseInstance;
    }

    public List<String> getSeries() {
        return asList(SERIES);
    }
}
