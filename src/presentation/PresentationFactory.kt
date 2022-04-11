package presentation

import presentation.utils.Formatter

interface PresentationFactory<T> {
    fun getPresentationFormat(format: PresentationFormat): Formatter<T>
}