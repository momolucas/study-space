package momoluc.study_samples.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import momoluc.study_samples.R
import momoluc.study_samples.model.Product
import momoluc.study_samples.sampledata.sampleProducts
import momoluc.study_samples.ui.components.ProductSection
import java.math.BigDecimal

@Composable
fun HomeScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(Modifier)
        ProductSection("Promoções", sampleProducts)
        ProductSection(
            "Doces", listOf(
                Product(
                    name = "Chocolate",
                    price = BigDecimal("5.0"),
                    image = R.drawable.placeholder
                )
            )
        )
        ProductSection(
            "Bebidas", sampleProducts
        )
        Spacer(Modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenreview() {
    HomeScreen()
}