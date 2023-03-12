package momolucas.alura_compose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import momolucas.alura_compose.R
import momolucas.alura_compose.extensions.toBrazilianCurrency
import momolucas.alura_compose.model.Product
import momolucas.alura_compose.sampledata.sampleProducts
import momolucas.alura_compose.ui.theme.Indigo400Light

@Composable
fun CardProductItem(
    product: Product,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(4.dp),
        elevation = 4.dp,
        modifier = modifier
    ) {
        Column {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                placeholder = painterResource(id = R.drawable.placeholder),
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(100.dp)
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .heightIn(65.dp)
                    .background(Indigo400Light)
                    .padding(16.dp)
            ) {
                Text(text = product.name)
                Text(text = product.price.toBrazilianCurrency())
            }
            if (product.description.isNotBlank()) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(85.dp)
                        .padding(16.dp),
                    text = product.description
                )
            }
        }
    }
}

@Preview
@Composable
fun CardProductItemPreview() {
    CardProductItem(product = sampleProducts.random())
}


