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
import momolucas.alura_compose.sampledata.sampleCandies
import momolucas.alura_compose.sampledata.sampleDrinks
import momolucas.alura_compose.sampledata.sampleProducts
import momolucas.alura_compose.sampledata.sampleSections
import momolucas.alura_compose.ui.components.CardProductItem
import momolucas.alura_compose.ui.components.ProductSection
import momolucas.alura_compose.ui.components.SearchTextField
import momolucas.alura_compose.ui.theme.StudySamplesTheme

class HomeScreenUiState(
    val sections: Map<String, List<Product>>,
    val searchedProducts: List<Product> = emptyList(),
    val searchText: String = "",
    val onSearchChange: (String) -> Unit = {}
) {
    fun isShowActions() = searchText.isBlank()
}


@Composable
fun HomeScreen(products: List<Product>) {
    val sections = mapOf(
        "Todos os produtos" to products,
        "Promoções" to sampleDrinks + sampleCandies,
        "Doces" to sampleCandies,
        "Bebidas" to sampleDrinks
    )

    var text by remember { mutableStateOf("") }

    fun containsInNameOrDescription() = { product: Product ->
        product.name.contains(text, ignoreCase = true)
                || product.description.contains(text, ignoreCase = true)
    }

    val searchedProducts =
        if (text.isNotBlank()) {
            sampleProducts.filter(containsInNameOrDescription()) +
                    products.filter(containsInNameOrDescription())
        } else {
            emptyList()
        }

    val state = remember(products, text) {
        HomeScreenUiState(
            sections = sections,
            searchedProducts = searchedProducts,
            searchText = text,
            onSearchChange = {
                text = it
            }
        )
    }
    HomeScreen(state = state)
}

@Composable
fun HomeScreen(
    state: HomeScreenUiState
) {
    Column {
        SearchTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = state.searchText,
            onValueChange = state.onSearchChange
        )
        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (state.isShowActions()) {
                for (section in state.sections) {
                    item {
                        ProductSection(title = section.key, products = section.value)
                    }
                }
            } else {
                items(state.searchedProducts) {
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
            HomeScreen(HomeScreenUiState(sampleSections))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenSearchPreview() {
    StudySamplesTheme {
        Surface {
            HomeScreen(HomeScreenUiState(sampleSections, searchText = "a"))
        }
    }
}