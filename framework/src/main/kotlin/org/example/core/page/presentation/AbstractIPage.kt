package org.example.core.page.presentation

import org.example.core.dispatcher.IIntentDispatcher
import javax.swing.JPanel

abstract class AbstractIPage(val title: String?, private val controller: AbstractController?) {
    val panel: JPanel?
        get() = controller?.layout

    fun setIntentDispatcher(dispatcher: IIntentDispatcher?) {
        controller?.setIntentDispatcher(dispatcher)
    }
}