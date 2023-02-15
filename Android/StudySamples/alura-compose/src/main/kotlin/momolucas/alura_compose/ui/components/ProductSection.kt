package momolucas.alura_compose.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import momolucas.alura_compose.model.Product
import momolucas.alura_compose.sampledata.sampleProducts

@Composable
fun ProductSection(title: String, products: List<Product>) {
    Column {
        Text(
            text = title,
            Modifier.padding(start = 16.dp, bottom = 12.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        Row(
            Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(Modifier)
            for (p in products) {
                ProductItem(product = p)
            }
            Spacer(Modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductSectionPreview() {
    ProductSection("Promoções", sampleProducts)
}
