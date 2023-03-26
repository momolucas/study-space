import org.gradle.api.artifacts.dsl.DependencyHandler

object Libraries {
    fun DependencyHandler.baseImplementation(){
        add("implementation", "androidx.appcompat:appcompat:${Base.appCompat}")
        add("implementation", "androidx.core:core-ktx:${Base.coreKtx}")
        add("implementation", "androidx.lifecycle:lifecycle-runtime-ktx:${Base.lifecycleKtx}")
    }

    fun DependencyHandler.composeImplementation(){
        add("implementation", "androidx.activity:activity-compose:${Compose.activity}")
        add("implementation", "androidx.compose.ui:ui:${Compose.ui}")
        add("implementation", "androidx.compose.ui:ui-tooling-preview:${Compose.ui}")
        add("implementation", "androidx.compose.material:material:${Compose.material}")
        add("debugImplementation", "androidx.compose.ui:ui-tooling:${Compose.ui}")
        add("debugImplementation", "androidx.compose.ui:ui-test-manifest:${Compose.ui}")
    }

    fun DependencyHandler.materialImplementation(){
        add("implementation", "com.google.android.material:material:${Base.material}")
    }
}