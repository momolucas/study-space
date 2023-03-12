package momolucas.alura_compose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import momolucas.alura_compose.model.Product
import momolucas.alura_compose.sampledata.sampleProducts
import momolucas.alura_compose.ui.theme.StudySamplesTheme

@Composable
fun ProductSection(title: String, products: List<Product>) {
    Column {
        Text(
            text = title,
            Modifier.padding(start = 16.dp, bottom = 12.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        LazyRow(
            Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(products) { product ->
                ProductItem(product = product)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductSectionPreview() {
    StudySamplesTheme {
        Surface {
            ProductSection("Promoções", products = sampleProducts)
        }
    }
}

