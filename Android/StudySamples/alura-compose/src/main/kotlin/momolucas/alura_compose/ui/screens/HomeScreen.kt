package momolucas.alura_compose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import momolucas.alura_compose.model.Product
import momolucas.alura_compose.sampledata.sampleProducts
import momolucas.alura_compose.sampledata.sampleSections
import momolucas.alura_compose.ui.components.CardProductItem
import momolucas.alura_compose.ui.components.ProductSection
import momolucas.alura_compose.ui.components.SearchTextField
import momolucas.alura_compose.ui.theme.StudySamplesTheme

@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>
) {
    Column {
        var text by remember { mutableStateOf("") }
        SearchTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = text,
            onValueChange = {
                text = it
            }
        )
        val searchedProducts = remember(text) {
            if (text.isNotBlank()) {
                sampleProducts.filter {
                    it.name.contains(text, ignoreCase = true)
                            || it.description.contains(text, ignoreCase = true)
                }
            } else {
                emptyList()
            }
        }
        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (text.isNullOrBlank()) {
                for (section in sections) {
                    item {
                        ProductSection(title = section.key, products = section.value)
                    }
                }
            } else {
                items(searchedProducts) {
                    CardProductItem(product = it, Modifier.padding(horizontal = 16.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    StudySamplesTheme {
        Surface {
            HomeScreen(sampleSections)
        }
    }
}