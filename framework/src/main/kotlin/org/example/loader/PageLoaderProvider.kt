package org.example.loader

import org.example.core.intent.IIntent
import org.example.core.loader.IPageLoader
import org.example.core.page.presentation.AbstractIPage

class PageLoaderProvider private constructor(private val pageLoader: IPageLoader?) {
    class PageLoaderBuilder {
        private val pageDispatcher: PageDispatcher = PageDispatcher()
        private val intentDispatcher: IntentDispatcher =
            IntentDispatcher(pageDispatcher)
        private val registry: PageRegistry = PageRegistry()

        fun register(
            intent: IIntent?,
            page: AbstractIPage
        ): PageLoaderBuilder {
            page.setIntentDispatcher(intentDispatcher)
            registry.register(intent, page)
            return this
        }

        fun build(): PageLoaderProvider {
            val pageLoader: IntentDrivenPageLoader =
                IntentDrivenPageLoader(registry)
            pageDispatcher.register(pageLoader)
            return PageLoaderProvider(pageLoader)
        }
    }

    fun getPageLoader(): IPageLoader? {
        return pageLoader
    }

    companion object {
        fun builder(): PageLoaderBuilder {
            return PageLoaderBuilder()
        }
    }
}
