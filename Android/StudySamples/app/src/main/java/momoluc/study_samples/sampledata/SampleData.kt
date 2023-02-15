package momoluc.study_samples.sampledata

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import momoluc.study_samples.R
import momoluc.study_samples.model.Product
import java.math.BigDecimal

val sampleProducts = listOf(
    Product(
        name = LoremIpsum(50).values.first(),
        price = BigDecimal("14.99"),
        image = R.drawable.burger
    ),
    Product(
        name = LoremIpsum(50).values.first(),
        price = BigDecimal("14.99"),
        image = R.drawable.pizza
    ),
    Product(
        name = LoremIpsum(50).values.first(),
        price = BigDecimal("14.99"),
        image = R.drawable.fries
    )
)