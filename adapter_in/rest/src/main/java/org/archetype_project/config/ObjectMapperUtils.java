package org.archetype_project.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;

@Slf4j
public class ObjectMapperUtils {

    private static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper()
                .registerModule(new SimpleModule())
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .configure(SerializationFeature.WRITE_DATES_WITH_ZONE_ID, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE)
                .setSerializationInclusion(JsonInclude.Include.CUSTOM);
    }

    private ObjectMapperUtils() {

    }

    public static ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER;
    }

    public static <T> T parse(String textParse, Class<T> className) throws IOException {
        return mapperReader(textParse, className, false);
    }

    public static <T> List<T> parseList(String textParse, Class<? extends Collection> type, Class<T> elementType) throws IOException {
        return mapperReaderList(textParse,type, elementType, false);
    }

    public static <T> T mapperReader(String fileNameOrObject, Class<T> className) throws IOException {
        return mapperReader(fileNameOrObject, className, true);
    }

    public static <T> T mapperReader(String fileNameOrObject, Class<T> className, boolean isFile) throws IOException {
        return OBJECT_MAPPER.readValue(isFile ? readFile(fileNameOrObject) : fileNameOrObject, className);
    }
    public static <T> List<T> mapperReaderList(String fileNameOrObject, Class<? extends Collection> type, Class<T> elementType, boolean isFile) throws IOException {
        var textParse = isFile ? readFile(fileNameOrObject) : fileNameOrObject;
        return OBJECT_MAPPER.readValue(textParse, OBJECT_MAPPER.getTypeFactory().constructCollectionType(type, elementType));
    }

    private static String readFile(String path) throws IOException {
        File jsonRequest = ResourceUtils.getFile(path);
        return new String(Files.readAllBytes(jsonRequest.toPath()));
    }

    public static String writeValueAsString(Object obj) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsString(obj);
    }
}
