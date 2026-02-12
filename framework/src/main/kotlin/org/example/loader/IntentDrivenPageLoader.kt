package org.example.loader

import org.example.core.intent.IIntent
import org.example.core.loader.IPageLoader
import org.example.core.page.presentation.AbstractIPage
import org.example.core.page.presentation.NavigationFrame

internal class IntentDrivenPageLoader(private val pageRegistry: PageRegistry) : IPageLoader {
    private var frame: NavigationFrame? = null

    override fun start(
        mainFrame: NavigationFrame?,
        intent: IIntent?
    ) {
        this.frame = mainFrame
        show(intent)
    }

    override fun show(intent: IIntent?) {
        println(pageRegistry.get(intent))
        val page: AbstractIPage = pageRegistry.get(intent) ?: return
        frame?.injectContents(page)
    }
}