@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.android.library")
}

android {
    namespace = "com.rosan.hidden_api"
    compileSdk = 35

    defaultConfig {
        minSdk = 34
    }
}

dependencies {
}