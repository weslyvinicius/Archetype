package org.archetype_project.presentation.response;

import java.util.List;

public record ProductResponse(
        String id,
        String title,
        String description,
        String price,
        String discountPercentage,
        String rating,
        String stock,
        String brand,
        String category,
        String thumbnail,
        List<String> images) {
}
