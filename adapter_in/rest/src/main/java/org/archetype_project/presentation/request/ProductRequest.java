package org.archetype_project.presentation.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.archetype_project.util.ConstantsNames;

import java.util.List;

public record ProductRequest(
        @JsonProperty(ConstantsNames.TITLE)
        String title,
        @JsonProperty(ConstantsNames.DESCRIPTION)
        String description,
        @JsonProperty(ConstantsNames.PRICE)
        String price,
        @JsonProperty(ConstantsNames.DISCOUNTPERCENTAGE)
        String discountPercentage,
        @JsonProperty(ConstantsNames.RATING)
        String rating,
        @JsonProperty(ConstantsNames.STOCK)
        String stock,
        @JsonProperty(ConstantsNames.BRAND)
        String brand,
        @JsonProperty(ConstantsNames.CATEGORY)
        String category,
        @JsonProperty(ConstantsNames.THUMBNAIL)
        String thumbnail,
        @JsonProperty(ConstantsNames.IMAGES)
        List<String> images) {
}
