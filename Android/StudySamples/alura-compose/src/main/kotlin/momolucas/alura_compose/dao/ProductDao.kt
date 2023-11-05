package momolucas.alura_compose.dao

import androidx.compose.runtime.mutableStateListOf
import momolucas.alura_compose.model.Product

class ProductDao {

    companion object {
        private val products = mutableStateListOf<Product>()
    }

    fun products() = products.toList()

    fun save(product: Product){
        products.add(product)
    }
}